package org.acaree.core.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * This class represents the availability of a doctor on a given day of the week.
 * It contains a set of time slots that the doctor is available on that day.
 * <p> The class is annotated with JPA annotations in order to be mapped to a database table.</p>
 * <p> The class is annotated with Lombok annotations in order to generate getters, setters, constructors, equals, hashcode and toString methods.</p>
 *
 */

@NoArgsConstructor
@Entity
@Getter @Setter
public class DoctorAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Enumerated(EnumType.STRING)
    private Doctor.DaysOfTheWeek dayOfWeek;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "availability_id")
    private Set<TimeSlot> timeSlots = new HashSet<>();

    /**
     * Constructor for DoctorAvailability.
     * @param doctor the doctor.
     * @param dayOfWeek the day of the week.
     * @param timeSlots the time slots.
     */

    public DoctorAvailability(Doctor doctor, Doctor.DaysOfTheWeek dayOfWeek, Set<TimeSlot> timeSlots) {
        this.doctor = doctor;
        this.dayOfWeek = dayOfWeek;
        this.timeSlots = timeSlots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorAvailability that = (DoctorAvailability) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "DoctorAvailability{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", dayOfWeek=" + dayOfWeek +
                ", timeSlots=" + timeSlots +
                '}';
    }
}
