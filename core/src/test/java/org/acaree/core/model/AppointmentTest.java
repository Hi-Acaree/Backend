package org.acaree.core.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        TimeSlot timeSlot = new TimeSlot();
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now().plusMinutes(30);
        timeSlot.setStartTime(startTime);
        timeSlot.setEndTime(endTime);


        // Act
        Appointment appointment = new Appointment(patient, doctor , "General Checkup", timeSlot);

        // Assert
        assertEquals(patient, appointment.getPatient());
        assertEquals(doctor, appointment.getDoctor());
        assertEquals(startTime, appointment.getTimeSlot().getStartTime());
        assertEquals(endTime, appointment.getTimeSlot().getEndTime());
        assertEquals("General Checkup", appointment.getReason());
    }

    @Test
    public void testEqualsAndHashCode() {
        // Arrange
        Patient patient = new Patient();
        Doctor doctor = new Doctor();
        TimeSlot timeSlot = new TimeSlot();
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now().plusMinutes(30);
        timeSlot.setStartTime(startTime);
        timeSlot.setEndTime(endTime);

        Appointment appointment1 = new Appointment(patient, doctor, "Checkup", timeSlot);
        Appointment appointment2 = new Appointment(patient, doctor, "Checkup", timeSlot);

        // Act & Assert
        assertEquals(appointment1, appointment2);
        assertEquals(appointment1.hashCode(), appointment2.hashCode());
    }


    @Test
    public void testToString() {
        // Arrange
        Patient mockPatient = mock(Patient.class);
        Doctor mockDoctor = mock(Doctor.class);
        TimeSlot mockTimeSlot = mock(TimeSlot.class);
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now().plusMinutes(30);
        when(mockTimeSlot.getStartTime()).thenReturn(startTime);
        when(mockTimeSlot.getEndTime()).thenReturn(endTime);

        when(mockPatient.toString()).thenReturn("MockPatient");
        when(mockDoctor.toString()).thenReturn("MockDoctor");
        Appointment appointment = new Appointment(mockPatient, mockDoctor, "Checkup", mockTimeSlot);
        String expectedString = "Appointment{id=0, patient=MockPatient, doctor=MockDoctor, startTime=" + startTime + ", endTime=" + endTime + ", reason='Checkup'}";

        // Act & Assert
        assertEquals(expectedString, appointment.toString());
    }

    // Additional tests...
}
