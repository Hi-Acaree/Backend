package org.acaree.core.repository;

import org.acaree.core.model.Doctor;
import org.acaree.core.model.DoctorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * DoctorAvailabilityRepository is a repository for the DoctorAvailability class.
 * <p>This interface is used to access the database for the DoctorAvailability class.</p>
 * <p>This interface is used by the DoctorAvailabilityService class.</p>
 * {@code @Repository} annotation to indicate that this class is a repository.
 */
@Repository
public interface DoctorAvailabilityRepository extends JpaRepository<DoctorAvailability, Long> {
    // fetch the doctor availability for the given day and doctor id

    @Query("SELECT da FROM DoctorAvailability da WHERE da.dayOfWeek = ?1 AND da.doctor.id = ?2")
    Optional<DoctorAvailability> findByDayAndDoctorId(Doctor.DaysOfTheWeek day, Long doctorId);

}
