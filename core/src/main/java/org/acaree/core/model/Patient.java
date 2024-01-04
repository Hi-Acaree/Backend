package org.acaree.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.util.Helper;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Slf4j
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person personDetails;

    public Patient(Person personDetails) {
        this.personDetails = personDetails;
    }

    // equals and hashCode methods are overridden to compare two Patient objects
    // using business keys.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return Helper.generateBusinessKey(personDetails).equals(Helper.generateBusinessKey(patient.personDetails));

    }

    @Override
    public int hashCode() {
        return Objects.hash(Helper.generateBusinessKey(personDetails));
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
}

