package org.acaree.core.service;

import lombok.extern.slf4j.Slf4j;
import org.acaree.core.exceptions.TimeSlotAvailabilityException;
import org.acaree.core.model.TimeSlot;
import org.acaree.core.repository.TimeSlotRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class TimeSlotService {
    private final TimeSlotRepository timeSlotRepository;

    public TimeSlotService(TimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
    }

    //== public methods ==
    Optional<TimeSlot> findAvailableTimeSlot(long timeSlotId) {
     Optional<TimeSlot> timeSlot = timeSlotRepository.findById(timeSlotId);
     if (timeSlot.isPresent() && !timeSlot.get().isBooked()) {
         log.info("Time slot available: {}", timeSlot);
         return timeSlot;
     } else {
         new TimeSlotAvailabilityException("Time slot not available");
         return Optional.empty();
     }
    }

    public void saveTimeSlot(TimeSlot timeSlot) {
        timeSlotRepository.save(timeSlot);
        log.info("TimeSlot created successfully: {}", timeSlot);
    }
}
