package org.acaree.core.dto;

import lombok.Getter;
import lombok.Setter;
import org.acaree.core.exceptions.TimeSlotException;
import org.acaree.core.model.TimeSlot;
import org.acaree.core.util.ErrorType;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter @Setter
public class TimeSlotDTO {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isBooked;

    // Other fields and getters/setters

    public static TimeSlotDTO from(TimeSlot timeSlot) {
        Objects.requireNonNull(timeSlot, "time slot cannot be null");
        TimeSlotDTO dto = new TimeSlotDTO();
        dto.setId(timeSlot.getId());

        if (timeSlot.getStartTime() == null)
            throw new TimeSlotException("Start time cannot be null", ErrorType.TIMESLOT_INVALID_INPUT);

        if (timeSlot.getEndTime() == null)
            throw new TimeSlotException("End time must be valid and cannot be null",
                    ErrorType.TIMESLOT_INVALID_INPUT);

        dto.setStartTime(timeSlot.getStartTime());
        dto.setEndTime(timeSlot.getEndTime());
        dto.setBooked(timeSlot.isBooked());

        return dto;
    }
}