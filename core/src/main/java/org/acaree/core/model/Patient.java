package org.acaree.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;

/**
 * This class represents a patient in the system.
 * A patient is a person who has a medical record in the system.
 * A patient can have multiple appointments.
 * A patient can have multiple medical records.
 * A patient can have multiple prescriptions.
 * A patient can have multiple medical tests.
 * A patient can have multiple medical test results.
 * A patient can have multiple medical test requests.
 * A patient can have multiple medical test request results.
 * A patient can have multiple medical test request results.
 * A patient can have multiple medical test request
 **/

@Entity
@Getter @Setter
@NoArgsConstructor
@Slf4j
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person personDetails;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    public Patient(Person personDetails) {
        this.personDetails = personDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", patientName=" + personDetails.getFirstName() + " " + personDetails.getLastName() +
                ", email=" + personDetails.getEmail() +
                ", phone=" + personDetails.getPhone() +
                '}';
    }

    // == inner class ==


}

