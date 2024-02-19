package org.acaree.core.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.util.Helper;
import java.util.Objects;

/**
 * This class is a model class for Appointment.
 * It contains information about an appointment.
 * {@code @Entity} annotation to mark the class as a JPA entity.
 * {@code @Table} annotation to provide the details of the table that this entity will be mapped to.
 * {@code @Getter} and {@code @Setter} annotation to generate getter and setter methods for all fields.
 * {@code @NoArgsConstructor} annotation to generate a no argument constructor.
 *
 */
@Entity
@Slf4j
@Getter
@Setter
@NoArgsConstructor

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    @JsonIgnore
    private Patient patient;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;


    @ManyToOne
    @JoinColumn(name = "time_slot_id")
    private TimeSlot timeSlot;

    private String reason;
    private String type;

    private boolean booked;

    /**
     * This is a constructor for the Appointment class.
     * @param patient the patient.
     * @param doctor the doctor.
     * @param reason the reason for the appointment.
     * @param timeSlot the time slot for the appointment.
     */

    public Appointment(Patient patient, Doctor doctor, String reason, TimeSlot timeSlot) {
        this.patient = patient;
        this.doctor = doctor;
        this.reason = reason;
        this.timeSlot = timeSlot;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;
        Appointment appointment = (Appointment) o;
        return Helper.generateBusinessKey(this).equals(Helper.generateBusinessKey(appointment));
    }

    @Override
    public int hashCode() {
        return Objects.hash(Helper.generateBusinessKey(this));
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + id +
                ", patient=" + (patient != null ? patient.getPersonDetails().getFirstName() + ", " + patient.getPersonDetails().getLastName() : "") +
                ", doctor=" + (doctor != null ? doctor.getPersonDetails().getFirstName() + ", " + doctor.getPersonDetails().getLastName() : "") +
                ", type=" + (type != null ? type : "") + '\'' +
                ", booked=" + booked +
                ", startTime=" + (timeSlot != null ? timeSlot.getStartTime().toString() : "null") +
                ", endTime=" + (timeSlot != null ? timeSlot.getEndTime().toString() : "null") +
                ", reason=" + (reason != null ? reason : "") + '\'' +
                '}';
    }
}
