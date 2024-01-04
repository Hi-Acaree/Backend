package org.acaree.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.util.Helper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * This class is a model class for Appointment.
 * It contains information about an appointment.
 * @Entity annotation to mark the class as a persistent Java class.
 * @Getter and @Setter lombok annotations to generate getters and setters for all fields.
 * @NoArgsConstructor lombok annotation to generate a no-args constructor.
 * @Id annotation to mark the id field as the primary key.
 * @ManyToOne annotation to mark the relationship between Appointment and Patient.
 * @ManyToOne annotation to mark the relationship between Appointment and Doctor.
 * @JoinColumn annotation to mark the foreign key column.
 * @GeneratedValue annotation to configure the way of increment of the specified column(field).
 * @Slf4j lombok annotation to generate a logger field.
 *
 */
@Entity
@Slf4j
@Getter @Setter
@NoArgsConstructor

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private LocalDate date;
    private LocalTime time;
    private String reason;

    public Appointment(long id, Patient patient, Doctor doctor, LocalDate date, LocalTime time, String reason) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.reason = reason;
    }

    public Appointment(Patient patient, Doctor doctor, LocalDate date, LocalTime time, String reason) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;
        Appointment that = (Appointment) o;
        return Helper.generateBusinessKey(this).equals(Helper.generateBusinessKey(that));
    }

    @Override
    public int hashCode() {
        return Objects.hash(Helper.generateBusinessKey(this));
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patient=" + (patient != null ? patient.toString() : "null") +
                ", doctor=" + (doctor != null ? doctor.toString() : "null") +
                ", date=" + (date != null ? date.toString() : "null") +
                ", time=" + (time != null ? time.toString() : "null") +
                ", reason='" + (reason != null ? reason : "null") + '\'' +
                '}';
    }

}
