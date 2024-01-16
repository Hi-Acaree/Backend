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
 * <p> This class is annotated with @Service annotation to indicate that it is a service class</p>
 * <p> This class is annotated with @Slf4j annotation to enable logging</p>
 * <p> This class is annotated with @Transactional annotation to enable transaction management</p>
 * <p> This class is annotated with @PersistenceContext annotation to inject EntityManager</p>
 * <p> This class is annotated with @Autowired annotation to inject TimeSlotRepository</p>
 */
@Service
@Slf4j
public class TimeSlotService {
    @PersistenceContext
    private EntityManager entityManager;
    private final TimeSlotRepository timeSlotRepository;

    @Autowired
    public TimeSlotService(TimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
    }

    //== public methods ==

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

