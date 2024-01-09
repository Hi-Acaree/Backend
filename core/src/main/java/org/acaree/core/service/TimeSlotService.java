package org.acaree.core.service;

import lombok.extern.slf4j.Slf4j;
import org.acaree.core.exceptions.TimeSlotException;
import org.acaree.core.model.TimeSlot;
import org.acaree.core.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class TimeSlotService {
    private final TimeSlotRepository timeSlotRepository;

    @Autowired
    public TimeSlotService(TimeSlotRepository timeSlotRepository) {

        this.timeSlotRepository = timeSlotRepository;
    }

    //== public methods ==

    @Transactional(readOnly = true)
    public Optional<TimeSlot> findAvailableTimeSlot(long id) {
        if (id < 0) {
            log.error("Invalid TimeSlot ID: {}", id);
            throw new TimeSlotException("Invalid TimeSlot ID: " + id);
        }
        return Optional.ofNullable(timeSlotRepository.findById(id)
                .filter(timeSlot -> !timeSlot.isBooked())
                .orElseThrow(() -> new TimeSlotException("Time slot with ID " + id + " not available or already booked")));
    }


    @Transactional
    public void saveTimeSlot(TimeSlot timeSlot) {
        if (Objects.isNull(timeSlot)) {
            log.error("TimeSlot object cannot be null");
            throw new TimeSlotException("TimeSlot object cannot be null");
        }
        if (timeSlot.getStartTime().isAfter(timeSlot.getEndTime()) || timeSlot.getStartTime().equals(timeSlot.getEndTime())) {
            log.error("Invalid time slot: Start time must be before end time.");
            throw new TimeSlotException("Invalid time slot: Start time must be before end time.");
        }

        // Removed the automatic setting of timeSlot to booked
        timeSlotRepository.save(timeSlot);
        log.info("TimeSlot saved successfully: {}", timeSlot);
    }

    @Transactional
    public void scheduleDoctorAvailableTimeSlots(){

    }
}

