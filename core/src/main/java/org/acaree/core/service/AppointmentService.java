package org.acaree.core.service;
import lombok.Getter;
import lombok.Setter;
import org.acaree.core.exceptions.AppointmentBookingException;
import org.acaree.core.exceptions.BookingCancelException;
import org.acaree.core.exceptions.TimeSlotException;
import org.acaree.core.model.Appointment;
import org.acaree.core.model.Doctor;
import org.acaree.core.model.Patient;
import org.acaree.core.model.TimeSlot;
import org.acaree.core.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public AppointmentService(AppointmentRepository appointmentRepository,
    TimeSlotService timeSlotService, PatientService PatientService,
        DoctorService doctorService) {
        this.appointmentRepository = appointmentRepository;
        this.timeSlotService = timeSlotService;
        this.patientService = PatientService;
        this.doctorService = doctorService;
    }

    //== public methods ==
    /**
     * Book an appointment.
     * <p>This method is used to book an appointment.</p>
     * <p>This method is used by the AppointmentController class.</p>
     * @param doctorId the doctor id
     * @param patientId the patient id
     * @param reason the reason for the appointment
     * @param timeSlotId the time slot id
     * @return the appointment
     * @throws AppointmentBookingException the appointment booking exception
     * @throws TimeSlotException the time slot availability exception
     * @Transactional annotation to book the appointment for the database as a transaction
     * return Appointment
     */
    @Transactional
    public Appointment bookAppointment(long doctorId, long patientId, String reason, long timeSlotId)
            throws AppointmentBookingException, TimeSlotException {

        //Input validation
        if (doctorId < 0 || patientId < 0 || reason == null || timeSlotId < 0) {
            throw new AppointmentBookingException("Invalid appointment details");
        }

        //Get the patient and doctor from the database

        Optional<Patient> patient = patientService.getPatientById(patientId);

        Optional<Doctor> doctor = doctorService.getDoctorById(doctorId);

        //Create the appointment
        Appointment appointment = new Appointment();
        appointment.setPatient(patient.orElse(null));
        appointment.setDoctor(doctor.orElse(null));
        appointment.setReason(reason);

        //Check if the time slot is available and book it

        Optional<TimeSlot> optionalTimeSlot = timeSlotService.findAvailableTimeSlot(timeSlotId);

        if (optionalTimeSlot.isPresent()) {
            //Time slot is available
            TimeSlot timeSlot = optionalTimeSlot.orElse(null);

            //Book and save the time slot
            timeSlot.setBooked(true);
            timeSlotService.saveTimeSlot(timeSlot);

            //Set the time slot and save the appointment
            appointment.setTimeSlot(timeSlot);
            appointment.setBooked(true);
            return appointmentRepository.save(appointment);
        } else {
            throw new TimeSlotException("Time slot not available");
        }
    }

    /**
     * Cancel an appointment.
     * <p>This method is used to cancel an appointment.</p>
     * <p>This method is used by the AppointmentController class.</p>
     * @param appointmentId the appointment id
     * @throws AppointmentBookingException the appointment booking exception
     * @throws BookingCancelException the booking cancel exception
     * @Transactional annotation to cancel the appointment for the database as a transaction
     * @return boolean
     */

    @Transactional
    public boolean cancelAppointment(long appointmentId) {
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
    public Appointment updateAppointment(AppointmentUpdateDTO updateDTO) {
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
    public Appointment getAppointment(long appointmentId) {
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
    public List<Appointment> getAllAppointmentsByDoctorId(long doctorId) {
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
    public List<Appointment> getAllAppointmentsByPatientId(long patientId) {
        if (patientId < 0) {
            throw new AppointmentBookingException("Invalid patient id");
        }
        return appointmentRepository.findPatientAppointment(patientId);

    }

    //== private methods ==
    /**
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
