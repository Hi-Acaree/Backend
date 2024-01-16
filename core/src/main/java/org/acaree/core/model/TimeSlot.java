package org.acaree.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.type.descriptor.java.LocalDateTimeJavaType;

import java.time.LocalDateTime;
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

    private LocalDateTimeJavaType localDateTimeJavaType;

    @Column(name = "start_time")
    private  LocalDateTime startTime;


    @Column(name = "end_time")
    private  LocalDateTime endTime;

    private boolean isBooked;

    @ManyToOne
    @JoinColumn(name = "availability_id")
    private DoctorAvailability availability;

    public TimeSlot(LocalDateTime startTime, LocalDateTime endTime,
    boolean isBooked) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.isBooked = isBooked;
    }

    public TimeSlot(LocalDateTime startTime, LocalDateTime endTime, boolean isBooked, DoctorAvailability availability) {

        this.startTime = startTime;
        this.endTime = endTime;
        this.isBooked = isBooked;
        this.availability = availability;
    }

    public TimeSlot(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // equals and hashCode methods are overridden to compare two TimeSlot objects
    // using business keys.


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeSlot)) return false;
        TimeSlot timeSlot = (TimeSlot) o;
        return Objects.equals(id, timeSlot.id);




    }

    @Override
    public int hashCode() {
        return Objects.hash(id);

    }



    @Override
    public String toString() {
        return "TimeSlot{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime+
                ", isBooked=" + isBooked +
                '}';
    }
}
