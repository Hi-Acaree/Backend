package org.acaree.core.service;
import lombok.extern.slf4j.Slf4j;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
@Slf4j
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

    private TimeSlot timeSlot1;
    @Mock
    private AppointmentNotificationPublisher appointmentNotificationPublisher;


    @BeforeEach
    void setUp() {



        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now().plusMinutes(30);
        appointment = new Appointment();
        patient = new Patient();
        doctor = new Doctor();
        timeSlot = new TimeSlot(startTime, endTime, false);

        patient.setPersonDetails(new Person("Jane", "Doe", "cc@tt.com", "1234567890"));
        patient.setId(2L);
        doctor.setPersonDetails(new Person("Dr", "Smith", "keller@test.com", "0987654321"));
        doctor.setId(1L);

        timeSlot.setDoctor(doctor);
        timeSlot.setId(1L);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setTimeSlot(timeSlot);
        appointment.setReason("Test");
        appointment.setId(1L);



    }

    //== private helper methods ==
    private Appointment createMockAppointment() {
        LocalDateTime mockStartTime = LocalDateTime.of(2024, 1, 30, 9, 0);
        LocalDateTime mockEndTime = LocalDateTime.of(2024, 1, 30, 9, 30);
        Appointment appointment = new Appointment();
        appointment.setId(1L);

        Doctor doctor = new Doctor();
        doctor.setId(2L);
        doctor.setPersonDetails(new Person("Dr", "Smith", "dr.smith@example.com", "1234567890"));

        Patient patient = new Patient();
        patient.setId(3L);
        patient.setPersonDetails(new Person("John", "Doe", "john.doe@example.com", "0987654321"));

//      LocalDateTime startTime = LocalDateTime.of(2024, 1, 30, 9, 0);
        timeSlot1 = new TimeSlot(mockStartTime, mockEndTime, false);
        timeSlot1.setId(5L);

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setTimeSlot(timeSlot1);

        return appointment;
    }

    @Test
    void testBookAppointmentByPatient() {
        long patientId = 1L;
        String reason = "Checkup";
        long timeSlotId = 1L;
        Patient mockPatient = new Patient();
        TimeSlot mockTimeSlot = new TimeSlot();

        when(patientService.getPatientById(patientId)).thenReturn(Optional.of(mockPatient));
        when(timeSlotService.findAvailableTimeSlot(timeSlotId)).thenReturn(Optional.of(mockTimeSlot));

        Appointment result = appointmentService.bookAppointmentByPatient(patientId, reason, timeSlotId);

        assertNotNull(result);
        assertEquals(mockPatient, result.getPatient());
        assertEquals(reason, result.getReason());
        assertEquals(mockTimeSlot, result.getTimeSlot());
        assertFalse(result.isBooked());

        verify(appointmentRepository).save(any(Appointment.class));
    }

    @Test
    void testAssignDoctorToAppointment() {
        long appointmentId = 1L;
        long doctorId = 1L;
        long timeSlotId = 1L;
        long patientId = 1L;

        when(appointmentRepository.findById(appointmentId)).thenReturn(Optional.of(appointment));
        when(patientService.getPatientById(patientId)).thenReturn(Optional.of(patient));
        when(doctorService.getDoctorById(doctorId)).thenReturn(Optional.of(doctor));
        when(timeSlotService.findAvailableTimeSlot(timeSlotId)).thenReturn(Optional.of(timeSlot));

        appointmentService.assignDoctorToAppointment(appointmentId, patientId, doctorId, timeSlotId);

        verify(timeSlotService).saveTimeSlot(any(TimeSlot.class));
        verify(appointmentRepository).save(any(Appointment.class));
        verify(appointmentNotificationPublisher).publishMessage(eq("appointment"), any());

        assertTrue(timeSlot.isBooked());
        assertTrue(appointment.isBooked());
    }


//
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
    assertEquals(1L, returnedAppointment.getDoctor().getId());
    assertEquals(2L, returnedAppointment.getPatient().getId());
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
        assertEquals(1L, returnedAppointment.get(0).getDoctor().getId());
        assertEquals(2L, returnedAppointment.get(0).getPatient().getId());
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
        assertEquals(1L, returnedAppointment.get(0).getDoctor().getId());
        assertEquals(2L, returnedAppointment.get(0).getPatient().getId());
    }

    @Test
    void testGetAppointmentNotificationMessage() {
        Appointment appointment = createMockAppointment();
        AppointmentNotificationMessage message = appointmentService.getAppointmentNotificationMessage(appointment);

        assertNotNull(message);
    }

    @Test
    void testSendAppointmentReminder() {
        Appointment appointment = createMockAppointment();
        AppointmentNotificationMessage message = appointmentService.sendAppointmentReminder(appointment);

        assertNotNull(message);
    }

    @Test
    void testSendAppointmentCancellation() {
        Appointment appointment = createMockAppointment();
        AppointmentNotificationMessage message = appointmentService.sendAppointmentCancellation(appointment);

        assertNotNull(message);
    }

    @Test
    void rescheduleAppointment_ShouldRescheduleSuccessfully(){
        long appointmentId = 1L;
        String reasonForChange = "Change in schedule";
        long newTimeSlotId = 2L;

        Appointment mockAppointment = new Appointment();
        mockAppointment.setId(5L);
        mockAppointment.setBooked(true);
        mockAppointment.setReason("Test");
        mockAppointment.setTimeSlot(timeSlot);
        mockAppointment.setPatient(patient);
        mockAppointment.setDoctor(doctor);

        when(appointmentRepository.findById(appointmentId)).thenReturn(Optional.of(mockAppointment));
        when(timeSlotService.findAvailableTimeSlot(newTimeSlotId)).thenReturn(Optional.of(timeSlot));
        when(patientService.getPatientById(2L)).thenReturn(Optional.of(patient));

        when(appointmentRepository.save(any(Appointment.class))).thenAnswer(invocation -> invocation.getArgument(0));


        Appointment rescheduledAppointment = appointmentService.rescheduleAppointment(appointmentId, reasonForChange, newTimeSlotId);
        Logger logger = LoggerFactory.getLogger(AppointmentServiceTest.class);
        logger.info("rescheduledAppointment: {}", rescheduledAppointment.isBooked());

        assertNotNull(rescheduledAppointment);
        assertEquals(timeSlot, rescheduledAppointment.getTimeSlot());
        assertEquals(reasonForChange, rescheduledAppointment.getReason());

        verify(appointmentRepository).save(any(Appointment.class));
        verify(appointmentNotificationPublisher).publishMessage(eq("appointment"), any(AppointmentNotificationMessage.class));
        // Add more verifications as necessary
    }

    @Test
    void rescheduleAppointment_ShouldThrowException_WhenAppointmentNotFound(){
        long appointmentId = 1L;
        String reasonForChange = "Change in schedule";
        long newTimeSlotId = 2L;

        when(appointmentRepository.findById(appointmentId)).thenReturn(Optional.empty());

        assertThrows(AppointmentBookingException.class, () -> appointmentService.rescheduleAppointment(appointmentId, reasonForChange, newTimeSlotId));
    }



















}
