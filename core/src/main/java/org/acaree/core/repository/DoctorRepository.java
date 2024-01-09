package org.acaree.core.repository;

import org.acaree.core.model.Appointment;
import org.acaree.core.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Transactional(readOnly = true)
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = ?1")
    List<Appointment> getDoctorsAppointments(Long doctorId);

    @Transactional(readOnly = true)
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = ?1 AND a.patient.id = ?2")
    List<Appointment> getDoctorsAppointmentsByPatientId(Long doctorId, Long patientId);

    @Transactional(readOnly = true)
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = ?1 AND a.patient.id = ?2 AND a.timeSlot.id = ?3")
    List<Appointment> getDoctorsAppointmentsByPatientIdAndTimeSlotId(Long doctorId, Long patientId, Long timeSlotId);

    @Transactional(readOnly = true)
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = ?1 AND a.timeSlot.id = ?2")
    List<Appointment> getDoctorsAppointmentsByTimeSlotId(Long doctorId, Long timeSlotId);

    // get doctors by specialization
    @Transactional(readOnly = true)
    @Query("SELECT d FROM Doctor d WHERE d.specialization = ?1")
    List<Doctor> getDoctorsBySpecialization(String specialization);

    // get doctors by Department
    @Transactional(readOnly = true)
    @Query("SELECT d FROM Doctor d WHERE d.departmentName = ?1")
    List<Doctor> getDoctorsByDepartment(String departmentName);
}
