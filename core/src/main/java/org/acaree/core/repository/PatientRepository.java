package org.acaree.core.repository;

import org.acaree.core.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for the Patient class.
 * <p> This interface is used to access the database for the Patient class.</p>
 * <p> This interface is used by the PatientService class.</p>
 * {@code @Repository} annotation to mark the class as a repository.
 */

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
