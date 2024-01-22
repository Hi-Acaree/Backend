package org.acaree.core.repository;

import org.acaree.core.model.Appointment;
import org.acaree.core.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Repository for the Doctor class.
 * <p> This interface is used to access the database for the Doctor class.</p>
 * <p> This interface is used by the DoctorService class.</p>
 * The class is annotated with {@code @Repository} to mark it as a Spring Data repository.
 */
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    /**
     * This method is used to find a doctor by its ID.
     * @param doctorId The ID of the doctor.
     * @return a list of appointments for the doctor.
     */

    @Transactional(readOnly = true)
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId")
    List<Appointment> getDoctorsAppointments(Long doctorId);

    /**
     * This method is used to find a doctor by its ID.
     * @param doctorId The ID of the doctor.
     * @param patientId The ID of the patient.
     * {@code @Query} annotation to specify the query to be executed.
     * {@code @Transactional} annotation to mark the method as a transactional method.
     * @return a list of appointments for the doctor.
     */

    @Transactional(readOnly = true)
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId AND a.patient.id = :patientId")
    List<Appointment> getDoctorsAppointmentsByPatientId(Long doctorId, Long patientId);

    /**
     * This method is used to find a doctor appointment by patient and timeslot.
     * @param doctorId The ID of the doctor.
     * @param patientId The ID of the patient.
     * @param timeSlotId The ID of the time slot.
     * @return a list of appointments for the doctor.
     */

    @Transactional(readOnly = true)
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId AND a.patient.id = :patientId AND a.timeSlot.id = :timeSlotId")
    List<Appointment> getDoctorsAppointmentsByPatientIdAndTimeSlotId(Long doctorId, Long patientId, Long timeSlotId);

    /**
     * This method is used to find a doctor appointment by its Timeslot.
     * @param doctorId The ID of the doctor.
     * @param timeSlotId The ID of the time slot.
     * @return a list of appointments for the doctor.
     */

    @Transactional(readOnly = true)
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId AND a.timeSlot.id = :timeSlotId")
    List<Appointment> getDoctorsAppointmentsByTimeSlotId(Long doctorId, Long timeSlotId);

    /**
     * This method is used to find a doctor by specialization.
     * @param specialization The specialization of the doctor.
     * @return a list of appointments for the doctor.
     */

    // get doctors by specialization
    @Transactional(readOnly = true)
    @Query("SELECT d FROM Doctor d WHERE d.specialization = :specialization")
    List<Doctor> getDoctorsBySpecialization(String specialization);

    /**
     * This method is used to find a doctor by department.
     * @param departmentName The department of the doctor.
     * @return a list of appointments for the doctor.
     */

    // get doctors by Department
    @Transactional(readOnly = true)
    @Query("SELECT d FROM Doctor d WHERE d.departmentName = :departmentName")
    List<Doctor> getDoctorsByDepartment(String departmentName);
}
