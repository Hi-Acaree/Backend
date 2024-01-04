package org.acaree.core.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DoctorTest {

    /**
     * Test the constructor and field access methods of the Doctor class.
     * <p>
     *     This test uses a mock object to test the constructor of the Doctor class.
     *     The mock object is created using the Mockito framework.
     *     The mock object is used to test the constructor of the Doctor class.
     *     </p>
     *     <p>
     *         This test also tests the equals() and hashCode() methods of the Doctor class.
     *         </p>
     *         <p>
     *             This test also tests the toString() method of the Doctor class.
     *             </p>
     */

    @Test
    void testDoctorConstructorAndFieldAccess() {
        Person mockPerson = mock(Person.class);
        String specialization = "Cardiology";
        String hospitalName = "City Hospital";
        String departmentName = "Cardiology Department";

        Doctor doctor = new Doctor(mockPerson, specialization, hospitalName, departmentName);

        assertEquals(mockPerson.getId(), doctor.getPersonDetails().getId());

        assertEquals(mockPerson, doctor.getPersonDetails());
        assertEquals(specialization, doctor.getSpecialization());
        assertEquals(hospitalName, doctor.getHospitalName());
        assertEquals(departmentName, doctor.getDepartmentName());
    }

    @Test
    void testEqualsAndHashCode() {
        Person person1 = new Person("John", "Doe", "john@example.com", "1234567890");
        Doctor doctor1 = new Doctor(person1, "Cardiology", "City Hospital", "Cardiology Department");

        Person person2 = new Person("John", "Doe", "john@example.com", "1234567890");
        Doctor doctor2 = new Doctor(person2, "Cardiology", "City Hospital", "Cardiology Department");

        assertEquals(doctor1, doctor2);
        assertEquals(doctor1.hashCode(), doctor2.hashCode());
    }

    @Test
    void testToString() {
        // Arrange
        Person mockPerson = mock(Person.class);
        when(mockPerson.getFirstName()).thenReturn("John");
        when(mockPerson.getLastName()).thenReturn("Doe");
        when(mockPerson.getEmail()).thenReturn("johndoe@example.com");
        when(mockPerson.getPhone()).thenReturn("1234567890");

        Doctor doctor = new Doctor(mockPerson, "Cardiology", "City Hospital", "Cardiology Department");
        doctor.setId(0L);

        // Act
        String actualString = doctor.toString();

        // Assert
        String expectedString = "Doctor{id=0, doctorName=John Doe, email=johndoe@example.com, phone=1234567890, specialization='Cardiology', hospitalName='City Hospital', departmentName='Cardiology Department'}";
        assertEquals(expectedString, actualString);
    }

    // Additional tests for any other methods in the Doctor class
}
