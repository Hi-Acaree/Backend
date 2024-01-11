package org.acaree.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.util.Helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

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
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Version
    private long version;

    private  LocalDateTime startTime;
    private  LocalDateTime endTime;
    private boolean isBooked;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");

    public TimeSlot(LocalDateTime startTime, LocalDateTime endTime,
    boolean isBooked) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.isBooked = isBooked;
    }

    public TimeSlot(LocalDateTime startTime, LocalDateTime endTime, boolean isBooked, Doctor doctor) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.isBooked = isBooked;
        this.doctor = doctor;
    }

    // equals and hashCode methods are overridden to compare two TimeSlot objects
    // using business keys.


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeSlot)) return false;
        TimeSlot timeSlot = (TimeSlot) o;
        return Objects.equals(Helper.generateBusinessKey(this), Helper.generateBusinessKey(timeSlot));


    }

    @Override
    public int hashCode() {
        return Objects.hash(Helper.generateBusinessKey(this));

    }



    @Override
    public String toString() {
        return "TimeSlot{" +
                "id=" + id +
                ", startTime=" + startTime.format(timeFormatter) +
                ", endTime=" + endTime.format(timeFormatter) +
                ", isBooked=" + isBooked +
                '}';
    }
}
