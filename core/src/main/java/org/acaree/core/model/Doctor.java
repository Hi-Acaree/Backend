package org.acaree.core.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.util.Helper;

import java.util.*;

/**
 * Doctor class is a subclass of Person class.
 * It contains information about a doctor.
 * {@code @Entity} annotation to mark the class as a persistent Java class.
 * {code @Getter} and {code @Setter} lombok annotations to generate getters and setters for all fields.
 * {@code @NoArgsConstructor} lombok annotation to generate a no-args constructor.
 * {@code @Id} annotation to mark the id field as the primary key.
 * {@code @GeneratedValue} annotation to configure the way of increment of the specified column(field).
 * {@code @Slf4j} lombok annotation to generate a logger field.
 * <p>It uses JPA annotations to map the Doctor class to the doctor table in the database.</p>
 * @see Person
 * @see DoctorAvailability
 * @see Appointment
 * @see Doctor.DaysOfTheWeek
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person personDetails; // Person object

    private String specialization;
    private String hospitalName;
    private String departmentName;

    @JsonManagedReference
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DoctorAvailability> daysAvailable = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    //== constructors ==

    /**
     * Constructor for Doctor.
     * @param personDetails the person details.
     * @param specialization the specialization.
     * @param hospitalName the hospital name.
     * @param departmentName the department name.
     */

    public Doctor(Person personDetails, String specialization, String hospitalName, String departmentName) {
        this.personDetails = personDetails;
        this.specialization = specialization;
        this.hospitalName = hospitalName;
        this.departmentName = departmentName;
        this.daysAvailable = new HashSet<>();
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

    //== inner enum class ==

    /**
     * DaysOfTheWeek enum class to represent the days of the week.
     * It is used to represent the days of the week in the DoctorAvailability class.
     * @see DoctorAvailability
     * @see Doctor
     * @see Appointment
     */

    public enum DaysOfTheWeek {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
        }




}

