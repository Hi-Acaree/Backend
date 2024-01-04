package org.acaree.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.util.Helper;

import java.util.Objects;

/**
 * Doctor class is a subclass of Person class.
 * It contains information about a doctor.
 * @Entity annotation to mark the class as a persistent Java class.
 * @Getter and @Setter lombok annotations to generate getters and setters for all fields.
 * @NoArgsConstructor lombok annotation to generate a no-args constructor.
 * @Id annotation to mark the id field as the primary key.
 */

@Entity
@Slf4j
@NoArgsConstructor
@Getter @Setter
public class Doctor {
    //== fields and relationships ==
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person personDetails; // Person object

    private String specialization;
    private String hospitalName;
    private String departmentName;

    //== constructors ==

    public Doctor(Person personDetails, String specialization, String hospitalName, String departmentName) {
        this.personDetails = personDetails;
        this.specialization = specialization;
        this.hospitalName = hospitalName;
        this.departmentName = departmentName;
    }

    //== methods ==

    // equals and hashCode methods are overridden to compare two Doctor objects

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;

        return Helper.generateBusinessKey(personDetails).equals(Helper.generateBusinessKey(doctor.personDetails));
    }

    @Override
    public int hashCode() {
        return Objects.hash(Helper.generateBusinessKey(personDetails));
    }

    @Override
    public String toString() {
        return "Doctor{" + "id=" + id +
                ", doctorName=" + personDetails.getFirstName() + " " + personDetails.getLastName() +
                ", email=" + personDetails.getEmail() +
                ", phone=" + personDetails.getPhone() +
                ", specialization='" + specialization + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}

