package org.acaree.core.service;
import jakarta.persistence.OptimisticLockException;
import lombok.Getter;
import lombok.Setter;
import org.acaree.core.exceptions.*;
import org.acaree.core.model.*;
import org.acaree.core.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Service for the Appointment class.
 * <p>
 *     This class is used to access the database for the Appointment class.
 *     </p>
 *     <p>
 *         This class is used by the AppointmentController class.
 *         </p>
 */

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    private final TimeSlotService timeSlotService;

    private final PatientService patientService;

    private final DoctorService doctorService;
    @Autowired
    private final AppointmentNotificationPublisher appointmentNotificationPublisher;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository,
    TimeSlotService timeSlotService, PatientService PatientService,
        DoctorService doctorService,
    AppointmentNotificationPublisher appointmentNotificationPublisher) {
        this.appointmentRepository = appointmentRepository;
        this.timeSlotService = timeSlotService;
        this.patientService = PatientService;
        this.doctorService = doctorService;
        this.appointmentNotificationPublisher = appointmentNotificationPublisher;
    }

    //== public methods ==

    /** bookAppointmentByPatient method.
     * Book an appointment by patient.
     * <p>This method is used to book an appointment by patient.</p>
     * <p>This method is used by the AppointmentController class.</p>
     * @param patientId the patient id
     * @param reason the reason
     * @param timeSlotId the time slot id
     * @return the appointment
     * @throws AppointmentBookingException the appointment booking exception
     * @throws PatientException the patient exception
     * @throws TimeSlotException the time slot exception
     * @Transactional annotation to book the appointment for the database as a transaction
     */

    @Transactional
    public Appointment bookAppointmentByPatient(long patientId, String reason, long timeSlotId)
    throws AppointmentBookingException, PatientException, TimeSlotException{
        if (patientId < 0 || reason == null || timeSlotId < 0) {
            throw new AppointmentBookingException("Invalid appointment details");
        }

        Patient patient = patientService.getPatientById(patientId)
                .orElseThrow(() -> new PatientException("Patient with ID: " + patientId + " not found"));

        TimeSlot timeSlot = timeSlotService.findAvailableTimeSlot(timeSlotId)
                .orElseThrow(() -> new TimeSlotException("Time slot with ID: " + timeSlotId + " not found or already booked"));

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setReason(reason);
        appointment.setTimeSlot(timeSlot);
        appointment.setBooked(false); // Not booked until a doctor is assigned

        appointmentRepository.save(appointment);

        return appointment;
    }

    /** Schedule an appointment to a doctor by admin.
     * <p>This method is used to schedule an appointment to a doctor by admin.</p>
     * <p>This method is used by the AppointmentController class.</p>
     *@param patientId the patient id
     *@param doctorId the doctor id
     *@param appointmentId the appointment id
     *@param timeSlotId the time slot id
     *@throws AppointmentBookingException the appointment booking exception
     *@throws PatientException the patient exception
     *@throws DoctorException the doctor exception
     *@throws TimeSlotException the time slot exception
     */

    @Transactional
    public void assignDoctorToAppointment(long appointmentId, long patientId, long doctorId, long timeSlotId)
    throws AppointmentBookingException, PatientException, DoctorException, TimeSlotException{
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentBookingException("Appointment not found"));
        Patient patient = patientService.getPatientById(patientId)
                .orElseThrow(() -> new PatientException("Patient not found"));

        Doctor doctor = doctorService.getDoctorById(doctorId)
                .orElseThrow(() -> new DoctorException("Doctor not found"));

        TimeSlot timeSlot = timeSlotService.findAvailableTimeSlot(timeSlotId)
                .orElseThrow(() -> new TimeSlotException("Time slot not available"));

        timeSlot.setBooked(true); // Mark the time slot as booked
        timeSlotService.saveTimeSlot(timeSlot);

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setTimeSlot(timeSlot);
        appointment.setBooked(true);
        appointmentRepository.save(appointment);

        // Publish the appointment notification
        AppointmentNotificationMessage message = getAppointmentNotificationMessage(appointment);
        appointmentNotificationPublisher.publishMessage("appointment", message);
    }

    /**
     * Reschedule an appointment.
     * <p>This method is used to reschedule an appointment.</p>
     * <p>This method is used by the AppointmentController class.</p>
     * @param appointmentId the appointment id
     * @param timeSlotId the time slot id
     * @param reasonForChange the reason for change
     * @return the appointment
     */

    @Transactional
    public Appointment rescheduleAppointment(long appointmentId, String reasonForChange, long timeSlotId)
            throws AppointmentBookingException, BookingCancelException, TimeSlotException,
            OptimisticLockException {
        if (appointmentId < 0 || reasonForChange == null || reasonForChange.isEmpty()) {
            throw new AppointmentBookingException("Invalid details");
        }

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentBookingException("Appointment not found"));

        if (!appointment.isBooked()) {
            throw new BookingCancelException("Appointment not scheduled or already cancelled");
        }

        TimeSlot newTimeSlot = timeSlotService.findAvailableTimeSlot(timeSlotId)
                .orElseThrow(() -> new TimeSlotException("Time slot not available"));

        // Free the old time slot
        TimeSlot oldTimeSlot = appointment.getTimeSlot();
        if (oldTimeSlot != null) {
            oldTimeSlot.setBooked(false);
            timeSlotService.saveTimeSlot(oldTimeSlot);
        }

        long patientId = appointment.getPatient().getId();
        Patient patient = patientService.getPatientById(patientId)
                .orElseThrow(() -> new PatientException("Patient not found"));

        newTimeSlot.setBooked(true); // Mark the time slot as booked
        timeSlotService.saveTimeSlot(newTimeSlot);

        // Only update the time slot and reason
        appointment.setPatient(patient);
        appointment.setReason(reasonForChange);
        appointment.setTimeSlot(newTimeSlot);

        // Send a rescheduling notification
        AppointmentNotificationMessage message = sendAppointmentReschedule(appointment);
        appointmentNotificationPublisher.publishMessage("appointment", message);

        return appointmentRepository.save(appointment);
    }

    /**
     * Cancel an appointment.
     * <p>This method is used to cancel an appointment.</p>
     * <p>This method is used by the AppointmentController class.</p>
     * @param appointmentId the appointment id
     * @throws AppointmentBookingException the appointment booking exception
     * @throws BookingCancelException the booking cancel exception
     * @return boolean
     */

    @Transactional
    public boolean cancelAppointment(long appointmentId) throws AppointmentBookingException, BookingCancelException {
        // Input validation
        if (appointmentId < 0) {
            throw new AppointmentBookingException("Invalid appointment id");
        }
        // Get the appointment from the database
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentBookingException("Appointment not found"));

        // Check if the appointment is already cancelled
        if (!appointment.isBooked()) {
            throw new BookingCancelException("Appointment not scheduled or already cancelled");

        }

        // Cancel the appointment
        appointment.setBooked(false);
        appointmentRepository.save(appointment);

        // Free the time slot
        TimeSlot timeSlot = appointment.getTimeSlot();
        if (timeSlot != null) {
            timeSlot.setBooked(false);
            timeSlotService.saveTimeSlot(timeSlot);
        }

        // Publish the appointment cancellation notification
        AppointmentNotificationMessage message = sendAppointmentCancellation(appointment);
        appointmentNotificationPublisher.publishMessage("appointment", message);

        return true;

        // Additional logic for audit trail or notification
    }

    /**
     * Update an appointment.
     * <p>This method is used to update an appointment.</p>
     * <p>This method is used by the AppointmentController class.</p>
     * @param updateDTO the appointment update dto
     * @return the appointment
     * @throws AppointmentBookingException the appointment booking exception
     * @Transactional annotation to update the appointment for the database as a transaction
     */

    @Transactional
    public Appointment updateAppointment(AppointmentUpdateDTO updateDTO) throws AppointmentBookingException {
    // Input validation
    if (Objects.isNull(updateDTO)) {
        throw new AppointmentBookingException("Invalid appointment details");
    }
    long appointmentId = updateDTO.getId();
    if (appointmentId < 0) {
        throw new AppointmentBookingException("Invalid appointment id");
    }

    // Retrieve the existing appointment
    Appointment appointment = appointmentRepository.findById(appointmentId)
            .orElseThrow(() -> new AppointmentBookingException("Appointment not found"));

    // Update the appointment details
    appointment.setReason(updateDTO.getReason());
    appointment.setBooked(updateDTO.isBooked());

    // Update the patient
    long patientId = updateDTO.getPatientId();
    Optional<Patient> patient = patientService.getPatientById(patientId);

    appointment.setPatient(patient.orElse(null));

    // Update the doctor
    long doctorId = updateDTO.getDoctorId();
    Optional<Doctor> doctor = doctorService.getDoctorById(doctorId);
    appointment.setDoctor(doctor.orElse(null));

    // Update the time slot
        // Update the time slot
        long timeSlotId = updateDTO.getTimeSlotId();
        if (appointment.getTimeSlot() == null || appointment.getTimeSlot().getId() != timeSlotId) {
            Optional<TimeSlot> timeSlot = timeSlotService.findAvailableTimeSlot(timeSlotId);
            if (timeSlot.get().isBooked() && !isTimeSlotCurrentlyAssignedToAppointment(appointment, timeSlot.get())) {
                throw new TimeSlotException("Time slot not available");
            }
            appointment.setTimeSlot(timeSlot.get());
        }

        // Save the updated appointment
        return appointmentRepository.save(appointment);

}

    /**
     * Get an appointment by id.
     * @param appointmentId the appointment id
     * @return the appointment
     * @Trasactional annotation to get the appointment for the database as a transaction
     * read only annotation to get the appointment for the database as a read only transaction
     */
    @Transactional(readOnly = true)
    public Appointment getAppointment(long appointmentId) throws AppointmentBookingException {
        if (appointmentId < 0) {
            throw new AppointmentBookingException("Invalid appointment id");
        }
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentBookingException("Appointment not found"));



    }

    /**
     * Get all appointments.
     * @return the list of appointments
     * @Transactional annotation to get all appointments for the database as a transaction
     * read only annotation to get all appointments for the database as a read only transaction
     */

    @Transactional(readOnly = true)
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();


    }

    /**
     * Get all appointments by doctor id.
     * @param doctorId the doctor id
     * @return the list of appointments for the doctor
     * @Transactional annotation to get all appointments by doctor id for the database as a transaction
     * read only annotation to get all appointments by doctor id for the database as a read only transaction
     */

    @Transactional(readOnly = true)
    public List<Appointment> getAllAppointmentsByDoctorId(long doctorId) throws AppointmentBookingException {
        if (doctorId < 0) {
            throw new AppointmentBookingException("Invalid doctor id");
        }
        return appointmentRepository.findDoctorAppointment(doctorId);


    }


    /**
     * Get all appointments by patient id.
     * @param patientId the patient id
     * @return the list of appointments for the patient
     * @Transactional annotation to get all appointments by patient id for the database as a transaction
     */


    @Transactional(readOnly = true)
    public List<Appointment> getAllAppointmentsByPatientId(long patientId) throws AppointmentBookingException {
        if (patientId < 0) {
            throw new AppointmentBookingException("Invalid patient id");
        }
        return appointmentRepository.findPatientAppointment(patientId);

    }

    //== private methods ==

    /** isTimeSlotCurrentlyAssignedToAppointment method.
     * Check if the time slot is currently assigned to the appointment.
     * <p>This method is used to check if the time slot is currently assigned to the appointment.</p>
     * <p>This method is used by the AppointmentController class.</p>
     * @param appointment the appointment
     * @param timeSlot the time slot
     * @return boolean
     */

    private boolean isTimeSlotCurrentlyAssignedToAppointment(Appointment appointment, TimeSlot timeSlot) {
        return appointment.getTimeSlot() != null && appointment.getTimeSlot().getId() == timeSlot.getId();
    }

    /** getAppointmentNotificationMessage method.
     * Get the appointment notification message.
     * <p>This method is used to get the appointment notification message.</p>
     * <p>This method is used by the AppointmentController class.</p>
     * @param appointment the appointment
     * @return the appointment notification message
     */

    protected AppointmentNotificationMessage getAppointmentNotificationMessage(Appointment appointment) {
        Objects.requireNonNull(appointment);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy 'at' h:mm a");
        String formattedStartTime = appointment.getTimeSlot().getStartTime().format(formatter);

        StringBuilder text = new StringBuilder();
        text.append("Hi ");
        text.append("Your appointment has been booked for: ");
        text.append(appointment.getTimeSlot().getStartTime().getDayOfWeek());
        text.append("at: ");
        text.append(formattedStartTime);
        text.append("Thanks for using our service. ");
        text.append("We look forward to seeing you.");

        final var message = getNotificationMessage(appointment, text.toString());

        return message;
    }

    /** getNotificationMessage method.
     * Get the notification message.
     * <p>This method is used to get the notification message.</p>
     * <p>This method is used by the AppointmentController class.</p>
     * @param appointment the appointment
     * @param text the text
     * @return the notification message
     */

    protected AppointmentNotificationMessage getNotificationMessage(Appointment appointment, String text) {
        if (Objects.isNull(appointment) || text == null || text.isEmpty()) {
            throw new NotificationException("Invalid appointment or text");
        }
        if (appointment.getPatient() == null) {
            throw new IllegalStateException("Appointment does not have a patient associated with it.");
        }
        AppointmentNotificationMessage message = new AppointmentNotificationMessage();
        message.setAppointmentId(appointment.getId());
        message.setPatientId(appointment.getPatient().getId());
        message.setDoctorId(appointment.getDoctor().getId());
        message.setMessage(text);
        return message;
    }

    /** sendAppointmentReminder method.
     * Send an appointment reminder.
     * <p>This method is used to send an appointment reminder.</p>
     * <p>This method is used by the AppointmentController class.</p>
     * @param appointment the appointment
     * @return the appointment notification message
     */

    protected AppointmentNotificationMessage sendAppointmentReminder(Appointment appointment) {
        Objects.requireNonNull(appointment, "Invalid appointment");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime appointmentTime = appointment.getTimeSlot().getStartTime();
        long minutesUntilAppointment = Duration.between(now, appointmentTime).toMinutes();

        String text = "Hi, You have an upcoming appointment in: " + minutesUntilAppointment + " minutes. We look forward to seeing you.";
        return getNotificationMessage(appointment, text);
    }


    /** sendAppointmentCancellation method.
     * Send an appointment cancellation.
     * <p>This method is used to send an appointment cancellation.</p>
     * <p>This method is used by the AppointmentController class.</p>
     * @param appointment the appointment
     * @return the appointment notification message
     */
    protected AppointmentNotificationMessage sendAppointmentCancellation(Appointment appointment) {
        Objects.requireNonNull(appointment, "Invalid appointment");
        StringBuilder text = new StringBuilder();
        text.append("Hi ");
        text.append("Your appointment has been cancelled.");
        text.append("We are sorry for any inconvenience. caused.");

        final var message = getNotificationMessage(appointment, text.toString());

        return message;
    }

    /** sendAppointmentReschedule method.
     * Send an appointment reschedule.
     * <p>This method is used to send an appointment reschedule.</p>
     * <p>This method is used by the AppointmentController class.</p>
     * @param appointment the appointment
     * @return the appointment notification message
     */
    protected AppointmentNotificationMessage sendAppointmentReschedule(Appointment appointment) {
        Objects.requireNonNull(appointment, "Invalid appointment");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy 'at' h:mm a");
        String formattedStartTime = appointment.getTimeSlot().getStartTime().format(formatter);

        StringBuilder text = new StringBuilder();
        text.append("Hi ");
        text.append("Your appointment has been rescheduled to: ");
        text.append(appointment.getTimeSlot().getStartTime().getDayOfWeek());
        text.append("at: ");
        text.append(formattedStartTime);
        text.append("We look forward to seeing you.");


        final var message = getNotificationMessage(appointment, text.toString());

        return message;
    }




    //== inner class ==
    /**
     * The type Appointment update dto (data transfer object).
     * <p>This class is used to update an appointment.</p>
     */
    @Getter @Setter
    public static final class AppointmentUpdateDTO{
        private long id;
        private String reason;
        private long timeSlotId;
        private long patientId;
        private long doctorId;
        private boolean booked;

        public AppointmentUpdateDTO(long id, String reason, long timeSlotId, long patientId, long doctorId, boolean booked) {
            this.id = id;
            this.reason = reason;
            this.timeSlotId = timeSlotId;
            this.patientId = patientId;
            this.doctorId = doctorId;
            this.booked = booked;
        }



    }




}
