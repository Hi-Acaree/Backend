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

        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now().plusMinutes(30);
        TimeSlot timeSlot = new TimeSlot(startTime, endTime, false);


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

        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now().plusMinutes(30);
        TimeSlot timeSlot = new TimeSlot(startTime, endTime, false);

        Appointment appointment1 = new Appointment(patient, doctor, "Checkup", timeSlot);
        Appointment appointment2 = new Appointment(patient, doctor, "Checkup", timeSlot);

        // Act & Assert
        assertEquals(appointment1, appointment2);
        assertEquals(appointment1.hashCode(), appointment2.hashCode());
    }

    // Additional tests...
}
