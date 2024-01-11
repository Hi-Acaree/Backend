package org.acaree.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.util.Helper;

import java.util.List;
import java.util.Objects;

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


}

