package org.acaree.core.repository;

import org.acaree.core.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * <p>Repository for the TimeSlot class.</p>
 * <p> This interface is used to access the database for the TimeSlot class.</p>
 * <p> This interface is used by the TimeSlotService class.</p>
 * {@code @Repository} is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
 */

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {

}
