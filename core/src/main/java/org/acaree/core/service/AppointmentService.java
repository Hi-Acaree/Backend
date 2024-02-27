package org.acaree.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.OptimisticLockException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.dto.AppointmentBookingDTO;
import org.acaree.core.dto.AppointmentDTO;
import org.acaree.core.exceptions.*;
import org.acaree.core.model.*;
import org.acaree.core.repository.AppointmentRepository;
import org.acaree.core.repository.PatientRepository;
import org.acaree.core.util.ErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service class for Appointment entity
 * <p> This class is responsible for all the business logic related to Appointment entity</p>
 */

@Service
@Slf4j
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final TimeSlotService timeSlotService;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final AppointmentNotificationPublisher appointmentNotificationPublisher;
    private final ObjectMapper objectMapper;
    private final PatientRepository patientRepository;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, TimeSlotService timeSlotService,
                              PatientService patientService, DoctorService doctorService,
                              AppointmentNotificationPublisher appointmentNotificationPublisher,
                              ObjectMapper objectMapper, PatientRepository patientRepository,
                              SimpMessagingTemplate simpMessagingTemplate) {
        this.appointmentRepository = appointmentRepository;
        this.timeSlotService = timeSlotService;
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.appointmentNotificationPublisher = appointmentNotificationPublisher;
        this.objectMapper = objectMapper;
        this.patientRepository = patientRepository;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    //== public methods ==

    /**
     * This method is used to book an appointment by a patient
     * @param bookingDTO The details of the appointment to be booked
     * @return The appointment that has been booked
     * @throws AppointmentBookingException if the appointment details are invalid
     * @throws PatientException if the patient details are invalid
     * @throws TimeSlotException if the time slot details are invalid
     * @throws JsonProcessingException if there is an error processing the JSON
     */

    @Transactional
    public Appointment bookAppointmentByPatient(AppointmentBookingDTO bookingDTO)
            throws AppointmentBookingException, PatientException, TimeSlotException, JsonProcessingException {
        if (Objects.isNull(bookingDTO)) {
            throw new AppointmentBookingException("Invalid appointment details", ErrorType.APPOINTMENT_INVALID_INPUT);
        }

        Patient patient = patientService.ensureTemporaryRecordOfPatient(bookingDTO.getEmail());
        long timeSlotId = bookingDTO.getTimeSlotId();
        TimeSlot timeSlot = timeSlotService.findAvailableTimeSlot(timeSlotId)
                .orElseThrow(() -> new TimeSlotException("Time slot with ID: " + timeSlotId + " not found or already booked",
                        ErrorType.TIMESLOT_NOT_FOUND));
        Doctor doctor = doctorService.getDoctorById(bookingDTO.getDoctorId())
                .orElseThrow(() -> new DoctorException("Doctor with Id " + bookingDTO.getDoctorId() + " not found",
                        ErrorType.DOCTOR_NOT_FOUND));

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setReason(bookingDTO.getReason());
        appointment.setTimeSlot(timeSlot);
        appointment.setType(bookingDTO.getType());
        appointment.setBooked(true);

        appointment = appointmentRepository.save(appointment);

        AppointmentNotificationMessage message = getAppointmentNotificationMessage(appointment);
        String messageJson = objectMapper.writeValueAsString(message);
        appointmentNotificationPublisher.publishMessage("appointment-queue", messageJson);

        simpMessagingTemplate.convertAndSend("/topic/newAppointment", messageJson);
        return appointment;
    }

    /**
     * This method is used to assign a doctor to an appointment
     * @param appointmentId The ID of the appointment
     * @param doctorId The ID of the doctor
     * @param timeSlotId The ID of the time slot
     * @throws AppointmentBookingException if the appointment details are invalid
     * @throws DoctorException if the doctor details are invalid
     * @throws TimeSlotException if the time slot details are invalid
     * @throws JsonProcessingException if there is an error processing the JSON
     */

    @Transactional
    public void assignDoctorToAppointment(long appointmentId, long doctorId, long timeSlotId)
            throws AppointmentBookingException, DoctorException, TimeSlotException, JsonProcessingException {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentBookingException("Appointment with ID " + appointmentId + " not found",
                        ErrorType.APPOINTMENT_NOT_FOUND));

        Doctor doctor = doctorService.getDoctorById(doctorId)
                .orElseThrow(() -> new DoctorException("Doctor with ID " + doctorId + " not found", ErrorType.DOCTOR_NOT_FOUND));

        TimeSlot timeSlot = timeSlotService.findAvailableTimeSlot(timeSlotId)
                .orElseThrow(() -> new TimeSlotException("Time slot with ID " + timeSlotId + " not available or already booked",
                        ErrorType.TIMESLOT_NOT_FOUND));

        timeSlot.setBooked(true);
        timeSlotService.saveTimeSlot(timeSlot);

        appointment.setDoctor(doctor);
        appointment.setTimeSlot(timeSlot);
        appointment.setBooked(true);
        appointmentRepository.save(appointment);

        AppointmentNotificationMessage message = getAppointmentNotificationMessage(appointment);
        String messageJson = objectMapper.writeValueAsString(message);
        appointmentNotificationPublisher.publishMessage("appointment-queue", messageJson);
    }

    /**
     * This method is used to reschedule an appointment
     * @param appointmentId The ID of the appointment
     * @param reasonForChange The reason for the change
     * @param timeSlotId The ID of the time slot
     * @return The rescheduled appointment
     * @throws AppointmentBookingException if the appointment details are invalid
     * @throws BookingCancelException if the booking cannot be cancelled
     * @throws TimeSlotException if the time slot details are invalid
     * @throws OptimisticLockException if there is an optimistic lock exception
     * @throws JsonProcessingException if there is an error processing the JSON
     */

    @Transactional
    public Appointment rescheduleAppointment(long appointmentId, String reasonForChange, long timeSlotId)
            throws AppointmentBookingException, BookingCancelException, TimeSlotException, OptimisticLockException, JsonProcessingException {
        if (appointmentId < 0 || reasonForChange == null || reasonForChange.isEmpty()) {
            throw new AppointmentBookingException("Invalid details", ErrorType.APPOINTMENT_INVALID_INPUT);
        }

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentBookingException("Appointment not found", ErrorType.APPOINTMENT_NOT_FOUND));

        if (!appointment.isBooked()) {
            throw new BookingCancelException("Appointment not scheduled or already cancelled", ErrorType.CANCEL_NOT_AVAILABLE);
        }

        TimeSlot newTimeSlot = timeSlotService.findAvailableTimeSlot(timeSlotId)
                .orElseThrow(() -> new TimeSlotException("Time slot not available", ErrorType.TIMESLOT_NOT_AVAILABLE));

        // Free the old time slot
        TimeSlot oldTimeSlot = appointment.getTimeSlot();
        if (oldTimeSlot != null) {
            oldTimeSlot.setBooked(false);
            timeSlotService.saveTimeSlot(oldTimeSlot);
        }

        newTimeSlot.setBooked(true); // Mark the time slot as booked
        timeSlotService.saveTimeSlot(newTimeSlot);

        appointment.setReason(reasonForChange);
        appointment.setTimeSlot(newTimeSlot);

        // Send a rescheduling notification
        AppointmentNotificationMessage message = sendAppointmentReschedule(appointment);
        String messageJson = objectMapper.writeValueAsString(message);
        appointmentNotificationPublisher.publishMessage("appointment-queue", messageJson);

        return appointmentRepository.save(appointment);
    }

    /**
     * This method is used to cancel an appointment
     * @param appointmentId The ID of the appointment
     * @return true if the appointment is cancelled, false otherwise
     * @throws AppointmentBookingException if the appointment details are invalid
     * @throws BookingCancelException if the booking cannot be cancelled
     * @throws JsonProcessingException if there is an error processing the JSON
     */

    @Transactional
    public boolean cancelAppointment(long appointmentId) throws AppointmentBookingException, BookingCancelException, JsonProcessingException {
        if (appointmentId < 0) {
            throw new AppointmentBookingException("Invalid appointment id", ErrorType.APPOINTMENT_INVALID_INPUT);
        }

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentBookingException("Appointment not found", ErrorType.APPOINTMENT_NOT_FOUND));

        if (!appointment.isBooked()) {
            throw new BookingCancelException("Appointment not scheduled or already cancelled", ErrorType.CANCEL_NOT_AVAILABLE);
        }

        appointment.setBooked(false);
        appointmentRepository.save(appointment);

        TimeSlot timeSlot = appointment.getTimeSlot();
        if (timeSlot != null) {
            timeSlot.setBooked(false);
            timeSlotService.saveTimeSlot(timeSlot);
        }

        AppointmentNotificationMessage message = sendAppointmentCancellation(appointment);
        appointmentNotificationPublisher.publishMessage("appointment-queue", objectMapper.writeValueAsString(message));

        return true;
    }

    /**
     * This method is used to update an appointment
     * @param updateDTO The details of the appointment to be updated
     * @return The updated appointment
     * @throws AppointmentBookingException if the appointment details are invalid
     */

    @Transactional
    public Appointment updateAppointment(AppointmentUpdateDTO updateDTO) throws AppointmentBookingException {
        if (Objects.isNull(updateDTO)) {
            throw new AppointmentBookingException("Invalid appointment details", ErrorType.APPOINTMENT_INVALID_INPUT);
        }
        long appointmentId = updateDTO.getId();
        if (appointmentId < 0) {
            throw new AppointmentBookingException("Invalid appointment id", ErrorType.APPOINTMENT_INVALID_INPUT);
        }

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentBookingException("Appointment not found", ErrorType.APPOINTMENT_NOT_FOUND));

        appointment.setReason(updateDTO.getReason());
        appointment.setBooked(updateDTO.isBooked());

        Patient patient = patientService.getPatientById(updateDTO.getPatientId());
        appointment.setPatient(patient);

        Optional<Doctor> doctor = doctorService.getDoctorById(updateDTO.getDoctorId());
        appointment.setDoctor(doctor.orElse(null));

        Optional<TimeSlot> timeSlot = timeSlotService.findAvailableTimeSlot(updateDTO.getTimeSlotId());
        if (timeSlot.isPresent() && (!timeSlot.get().isBooked() || isTimeSlotCurrentlyAssignedToAppointment(appointment, timeSlot.get()))) {
            appointment.setTimeSlot(timeSlot.get());
        } else {
            throw new TimeSlotException("Time slot not available", ErrorType.TIMESLOT_NOT_AVAILABLE);
        }

        return appointmentRepository.save(appointment);
    }

    /**
     * This method is used to get an appointment by its ID
     * @param appointmentId The ID of the appointment
     * @return The appointment
     * @throws AppointmentBookingException if the appointment details are invalid
     */

    @Transactional(readOnly = true)
    public Appointment getAppointment(long appointmentId) throws AppointmentBookingException {
        if (appointmentId < 0) {
            throw new AppointmentBookingException("Invalid appointment id", ErrorType.APPOINTMENT_INVALID_INPUT);
        }
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentBookingException("Appointment not found", ErrorType.APPOINTMENT_NOT_FOUND));
    }

    /**
     * This method is used to get all appointments
     * @return A list of all appointments
     */

    @Transactional(readOnly = true)
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    /**
     * This method is used to get all appointments by doctor ID
     * @param doctorId The ID of the doctor
     * @param pageable for pagination
     * @return A paginated list
     * @throws AppointmentBookingException if the doctor ID is invalid
     */

    @Transactional(readOnly = true)
    public Page<AppointmentDTO> getAllAppointmentsByDoctorId(long doctorId, Pageable pageable) throws AppointmentBookingException {
        if (doctorId < 0) {
            throw new AppointmentBookingException("Invalid doctor id", ErrorType.APPOINTMENT_INVALID_INPUT);
        }
        Page<Appointment> appointmentPage = appointmentRepository.findDoctorAppointment(doctorId, pageable);
        List<AppointmentDTO> DTOs = appointmentPage.getContent()
                .stream()
                .map(AppointmentDTO::from)
                .collect(Collectors.toList());
        return new PageImpl<>(DTOs, pageable, appointmentPage.getTotalElements());
    }


    /**
     * This method is used to get all appointments by patient ID
     * @param patientId The ID of the patient
     * @return A list of all appointments by patient ID
     * @throws AppointmentBookingException if the patient ID is invalid
     */

    @Transactional(readOnly = true)
    public List<Appointment> getAllAppointmentsByPatientId(long patientId) throws AppointmentBookingException {
        if (patientId < 0) {
            throw new AppointmentBookingException("Invalid patient id", ErrorType.APPOINTMENT_INVALID_INPUT);
        }
        return appointmentRepository.findPatientAppointment(patientId);
    }

    /**
     * This method is used to schedule reoccurring appointments
     * @param bookingDTO The details of the appointment to be booked
     * @param numberOfAppointments The number of appointments to be scheduled
     * @param recurrencePeriod The period of recurrence
     * @return A list of all scheduled appointments
     * @throws AppointmentBookingException if the appointment details are invalid
     * @throws PatientException if the patient details are invalid
     * @throws TimeSlotException if the time slot details are invalid
     * @throws JsonProcessingException if there is an error processing the JSON
     */

    @Transactional
    public List<Appointment> scheduleReoccurringAppointments(AppointmentBookingDTO bookingDTO, int numberOfAppointments, Period recurrencePeriod)
            throws AppointmentBookingException, PatientException, TimeSlotException, JsonProcessingException {
        if (bookingDTO == null || numberOfAppointments <= 0) {
            throw new AppointmentBookingException("Invalid appointment details", ErrorType.APPOINTMENT_INVALID_INPUT);
        }

        List<Appointment> appointments = new ArrayList<>();
        LocalDateTime startTime = LocalDateTime.now(); // Assuming starting point. Adjust as necessary.

        for (int i = 0; i < numberOfAppointments; i++) {
            // Assume this method finds or creates a time slot based on the start time and books the appointment accordingly.
            TimeSlot nextTimeSlot = timeSlotService.findOrCreateNextAvailableTimeSlot(startTime, recurrencePeriod);

            // Update the bookingDTO with the new time slot details for the appointment
            bookingDTO.setTimeSlotId(nextTimeSlot.getId());

            Appointment appointment = bookAppointmentByPatient(bookingDTO);
            appointments.add(appointment);

            // Calculate the start time for the next appointment
            startTime = nextTimeSlot.getStartTime().plus(recurrencePeriod);
        }

        return appointments;
    }

    /**
     *
     * @param appointment The appointment whose time slot is to be validated
     * @param timeSlot The time slot to be validated
     * @return true if the time slot is valid, false otherwise
     */



    private boolean isTimeSlotCurrentlyAssignedToAppointment(Appointment appointment, TimeSlot timeSlot) {
        return appointment.getTimeSlot() != null && appointment.getTimeSlot().getId() == timeSlot.getId();
    }

    /**
     * This method is used to get the appointment notification message
     * @param appointment The appointment
     * @return The appointment notification message
     */

    protected AppointmentNotificationMessage getAppointmentNotificationMessage(Appointment appointment) {
        Objects.requireNonNull(appointment, "Appointment cannot be null.");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy 'at' h:mm a");
        String formattedStartTime = appointment.getTimeSlot().getStartTime().format(formatter);
        String doctorName = Optional.ofNullable(appointment.getDoctor())
                .map(doctor -> doctor.getPersonDetails().getFirstName() + " " + doctor.getPersonDetails().getLastName())
                .orElse("Doctor");

        StringBuilder text = new StringBuilder();
        text.append("Hi ");
        text.append(appointment.getPatient().getPersonDetails().getFirstName()).append(", ");
        text.append("Your appointment has been booked for: ");
        text.append(formattedStartTime).append(" ");
        text.append("with: ").append(doctorName).append(". ");
        text.append("Thanks for using our service. We look forward to seeing you.");

        return getNotificationMessage(appointment, text.toString());
    }

    /**
     * This method is used to get the notification message
     * @param appointment The appointment
     * @param text The text of the notification message
     * @return The appointment notification message
     */

    protected AppointmentNotificationMessage getNotificationMessage(Appointment appointment, String text) {
        if (appointment == null || text == null || text.isEmpty()) {
            throw new NotificationException("Invalid appointment or text");
        }
        if (appointment.getPatient() == null) {
            throw new IllegalStateException("Appointment does not have a patient associated with it.");
        }
        String doctorName = appointment.getDoctor() != null ? appointment.getDoctor().getPersonDetails().getFirstName() + " " + appointment.getDoctor().getPersonDetails().getLastName() : "Doctor";
        String email = appointment.getPatient().getPersonDetails().getEmail();
        String appointmentType = appointment.getType() != null ? appointment.getType() : "In-Person Visit";

        return new AppointmentNotificationMessage(doctorName, email, appointmentType, appointment.getTimeSlot(), text);
    }

    /**
     * This method is used to send an appointment reminder
     * @param appointment The appointment
     * @return The appointment notification message
     */

    protected AppointmentNotificationMessage sendAppointmentReminder(Appointment appointment) {
        Objects.requireNonNull(appointment, "Invalid appointment");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime appointmentTime = appointment.getTimeSlot().getStartTime();
        long minutesUntilAppointment = Duration.between(now, appointmentTime).toMinutes();
        String text = "Hi, You have an upcoming appointment in: " + minutesUntilAppointment + " minutes. We look forward to seeing you.";
        return getNotificationMessage(appointment, text);
    }

    /**
     * This method is used to send an appointment cancellation
     * @param appointment The appointment
     * @return The appointment notification message
     */

    protected AppointmentNotificationMessage sendAppointmentCancellation(Appointment appointment) {
        Objects.requireNonNull(appointment, "Invalid appointment");
        String text = "Hi, Your appointment has been cancelled. We are sorry for any inconvenience caused.";
        return getNotificationMessage(appointment, text);
    }

    /**
     * This method is used to send an appointment reschedule
     * @param appointment The appointment
     * @return The appointment notification message
     */

    protected AppointmentNotificationMessage sendAppointmentReschedule(Appointment appointment) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy 'at' h:mm a");
        String formattedStartTime = appointment.getTimeSlot().getStartTime().format(formatter);
        String doctorName = appointment.getDoctor() != null ? appointment.getDoctor().getPersonDetails().getFirstName() + " " + appointment.getDoctor().getPersonDetails().getLastName() : "Doctor";
        String text = "Hi, Your appointment has been rescheduled for: " + formattedStartTime + " with: " + doctorName + ". Thanks for using our service. We look forward to seeing you.";
        return getNotificationMessage(appointment, text);
    }

    /**
     * This method is used to calculate the next appointment time
     * @param currentSlot The current time slot
     * @param recurrencePeriod The period of recurrence
     * @return The next appointment time
     */

    protected TimeSlot calculateNextAppointmentTime(TimeSlot currentSlot, Period recurrencePeriod) {
        Objects.requireNonNull(currentSlot, "Invalid time slot");
        LocalDateTime nextStartTime = currentSlot.getStartTime().plus(recurrencePeriod);
        LocalDateTime nextEndTime = currentSlot.getEndTime().plus(recurrencePeriod);
        // Assuming TimeSlot has a constructor or setters to set these properties.
        return new TimeSlot(nextStartTime, nextEndTime);
    }

    /**
     * This static class is used to represent the appointment booking DTO
     */

    @Getter
    @Setter
    @AllArgsConstructor
    public static final class AppointmentUpdateDTO {
        private long id;
        private String reason;
        private long timeSlotId;
        private long patientId;
        private long doctorId;
        private boolean booked;
    }






}
