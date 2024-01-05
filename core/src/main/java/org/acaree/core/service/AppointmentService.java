package org.acaree.core.service;

import org.acaree.core.exceptions.AppointmentBookingException;
import org.acaree.core.exceptions.TimeSlotAvailabilityException;
import org.acaree.core.model.Appointment;
import org.acaree.core.model.Doctor;
import org.acaree.core.model.Patient;
import org.acaree.core.model.TimeSlot;
import org.acaree.core.repository.AppointmentRepository;
import org.acaree.core.repository.DoctorRepository;
import org.acaree.core.repository.PatientRepository;
import org.acaree.core.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * Service for the Appointment class.
 * <p>
 *     This class is used to access the database for the Appointment class.
 *     </p>
 *     <p>
 *         This class is used by the AppointmentController class.
 *
 *         </p>
 */

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    private final TimeSlotRepository timeSlotRepository;

    private final PatientRepository patientRepository;

    private final DoctorRepository doctorRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository,
    TimeSlotRepository timeSlotRepository, PatientRepository patientRepository,
        DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.timeSlotRepository = timeSlotRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    //== public methods ==
    /**
     * Book an appointment.
     * <p>
     *     This method is used to book an appointment.
     *     </p>
     *     <p>
     *         This method is used by the AppointmentController class.
     *
     *         </p>
     *
     * @param doctorId the doctor id
     * @param patientId the patient id
     * @param reason the reason for the appointment
     * @param timeSlotId the time slot id
     * @return the appointment
     * @throws AppointmentBookingException the appointment booking exception
     * @throws TimeSlotAvailabilityException the time slot availability exception
     * @Transactional annotation to book the appointment for the database as a transaction
     * return Appointment
     */
    @Transactional
    public Appointment bookAppointment(long doctorId, long patientId, String reason, long timeSlotId)
            throws AppointmentBookingException, TimeSlotAvailabilityException {

        //Input validation
        if (doctorId < 0 || patientId < 0 || reason == null || timeSlotId < 0) {
            throw new AppointmentBookingException("Invalid appointment details");
        }

        //Get the patient and doctor from the database

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new AppointmentBookingException("Patient not found"));
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new AppointmentBookingException("Doctor not found"));

        //Create the appointment
        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setReason(reason);

        //Check if the time slot is available and book it

        Optional<TimeSlot> optionalTimeSlot = timeSlotRepository.findAvailableTimeSlot(timeSlotId);

        if (optionalTimeSlot.isPresent()) {
            //Time slot is available
            TimeSlot timeSlot = optionalTimeSlot.get();

            //Book and save the time slot
            timeSlot.setBooked(true);
            timeSlotRepository.save(timeSlot);

            //Set the time slot and save the appointment
            appointment.setTimeSlot(timeSlot);
            appointment.setBooked(true);
            return appointmentRepository.save(appointment);
        } else {
            throw new TimeSlotAvailabilityException("Time slot not available");
        }
    }

    public void cancelAppointment(long appointmentId) {

    }

    public void updateAppointment(Appointment appointment) {

    }

    public void getAppointment(long appointmentId) {

    }

    public void getAllAppointments() {

    }

    public void getAllAppointmentsByDoctorId(long doctorId) {

    }

    public void getAllAppointmentsByPatientId(long patientId) {

    }




}
