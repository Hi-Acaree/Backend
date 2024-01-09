package org.acaree.core.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeSlotTest {

    @Test
    public void testTimeSlotConstructor() {
        // Arrange
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now();
        boolean isBooked = false;

        // Act
        TimeSlot timeSlot = new TimeSlot(startTime, endTime, isBooked);

        // Assert
        assertEquals(0, timeSlot.getId());
        assertEquals(startTime, timeSlot.getStartTime());
        assertEquals(endTime, timeSlot.getEndTime());
        assertEquals(isBooked, timeSlot.isBooked());
    }

    @Test
    public void testEqualsAndHashCode() {
        // Arrange
        long id = 1;
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now();
        boolean isBooked = false;

        TimeSlot timeSlot1 = new TimeSlot(startTime, endTime, isBooked);
        TimeSlot timeSlot2 = new TimeSlot(startTime, endTime, isBooked);

        // Act & Assert
        assertEquals(timeSlot1, timeSlot2);
        assertEquals(timeSlot1.hashCode(), timeSlot2.hashCode());
    }
}
