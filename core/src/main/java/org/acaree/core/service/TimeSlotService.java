package org.acaree.core.service;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.exceptions.TimeSlotException;
import org.acaree.core.model.Doctor;
import org.acaree.core.model.DoctorAvailability;
import org.acaree.core.model.TimeSlot;
import org.acaree.core.repository.DoctorAvailabilityRepository;
import org.acaree.core.repository.TimeSlotRepository;
import org.acaree.core.util.ErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

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

    private final DoctorAvailabilityService doctorAvailabilityService;

    /**
     * Constructor for TimeSlotService
     * @param timeSlotRepository The TimeSlotRepository to be injected
     * @param doctorAvailabilityService The DoctorAvailability service to be injected
     */

    @Autowired
    public TimeSlotService(TimeSlotRepository timeSlotRepository, DoctorAvailabilityService doctorAvailabilityService) {

        this.timeSlotRepository = timeSlotRepository;
        this.doctorAvailabilityService = doctorAvailabilityService;
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
            throw new TimeSlotException("Invalid TimeSlot ID: " + id, ErrorType.TIMESLOT_INVALID_INPUT);
        }
        return Optional.ofNullable(timeSlotRepository.findById(id)
                .filter(timeSlot -> !timeSlot.isBooked())
                .orElseThrow(() -> new TimeSlotException("Time slot with ID " + id + " not available or already booked",
                        ErrorType.TIMESLOT_NOT_AVAILABLE)));
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
            throw new TimeSlotException("TimeSlot object cannot be null",
                    ErrorType.TIMESLOT_INVALID_INPUT);
        }
        if (timeSlot.getStartTime().isAfter(timeSlot.getEndTime()) || timeSlot.getStartTime().equals(timeSlot.getEndTime())) {
            log.error("Invalid time slot: Start time must be before end time.");
            throw new TimeSlotException("Invalid time slot: Start time must be before end time.",
                    ErrorType.TIMESLOT_INVALID_INPUT);
        }

        timeSlotRepository.save(timeSlot);
        entityManager.refresh(timeSlot);
        log.info("TimeSlot saved successfully: {}", timeSlot);
    }

    /**
     * find all available time slots for a given day and this timeslot should not overlap with doctor's existing timeslots
     * @param day the day of the timeslot
     * @param doctorId the id of the doctor
     * @return a list of available timeslots
     * @throws TimeSlotException if the day is null or the doctorId is invalid
     */

    public List<TimeSlot> findAvailableTimeSlotsForDoctorAndDay(long doctorId, Doctor.DaysOfTheWeek day) throws TimeSlotException,
            NoSuchElementException {
        // Check if doctorId is valid
        if (doctorId < 0) {
            log.error("Invalid Doctor ID: {}", doctorId);
            throw new TimeSlotException("Invalid Doctor ID: " + doctorId,
                    ErrorType.TIMESLOT_INVALID_INPUT);
        }

        // Fetch the DoctorAvailability for the given doctor and day
        DoctorAvailability doctorAvailability =
                doctorAvailabilityService.findDoctorAvailabilityByDayAndDoctorId(day, doctorId).orElseThrow();

        // Filter available time slots
        List<TimeSlot> availableTimeSlots = new ArrayList<>();
        for (TimeSlot timeSlot : doctorAvailability.getTimeSlots()) {
            if (!timeSlot.isBooked()) {
                availableTimeSlots.add(timeSlot);
            }
        }
        log.info("Available time slots for doctor {} on {} are: {}", doctorId, day, availableTimeSlots);

        return availableTimeSlots;
    }

    protected TimeSlot findOrCreateNextAvailableTimeSlot(LocalDateTime startTime, Period recurrencePeriod) {
        // Calculate the end time based on your business logic. For example, if each slot is 1 hour:
        LocalDateTime endTime = startTime.plusMinutes(30); // Adjust this based on actual duration

        // Try to find an existing time slot that starts at the given startTime
        Optional<TimeSlot> existingTimeSlot = timeSlotRepository.findByStartTime(startTime);

        if (existingTimeSlot.isPresent()) {
            // Found an existing time slot that matches the criteria
            return existingTimeSlot.get();
        } else {
            // No existing time slot found, create a new one
            TimeSlot newTimeSlot = new TimeSlot();
            newTimeSlot.setStartTime(startTime);
            newTimeSlot.setEndTime(endTime);
            // Set any other necessary properties of TimeSlot here

            // Save the new time slot to the database
            TimeSlot savedTimeSlot = timeSlotRepository.save(newTimeSlot);
            return savedTimeSlot;
        }
    }




}

