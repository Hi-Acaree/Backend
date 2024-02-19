package org.acaree.core.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.dto.AppointmentBookingDTO;
import org.acaree.core.dto.AppointmentDTO;
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
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.Period;
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
    private PatientRepository patientRepository;
    @Mock
    private ObjectMapper objectMapper;

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
    private Person person;


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
        TimeSlot timeSlot1 = new TimeSlot(mockStartTime, mockEndTime, false);
        timeSlot1.setId(5L);

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setTimeSlot(timeSlot1);

        return appointment;
    }

    @Test
    void testBookAppointmentByPatient() throws JsonProcessingException {
        AppointmentBookingDTO appointmentBookingDTO = new AppointmentBookingDTO(1L, "cc@tt.com",
                "Jane Doe", 1L, "Checkup", "virtual");

        when(patientService.ensureTemporaryRecordOfPatient(appointmentBookingDTO.getEmail())).thenReturn(patient);
        when(doctorService.getDoctorById(appointmentBookingDTO.getDoctorId())).thenReturn(Optional.of(doctor));
        when(timeSlotService.findAvailableTimeSlot(appointmentBookingDTO.getTimeSlotId())).thenReturn(Optional.of(timeSlot));
        when(appointmentRepository.save(any(Appointment.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Appointment result = appointmentService.bookAppointmentByPatient(appointmentBookingDTO);

        assertNotNull(result);
        assertEquals(appointmentBookingDTO.getReason(), result.getReason());
        assertEquals(appointmentBookingDTO.getDoctorId(), result.getDoctor().getId());
        assertEquals(appointmentBookingDTO.getEmail(), result.getPatient().getPersonDetails().getEmail());
         assertEquals(appointmentBookingDTO.getPatientName(), result.getPatient().getPersonDetails().getFirstName() + " " + result.getPatient().getPersonDetails().getLastName());
        assertEquals(appointmentBookingDTO.getTimeSlotId(), result.getTimeSlot().getId());
        assertTrue(result.isBooked());

        verify(appointmentRepository).save(any(Appointment.class));
    }


    @Test
    void testAssignDoctorToAppointment() throws JsonProcessingException {
        long appointmentId = 1L;
        long doctorId = 1L;
        long timeSlotId = 1L;

        when(appointmentRepository.findById(appointmentId)).thenReturn(Optional.of(appointment));
        when(doctorService.getDoctorById(doctorId)).thenReturn(Optional.of(doctor));
        when(timeSlotService.findAvailableTimeSlot(timeSlotId)).thenReturn(Optional.of(timeSlot));

        appointmentService.assignDoctorToAppointment(appointmentId, doctorId, timeSlotId);

        verify(timeSlotService).saveTimeSlot(any(TimeSlot.class));
        verify(appointmentRepository).save(any(Appointment.class));
        verify(appointmentNotificationPublisher).publishMessage(eq("appointment-queue"), any());
        assertEquals(doctor, appointment.getDoctor());
        assertEquals(timeSlot, appointment.getTimeSlot());

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
    when(patientService.getPatientById(2L)).thenReturn(patient);
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
    void testCancelAppointment_Success() throws JsonProcessingException {
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
    void testGetAllAppointmentsByDoctorId_Success() {
        // Arrange
        Doctor doctor = new Doctor();
        doctor.setId(1L);
        Patient patient = new Patient();
        patient.setId(2L);
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setId(3L);
        timeSlot.setStartTime(LocalDateTime.now());
        timeSlot.setEndTime(LocalDateTime.now().plusMinutes(30));
        Person person = new Person();
        person.setId(4L);
        person.setFirstName("Jared");
        person.setLastName("Smith");
        person.setEmail("cc@test.com");
        person.setPhone("1234567890");
        doctor.setPersonDetails(person);
        doctor.setSpecialization("Cardiologist");
        doctor.setHospitalName("Elaine Hospital");
        doctor.setDepartmentName("Cardiology");
        Person person1 = new Person();
        person1.setFirstName("Zoe");
        person1.setLastName("Doe");
        person1.setEmail("zoe@test.com");
        person1.setPhone("1234567890");
        patient.setPersonDetails(person1);

        Pageable pageable = PageRequest.of(0, 10); // Example pageable request

        // Mocking the appointment details, assuming 'appointment' is a pre-made instance of Appointment
        Appointment appointment = mock(Appointment.class); // Ensure this is properly instantiated or mocked based on your setup
        when(appointment.getDoctor()).thenReturn(doctor); // Mocking Doctor inside Appointment
        when(appointment.getPatient()).thenReturn(patient); // Mocking Patient inside Appointment
        when(appointment.getTimeSlot()).thenReturn(timeSlot);
        when(appointmentRepository.findDoctorAppointment(eq(1L), any(Pageable.class)))
                .thenReturn(new PageImpl<>(List.of(appointment)));

        // Act
        Page<AppointmentDTO> returnedAppointmentPage = appointmentService.getAllAppointmentsByDoctorId(1L, pageable);

        // Assert
        assertNotNull(returnedAppointmentPage);
        assertEquals(1, returnedAppointmentPage.getContent().size()); // Check the size of the content inside the page

        AppointmentDTO returnedAppointmentDTO = returnedAppointmentPage.getContent().get(0);
        assertEquals(1L, returnedAppointmentDTO.getDoctor().getId());
        assertEquals(2L, returnedAppointmentDTO.getPatient().getId());
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
        log.info("Message: {}", message);

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
    void rescheduleAppointment_Success() throws JsonProcessingException {
        long appointmentId = 1L;
        String reasonForChange = "Change in schedule";
        long newTimeSlotId = 2L;
        TimeSlot  oldTimeSlot = new TimeSlot(LocalDateTime.now(), LocalDateTime.now().plusHours(1), true);
        TimeSlot  newTimeSlot = new TimeSlot(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(1), false);

        Patient patient = new Patient();
        patient.setPersonDetails(new Person("John", "Doe", "john.doe@example.com", "1234567890"));
        Doctor doctor = new Doctor();
        doctor.setPersonDetails(new Person("Kevin", "Keegan", "kevin@test.com", "09089786754" ));


        appointment = new Appointment();
        appointment.setId(appointmentId);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setBooked(true);
        appointment.setTimeSlot(oldTimeSlot);

        when(appointmentRepository.findById(appointmentId)).thenReturn(Optional.of(appointment));
        when(timeSlotService.findAvailableTimeSlot(newTimeSlotId)).thenReturn(Optional.of(newTimeSlot));
        when(objectMapper.writeValueAsString(any(AppointmentNotificationMessage.class))).thenReturn("notification message");
        when(appointmentRepository.save(any(Appointment.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Appointment rescheduledAppointment = appointmentService.rescheduleAppointment(appointmentId, reasonForChange, newTimeSlotId);

        // Assert
        assertNotNull(rescheduledAppointment);
        assertEquals(newTimeSlot, rescheduledAppointment.getTimeSlot());
        assertEquals(reasonForChange, rescheduledAppointment.getReason());
        assertEquals(true, rescheduledAppointment.getTimeSlot().isBooked());

        verify(timeSlotService, times(2)).saveTimeSlot(any(TimeSlot.class));
        verify(appointmentNotificationPublisher).publishMessage(eq("appointment-queue"), eq("notification message"));

        ArgumentCaptor<TimeSlot> timeSlotCaptor = ArgumentCaptor.forClass(TimeSlot.class);
        verify(timeSlotService, times(2)).saveTimeSlot(timeSlotCaptor.capture());

        List<TimeSlot> allValues = timeSlotCaptor.getAllValues();
    // Assuming the first call is to save the old time slot and the second call is to save the new time slot
        assertFalse(allValues.get(0).isBooked()); // Check the old time slot is freed
        assertTrue(allValues.get(1).isBooked()); // Check the new time slot is booked
    }


    // Additional test cases...



    @Test
    void rescheduleAppointment_ShouldThrowException_WhenAppointmentNotFound(){
        long appointmentId = 1L;
        String reasonForChange = "Change in schedule";
        long newTimeSlotId = 2L;

        when(appointmentRepository.findById(appointmentId)).thenReturn(Optional.empty());

        assertThrows(AppointmentBookingException.class, () -> appointmentService.rescheduleAppointment(appointmentId, reasonForChange, newTimeSlotId));
    }




    @Test
    void testScheduleReoccurringAppointments_InvalidInput() throws AppointmentBookingException{
        AppointmentBookingDTO appointmentBookingDTO = new AppointmentBookingDTO(2L, "cc@test.com", "Annonymous", 1L, "Checkup", "virtual");
        int numberOfAppointments = 0;
        Period recurrencePeriod = Period.ofWeeks(1);

        assertThrows(AppointmentBookingException.class, () -> appointmentService.scheduleReoccurringAppointments(appointmentBookingDTO, numberOfAppointments, recurrencePeriod));
    }

}
