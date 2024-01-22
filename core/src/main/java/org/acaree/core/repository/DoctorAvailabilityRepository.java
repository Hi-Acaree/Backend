package org.acaree.core.repository;

import org.acaree.core.model.DoctorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DoctorAvailabilityRepository is a repository for the DoctorAvailability class.
 * <p>This interface is used to access the database for the DoctorAvailability class.</p>
 * <p>This interface is used by the DoctorAvailabilityService class.</p>
 * {@code @Repository} annotation to indicate that this class is a repository.
 */
@Repository
public interface DoctorAvailabilityRepository extends JpaRepository<DoctorAvailability, Long> {

}
