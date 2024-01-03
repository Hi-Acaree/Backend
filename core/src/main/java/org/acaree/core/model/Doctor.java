package org.acaree.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

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
    private Person personDetails; // Assuming Person is an entity

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;

        return Objects.equals(id, doctor.id) &&
                Objects.equals(personDetails, doctor.personDetails) &&
                Objects.equals(specialization, doctor.specialization) &&
                Objects.equals(hospitalName, doctor.hospitalName) &&
                Objects.equals(departmentName, doctor.departmentName);
    }


    /**
     * Overridden equals method to compare two Doctor objects.
     * @return boolean true if the objects are equal, false otherwise.
     */


    @Override
    public int hashCode() {
        return Objects.hash(id, personDetails, specialization, hospitalName, departmentName);
    }
}

