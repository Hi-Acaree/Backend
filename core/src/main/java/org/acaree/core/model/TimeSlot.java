package org.acaree.core.model;

import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * Time slot for an appointment.
 * <p>
 *     This class represents a time slot for an appointment.
 *     </p>
 *     <p>
 *         This class is used by the Appointment class.
 *         </p>
 */

@Entity
@Slf4j
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode
public class TimeSlot {

    private long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isBooked;

    public TimeSlot(long id, LocalDateTime startTime, LocalDateTime endTime, boolean isBooked) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isBooked = isBooked;
    }
}
