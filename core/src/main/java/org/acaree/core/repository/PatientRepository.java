package org.acaree.core.repository;

import org.acaree.core.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Repository for the Patient class.
 * <p> This interface is used to access the database for the Patient class.</p>
 * <p> This interface is used by the PatientService class.</p>
 * {@code @Repository} annotation to mark the class as a repository.
 */

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Modifying
    @Query("delete from Patient p where p.expiry < ?1")
    void deleteAllByExpiryBefore(LocalDateTime expiry);

    @Transactional(readOnly = true)
    @Query("select p from Patient p where p.personDetails.email = ?1")
    Optional<Patient> findByEmail(String email);
}
