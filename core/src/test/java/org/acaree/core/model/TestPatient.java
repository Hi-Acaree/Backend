package org.acaree.core.model;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test the constructor and field access methods of the Patient class.
 * <p>
 *     This test uses a mock object to test the constructor of the Patient class.
 *     The mock object is created using the Mockito framework.
 *     The mock object is used to test the constructor of the Patient class.
 *     </p>
 */
class TestPatient {

    @Test
    void testPatientConstructorAndFieldAccess() {
        Person mockPerson = Mockito.mock(Person.class);

        Patient patient = new Patient(mockPerson);

        assertEquals(mockPerson.getId(), patient.getPersonDetails().getId());
        assertEquals(mockPerson, patient.getPersonDetails());
    }

    @Test
    void testEqualsAndHashCode(){
        Person person1 = new Person("John", "Doe", "ex@test.com", "1234567890");
        Patient patient1 = new Patient(person1);

        Person person2 = new Person("John", "Doe", "ex@test.com", "1234567890");

        Patient patient2 = new Patient(person2);

        assertEquals(patient1, patient2);
        assertEquals(patient1.hashCode(), patient2.hashCode());


    }

    @Test
    void testToString() {
        // Arrange
        Person mockPerson = Mockito.mock(Person.class);
        Mockito.when(mockPerson.getFirstName()).thenReturn("John");
        Mockito.when(mockPerson.getLastName()).thenReturn("Doe");
        Mockito.when(mockPerson.getEmail()).thenReturn("cc@test.com");
        Mockito.when(mockPerson.getPhone()).thenReturn("1234567890");

        Patient patient = new Patient(mockPerson);
        patient.setId(0L);

        String expectedString = "Patient{id=0, patientName=John Doe, email=cc@test.com, phone=1234567890}";

        assertEquals(expectedString, patient.toString());
    }


}
