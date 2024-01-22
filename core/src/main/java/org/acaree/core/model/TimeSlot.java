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
 * <p>This class represents a time slot for an appointment.</p>
 * <p>It is marked as an entity and thus is a persistent Java class.</p>
 * <p>It uses Lombok annotations to automatically generate getters, setters, and a no-argument constructor.</p>
 * {@code @Entity} annotation to mark the class as a persistent Java class.
 * {code @Getter} and {code @Setter} lombok annotations to generate getters and setters for all fields.
 * {@code @NoArgsConstructor} lombok annotation to generate a no-args constructor.
 * {@code @Id} annotation to mark the id field as the primary key.
 * {@code @ManyToOne} annotation to mark the relationship between TimeSlot and DoctorAvailability.
 * {@code @JoinColumn} annotation to mark the foreign key column.
 * {@code @GeneratedValue} annotation to configure the way of increment of the specified column(field).
 * {@code @Slf4j} lombok annotation to generate a logger field.
 * <p>It uses JPA annotations to map the TimeSlot class to the time_slot table in the database.</p>
 *
 * @version 1.0
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

    @Column(name = "start_time")
    private  LocalDateTime startTime;


    @Column(name = "end_time")
    private  LocalDateTime endTime;

    private boolean isBooked;

    @ManyToOne
    @JoinColumn(name = "availability_id")
    private DoctorAvailability availability;

    /**
     * Constructor for TimeSlot.
     * @param startTime the start time.
     * @param endTime the end time.
     * @param isBooked the is booked.
     */

    public TimeSlot(LocalDateTime startTime, LocalDateTime endTime,
    boolean isBooked) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.isBooked = isBooked;
    }

    /**
     * Constructor for TimeSlot.
     * @param startTime the start time.
     * @param endTime the end time.
     * @param isBooked the is booked.
     * @param availability the availability.
     */

    public TimeSlot(LocalDateTime startTime, LocalDateTime endTime, boolean isBooked, DoctorAvailability availability) {

        this.startTime = startTime;
        this.endTime = endTime;
        this.isBooked = isBooked;
        this.availability = availability;
    }

    /**
     * Constructor for TimeSlot.
     * @param startTime the start time.
     * @param endTime the end time.
     */

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
