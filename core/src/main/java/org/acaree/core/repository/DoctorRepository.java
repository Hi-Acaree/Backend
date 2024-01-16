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
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId")
    List<Appointment> getDoctorsAppointments(Long doctorId);

    @Transactional(readOnly = true)
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId AND a.patient.id = :patientId")
    List<Appointment> getDoctorsAppointmentsByPatientId(Long doctorId, Long patientId);

    @Transactional(readOnly = true)
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId AND a.patient.id = :patientId AND a.timeSlot.id = :timeSlotId")
    List<Appointment> getDoctorsAppointmentsByPatientIdAndTimeSlotId(Long doctorId, Long patientId, Long timeSlotId);

    @Transactional(readOnly = true)
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId AND a.timeSlot.id = :timeSlotId")
    List<Appointment> getDoctorsAppointmentsByTimeSlotId(Long doctorId, Long timeSlotId);

    // get doctors by specialization
    @Transactional(readOnly = true)
    @Query("SELECT d FROM Doctor d WHERE d.specialization = :specialization")
    List<Doctor> getDoctorsBySpecialization(String specialization);

    // get doctors by Department
    @Transactional(readOnly = true)
    @Query("SELECT d FROM Doctor d WHERE d.departmentName = :departmentName")
    List<Doctor> getDoctorsByDepartment(String departmentName);
}
