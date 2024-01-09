package org.acaree.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.model.Appointment;
import org.acaree.core.model.Person;
import org.acaree.core.model.TimeSlot;
import org.acaree.core.util.Helper;

import java.util.*;

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

    @OneToMany(mappedBy = "doctor")
    private Set<TimeSlot> timeSlots;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    /**
     * @ElementCollection annotation is used to define a collection of instances of a basic type or embeddable class.
     * @CollectionTable annotation is used to define the table that will be used to persist the collection.
     * @MapKeyColumn annotation is used to define the column name that will hold the map key.
     * @Column annotation is used to define the column name that will hold the map value.
     * @JoinColumn annotation is used to define the foreign key column in the collection table.
     */

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "doctor_availability", joinColumns = @JoinColumn(name = "doctor_id"))
    @MapKeyColumn(name = "day_of_week")
    @Column(name = "time_slots")
    private Map<DaysOfTheWeek, Set<TimeSlot>> availableDates = new HashMap<>();

    //== constructors ==

    public Doctor(Person personDetails, String specialization, String hospitalName, String departmentName) {
        this.personDetails = personDetails;
        this.specialization = specialization;
        this.hospitalName = hospitalName;
        this.departmentName = departmentName;
        this.timeSlots = new HashSet<>();
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
        public enum DaysOfTheWeek {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
        }




}

