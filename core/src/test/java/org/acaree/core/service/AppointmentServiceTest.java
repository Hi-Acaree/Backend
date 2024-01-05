package org.acaree.core.service;

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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * AppointmentServiceTest is a test class for AppointmentService.
 *
 */

@ExtendWith(MockitoExtension.class)

class AppointmentServiceTest {
    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private DoctorRepository doctorRepository;

    @Mock
    private TimeSlotRepository timeSlotRepository;

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
        timeSlot = new TimeSlot();

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
        timeSlot.setStartTime(startTime);
        timeSlot.setEndTime(endTime);
        timeSlot.setId(1L);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setTimeSlot(timeSlot);
        appointment.setReason("Test");
        appointment.setId(1L);


        // Mock the behavior for an available time slot
        when(timeSlotRepository.findAvailableTimeSlot(1L)).thenAnswer(invocation -> {
            timeSlot.setBooked(false);
            return Optional.of(timeSlot);
        });

        // Mock the behavior for a time slot that becomes booked after calling the method
        doAnswer(invocation -> {
            timeSlot.setBooked(true);
            return null;
        }).when(timeSlotRepository).save(any(TimeSlot.class));


        when(patientRepository.findById(2L)).thenReturn(Optional.of(patient));
        when(doctorRepository.findById(1L)).thenReturn(Optional.of(doctor));
       when(appointmentRepository.save(any(Appointment.class))).thenAnswer(invocation -> {
        Appointment savedAppointment = invocation.getArgument(0);
        return savedAppointment;
});

    }

    @Test
    void testBookAppointment_Success() throws Exception {
        // Arrange (setup is done in setUp method)

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
        verify(timeSlotRepository).save(returnedAppointment.getTimeSlot());
    }






}
