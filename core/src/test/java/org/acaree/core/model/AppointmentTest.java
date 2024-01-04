package org.acaree.core.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Test the constructor and field access methods of the Appointment class.
 * <p>
 *     This test uses a mock object to test the constructor of the Appointment class.
 *     The mock object is created using the Mockito framework.
 *     The mock object is used to test the constructor of the Appointment class.
 *     </p>
 *     <p>
 *         This test also tests the equals() and hashCode() methods of the Appointment class.
 *         </p>
 */

public class AppointmentTest {

    @Test
    public void testAppointmentConstructor() {
        // Arrange
        Patient patient = new Patient(); // Assuming Patient is properly instantiated
        Doctor doctor = new Doctor();   // Assuming Doctor is properly instantiated
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        // Act
        Appointment appointment = new Appointment(patient, doctor, date, time, "General Checkup");

        // Assert
        assertEquals(patient, appointment.getPatient());
        assertEquals(doctor, appointment.getDoctor());
        assertEquals(date, appointment.getDate());
        assertEquals(time, appointment.getTime());
        assertEquals("General Checkup", appointment.getReason());
    }

    @Test
    public void testEqualsAndHashCode() {
        // Arrange
        Patient patient = new Patient();
        Doctor doctor = new Doctor();
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        Appointment appointment1 = new Appointment(patient, doctor, date, time, "Checkup");
        Appointment appointment2 = new Appointment(patient, doctor, date, time, "Checkup");

        // Act & Assert
        assertEquals(appointment1, appointment2);
        assertEquals(appointment1.hashCode(), appointment2.hashCode());
    }


    @Test
    public void testToString() {
        // Arrange
        Patient mockPatient = mock(Patient.class);
        Doctor mockDoctor = mock(Doctor.class);
        LocalDate date = LocalDate.of(2020, 1, 1); // Fixed date
        LocalTime time = LocalTime.of(12, 0);      // Fixed time

        when(mockPatient.toString()).thenReturn("MockPatient");
        when(mockDoctor.toString()).thenReturn("MockDoctor");

        Appointment appointment = new Appointment(mockPatient, mockDoctor, date, time, "Checkup");
        String expectedString = "Appointment{id=0, patient=MockPatient, doctor=MockDoctor, date=" + date + ", time=" + time + ", reason='Checkup'}";

        // Act & Assert
        assertEquals(expectedString, appointment.toString());
    }

    // Additional tests...
}
