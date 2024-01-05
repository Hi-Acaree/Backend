package org.acaree.core.repository;

import org.acaree.core.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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

}
