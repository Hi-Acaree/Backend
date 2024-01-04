package org.acaree.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * Person class is a base class for all the people in the system.
 * It contains basic information about a person.
 * It is used as a base class for Doctor, Patient, etc.
 * @Entity annotation to mark the class as a persistent Java class.
 * @Getter and @Setter lombok annotations to generate getters and setters for all fields.
 * @NoArgsConstructor lombok annotation to generate a no-args constructor.
 * @Id annotation to mark the id field as the primary key.
 * @GeneratedValue annotation to configure the way of increment of the specified column(field).
 * @Slf4j lombok annotation to generate a logger field.
 */
@Slf4j
@Entity
@Getter @Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private  String email;
    private  String phone;

    /**
     * Constructor for Person class.
     * @param firstName First name of the person.
     * @param lastName Last name of the person.
     * @param email Email address of the person.
     * @param phone Phone number of the person.
     */

    public Person(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    /**
     * Overridden equals method to compare two Person objects.
     * @param o Object to be compared against current Person object.
     * @return boolean true if the objects are equal, false otherwise.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(firstName, person.firstName)
                && Objects.equals(lastName, person.lastName)
                && Objects.equals(email, person.email)
                && Objects.equals(phone, person.phone);
    }

    /**
     * Overridden hashCode method to generate a hash code for the Person object.
     * @return int hash code for the Person object.
     * @see Objects#hash(Object...)
     */

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phone);
    }

    /**
     * Overridden toString method to generate a string representation of the Person object.
     * @return String representation of the Person object.
     */

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
