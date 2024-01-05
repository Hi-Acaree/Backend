package org.acaree.core.repository;

import org.acaree.core.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for the TimeSlot class.
 * <p>
 *     This interface is used to access the database for the TimeSlot class.
 *     </p>
 *     <p>
 *         This interface is used by the TimeSlotService class.
 *
 *         </p>
 */

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
    // check if a time slot is available
    Optional<TimeSlot> findAvailableTimeSlot(long timeSlot);

}
