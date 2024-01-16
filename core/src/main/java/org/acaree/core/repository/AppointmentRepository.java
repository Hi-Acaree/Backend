package org.acaree.core.repository;

import org.acaree.core.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for the Appointment class.
 * <p>
 *     This interface is used to access the database for the Appointment class.
 *     </p>
 *     <p>
 *         This interface is used by the AppointmentService class.
 *
 *         </p>
 */

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    /**
     * This is a custom query to find an appointment by doctor id.
     * @param doctorId the id of the doctor.
     * @return the appointment.
      */
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = ?1")
    List<Appointment> findDoctorAppointment(long doctorId);

    /**
     * This is a custom query to find an appointment by patient id.
     * @param patientId the id of the patient.
     * @return the appointment.
     */
    @Query("SELECT appointment FROM Appointment appointment WHERE appointment.patient.id = ?1")
    List<Appointment> findPatientAppointment(long patientId);

}
