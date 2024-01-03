package org.acaree.core.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DoctorTest {

    @Test
    public void testDoctorConstructorAndFieldAccess() {
        Person mockPerson = Mockito.mock(Person.class);
        String specialization = "Cardiology";
        String hospitalName = "City Hospital";
        String departmentName = "Cardiology Department";

        Doctor doctor = new Doctor(mockPerson, specialization, hospitalName, departmentName);

        assertEquals(mockPerson, doctor.getPersonDetails());
        assertEquals(specialization, doctor.getSpecialization());
        assertEquals(hospitalName, doctor.getHospitalName());
        assertEquals(departmentName, doctor.getDepartmentName());
    }

    @Test
    public void testEqualsAndHashCode() {
        Person person1 = new Person("John", "Doe", "john@example.com", "1234567890");
        Doctor doctor1 = new Doctor(person1, "Cardiology", "City Hospital", "Cardiology Department");

        Person person2 = new Person("John", "Doe", "john@example.com", "1234567890");
        Doctor doctor2 = new Doctor(person2, "Cardiology", "City Hospital", "Cardiology Department");

        assertEquals(doctor1, doctor2);
        assertEquals(doctor1.hashCode(), doctor2.hashCode());
    }

    // Additional tests for any other methods in the Doctor class
}
