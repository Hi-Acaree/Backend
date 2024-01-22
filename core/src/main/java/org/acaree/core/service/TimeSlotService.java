package org.acaree.core.service;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.exceptions.TimeSlotException;
import org.acaree.core.model.TimeSlot;
import org.acaree.core.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

/**
 * Service class for TimeSlot entity
 * <p> This class is responsible for all the business logic related to TimeSlot entity</p>
 * {@code @Service} annotation to mark the class as a service class
 * {@code @Slf4j} annotation to enable logging
 * {@code @PersistenceContext} annotation to inject the EntityManager
 * {@code @Autowired} annotation to inject the TimeSlotRepository
 * {@code @Transactional} annotation to mark the class as a transactional class
 *
 */
@Service
@Slf4j
public class TimeSlotService {
    @PersistenceContext
    private EntityManager entityManager;
    private final TimeSlotRepository timeSlotRepository;

    /**
     * Constructor for TimeSlotService
     * @param timeSlotRepository The TimeSlotRepository to be injected
     */

    @Autowired
    public TimeSlotService(TimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
    }

    //== public methods ==

    /**
     * This method is used to find a time slot by its ID
     * @param id The ID of the time slot to be found
     * @return An optional of TimeSlot object
     * @throws TimeSlotException if the ID is invalid or the time slot is not available
     */

    @Transactional(readOnly = true)
    public Optional<TimeSlot> findAvailableTimeSlot(long id) throws TimeSlotException {
        if (id < 0) {
            log.error("Invalid TimeSlot ID: {}", id);
            throw new TimeSlotException("Invalid TimeSlot ID: " + id);
        }
        return Optional.ofNullable(timeSlotRepository.findById(id)
                .filter(timeSlot -> !timeSlot.isBooked())
                .orElseThrow(() -> new TimeSlotException("Time slot with ID " + id + " not available or already booked")));
    }

    /**
     * This method is used to save a time slot
     * @param timeSlot The time slot to be saved
     * @throws TimeSlotException if the time slot is null or the start time is after the end time
     */


    @Transactional
    public void saveTimeSlot(TimeSlot timeSlot) throws TimeSlotException {
        if (Objects.isNull(timeSlot)) {
            log.error("TimeSlot object cannot be null");
            throw new TimeSlotException("TimeSlot object cannot be null");
        }
        if (timeSlot.getStartTime().isAfter(timeSlot.getEndTime()) || timeSlot.getStartTime().equals(timeSlot.getEndTime())) {
            log.error("Invalid time slot: Start time must be before end time.");
            throw new TimeSlotException("Invalid time slot: Start time must be before end time.");
        }

        timeSlotRepository.save(timeSlot);
        entityManager.refresh(timeSlot);
        log.info("TimeSlot saved successfully: {}", timeSlot);
    }

}

