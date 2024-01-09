package org.acaree.core.service;
import org.acaree.core.exceptions.AppointmentBookingException;
import org.acaree.core.exceptions.BookingCancelException;
import org.acaree.core.exceptions.TimeSlotException;
import org.acaree.core.model.*;
import org.acaree.core.repository.AppointmentRepository;
import org.acaree.core.repository.DoctorRepository;
import org.acaree.core.repository.PatientRepository;
import org.acaree.core.repository.TimeSlotRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Test class for the AppointmentService class.
 * <p> This class is used to test the AppointmentService class. </p>
 * <p>This class tests for appointment booking timeSlot availability</p>
 * <p>This class tests for appointment booking success</p>
 * <p>This class tests for appointment booking failure</p>
 * <p>This class tests for appointment booking failure due to timeSlot availability</p>
 */

@ExtendWith(MockitoExtension.class)
class AppointmentServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private PatientService patientService;

    @Mock
    private DoctorService doctorService;

    @Mock
    private TimeSlotService timeSlotService;

    @InjectMocks
    private AppointmentService appointmentService;

    private Appointment appointment;
    private Patient patient;
    private Doctor doctor;
    private TimeSlot timeSlot;


    @BeforeEach
    void setUp() {



        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now().plusMinutes(30);
        appointment = new Appointment();
        patient = new Patient();
        doctor = new Doctor();
        timeSlot = new TimeSlot(startTime, endTime, false);

        Person person = new Person();
        Person person1 = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setEmail("cc@test.com");
        person.setPhone("1234567890");
        person.setId(1L);

        person1.setFirstName("Jane");
        person1.setLastName("Doe");
        person1.setEmail("test@test.com");
        person1.setPhone("1234567890");
        person1.setId(2L);

        patient.setPersonDetails(person1);
        doctor.setPersonDetails(person);
        timeSlot.setDoctor(doctor);

        timeSlot.setId(1L);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setTimeSlot(timeSlot);
        appointment.setReason("Test");
        appointment.setId(1L);

    }

    @Test
    void testBookAppointment_Success() {
        // Arrange

        when(patientService.getPatientById(2L)).thenReturn(Optional.of(patient));
        when(doctorService.getDoctorById(1L)).thenReturn(Optional.of(doctor));
        when(appointmentRepository.save(any(Appointment.class))).thenAnswer(invocation -> {
            Appointment appointment = invocation.getArgument(0);
            appointment.setId(1L);
            return appointment;
        });

        when(timeSlotService.findAvailableTimeSlot(1L)).thenReturn(Optional.of(timeSlot));

        // Act
        Appointment returnedAppointment = appointmentService.bookAppointment(1L, 2L, "Test", 1L);

        // Assert
        assertNotNull(returnedAppointment);
        assertEquals(1L, returnedAppointment.getDoctor().getPersonDetails().getId());
        assertEquals(2L, returnedAppointment.getPatient().getPersonDetails().getId());
        assertEquals("Test", returnedAppointment.getReason());
        assertEquals(1L, returnedAppointment.getTimeSlot().getId());
        assertTrue(returnedAppointment.isBooked());

        // Verify that the time slot was marked as booked and saved
        assertTrue(returnedAppointment.getTimeSlot().isBooked());
        verify(timeSlotService).saveTimeSlot(returnedAppointment.getTimeSlot());
    }


    @Test
    void testBookAppointment_TimeSlotUnavailable() {
        // Arrange - Mock the behavior for found patient and doctor
        when(patientService.getPatientById(2L)).thenReturn(Optional.of(patient));
        when(doctorService.getDoctorById(1L)).thenReturn(Optional.of(doctor));

        // Mock the behavior for an unavailable time slot
        when(timeSlotService.findAvailableTimeSlot(1L)).thenReturn(Optional.empty());

        // Act and Assert - Expect a TimeSlotAvailabilityException to be thrown
        assertThrows(TimeSlotException.class, () -> {
            appointmentService.bookAppointment(1L, 2L, "Test", 1L);
        });
    }

 @Test
void testUpdateAppointment_Success() {
    // Arrange

        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now().plusMinutes(30);


     // Set up a different time slot for testing the change scenario
     TimeSlot newTimeSlot = new TimeSlot(startTime, endTime, false);

     newTimeSlot.setId(2L); // Different ID for the new time slot
     newTimeSlot.setBooked(false); // Ensure the new time slot is not booked


    AppointmentService.AppointmentUpdateDTO updateDTO = new AppointmentService.AppointmentUpdateDTO(1L,"Updated reason", 2L, 2L, 1L, true);
    when(appointmentRepository.findById(1L)).thenReturn(Optional.of(appointment));
    when(patientService.getPatientById(2L)).thenReturn(Optional.of(patient));
    when(doctorService.getDoctorById(1L)).thenReturn(Optional.of(doctor));
    when(timeSlotService.findAvailableTimeSlot(2L)).thenReturn(Optional.of(newTimeSlot));
    when(appointmentRepository.save(any(Appointment.class))).thenAnswer(invocation -> invocation.getArgument(0));

    // Act
    Appointment returnedAppointment = appointmentService.updateAppointment(updateDTO);

    // Assert
    assertNotNull(returnedAppointment);
    assertEquals("Updated reason", returnedAppointment.getReason());
    assertEquals(1L, returnedAppointment.getDoctor().getPersonDetails().getId());
    assertEquals(2L, returnedAppointment.getPatient().getPersonDetails().getId());
    assertEquals(2L, returnedAppointment.getTimeSlot().getId());
    assertTrue(returnedAppointment.isBooked());
}


    @Test
    void testCancelAppointment_Success() {
        // Arrange
        long appointmentId = 1L;
        appointment.setBooked(true); // Ensure the appointment is initially booked
        when(appointmentRepository.findById(appointmentId)).thenReturn(Optional.of(appointment));

        // Act
        boolean result = appointmentService.cancelAppointment(appointmentId);

        // Assert
        assertTrue(result);
        assertFalse(appointment.isBooked()); // Appointment should be marked as not booked
        verify(appointmentRepository).save(appointment); // Verify appointment is saved
        verify(timeSlotService).saveTimeSlot(appointment.getTimeSlot()); // Verify time slot is freed
    }

    @Test
    void testCancelAppointment_InvalidId() {
        // Arrange
        long invalidAppointmentId = -1L;

        // Act & Assert
        assertThrows(AppointmentBookingException.class, () -> appointmentService.cancelAppointment(invalidAppointmentId));
    }

    @Test
    void testCancelAppointment_AppointmentNotFound() {
        // Arrange
        long nonExistentAppointmentId = 2L;
        when(appointmentRepository.findById(nonExistentAppointmentId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(AppointmentBookingException.class, () -> appointmentService.cancelAppointment(nonExistentAppointmentId));
    }

    @Test
    void testCancelAppointment_AlreadyCanceled() {
        // Arrange
        long appointmentId = 1L;
        appointment.setBooked(false); // Appointment is already not booked
        when(appointmentRepository.findById(appointmentId)).thenReturn(Optional.of(appointment));

        // Act & Assert
        assertThrows(BookingCancelException.class, () -> appointmentService.cancelAppointment(appointmentId));
    }

    @Test
    void testGetAppointmentById_Success() {
        // Arrange
        long appointmentId = 1L;
        when(appointmentRepository.findById(appointmentId)).thenReturn(Optional.of(appointment));

        // Act
        Appointment returnedAppointment = appointmentService.getAppointment(appointmentId);

        // Assert
        assertNotNull(returnedAppointment);
        assertEquals(appointmentId, returnedAppointment.getId());
    }

    @Test
    void testGetAppointmentById_InvalidId() {
        // Arrange
        long invalidAppointmentId = -1L;

        // Act & Assert
        assertThrows(AppointmentBookingException.class, () -> appointmentService.getAppointment(invalidAppointmentId));
    }

    @Test
    void testGetAllAppointment_Success() {
        // Arrange
        when(appointmentRepository.findAll()).thenReturn(List.of(appointment));

        // Act
        List<Appointment> returnedAppointment = appointmentService.getAllAppointments();

        // Assert
        assertNotNull(returnedAppointment);
        assertEquals(1, returnedAppointment.size());
    }

    @Test
    void testGetAllAppointmentByDoctorId_Success() {
        // Arrange
        when(appointmentRepository.findDoctorAppointment(1L)).thenReturn(List.of(appointment));

        // Act
        List<Appointment> returnedAppointment = appointmentService.getAllAppointmentsByDoctorId(1L);

        // Assert
        assertNotNull(returnedAppointment);
        assertEquals(1, returnedAppointment.size());
        assertEquals(1L, returnedAppointment.get(0).getDoctor().getPersonDetails().getId());
        assertEquals(2L, returnedAppointment.get(0).getPatient().getPersonDetails().getId());
    }

    @Test
    void testGetAllAppointmentByPatientId_Success() {
        // Arrange
        when(appointmentRepository.findPatientAppointment(2L)).thenReturn(List.of(appointment));

        // Act
        List<Appointment> returnedAppointment = appointmentService.getAllAppointmentsByPatientId(2L);

        // Assert
        assertNotNull(returnedAppointment);
        assertEquals(1, returnedAppointment.size());
        assertEquals(1L, returnedAppointment.get(0).getDoctor().getPersonDetails().getId());
        assertEquals(2L, returnedAppointment.get(0).getPatient().getPersonDetails().getId());
    }







}
