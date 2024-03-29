package org.acaree.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.acaree.core.dto.AppointmentBookingDTO;
import org.acaree.core.dto.AppointmentDTO;
import org.acaree.core.model.*;
import org.acaree.core.service.AppointmentService;
import org.acaree.core.service.TimeSlotService;
import org.acaree.web.controller.AppointmentController;
import org.acaree.web.controller.AppointmentNotificationController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AppointmentController.class)
public class AppointmentControllerTest {

    @MockBean
    private AppointmentService appointmentService;

    @MockBean
    private TimeSlotService timeSlotService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private AppointmentNotificationController appointmentNotificationController;

    private Appointment appointment;
    private Doctor doctor;
    private TimeSlot timeSlot;
    private Patient patient;
    private Appointment appointment2;
    private DoctorAvailability doctorAvailability;

    @BeforeEach
    public void setup() {

        timeSlot = new TimeSlot();
        timeSlot.setId(1L);
        timeSlot.setStartTime(LocalDateTime.now());
        timeSlot.setEndTime(LocalDateTime.now().plusHours(1));


        doctor = new Doctor();
        doctor.setId(1L);
        doctor.setPersonDetails(new Person("Jane", "Doe", "jj@test.com",
                "08090909090"));
        doctor.setSpecialization("Cardiologist");
        doctor.setDepartmentName("Cardiology");
        doctor.setHospitalName("Doreen");

        patient = new Patient();
        patient.setId(1L);
        patient.setPersonDetails(new Person("Jane", "Doe", "tt@test.com",
                "08090909090"));

        doctorAvailability = new DoctorAvailability();
        doctorAvailability.setId(1L);
        doctorAvailability.setDayOfWeek(Doctor.DaysOfTheWeek.MONDAY);
        doctorAvailability.setTimeSlots(Set.of(timeSlot));
        doctorAvailability.setDoctor(doctor);


        appointment2 = new Appointment();
        appointment2.setId(2L);
        appointment2.setDoctor(doctor);
        appointment2.setTimeSlot(timeSlot);
        appointment2.setPatient(patient);
        appointment2.setReason("Test reason");


    }

    @Test
    void bookAppointmentByPatientTest() throws Exception {
        AppointmentBookingDTO bookingDTO = new AppointmentBookingDTO(); // Populate this with test data
        Appointment expectedAppointment = new Appointment(); // Populate this with expected result
        expectedAppointment.setPatient(patient);
        expectedAppointment.setDoctor(doctor);
        expectedAppointment.setTimeSlot(timeSlot);
        expectedAppointment.setReason("Test reason");

        // Mock the service layer to return the expected appointment
        Mockito.when(appointmentService.bookAppointmentByPatient(Mockito.any(AppointmentBookingDTO.class))).thenReturn(expectedAppointment);

        mockMvc.perform(post("/api/v1/appointment/book/appointment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(bookingDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.reason", is("Test reason")));
        // Verify that the notification method was called
        Mockito.verify(appointmentNotificationController, Mockito.times(1)).notifyNewAppointment(Mockito.any(Appointment.class));

          }



    @Test
    public void testAssignAppointmentToDoctor() throws Exception {
        long appointmentId = 1L;
        long doctorId = 1L;
        long timeSlotId = 1L;

        mockMvc.perform(put("/api/v1/appointment/assign/{id}/doctor/{doctorId}/timeslot/{timeSlotId}", appointmentId, doctorId, timeSlotId)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testRescheduleAppointment() throws Exception {
        long appointmentId = 1L;
        long timeSlotId = 1L;
        String reason = "Test reason";

        when(appointmentService.rescheduleAppointment(appointmentId, reason, timeSlotId )).thenReturn(appointment2);


        mockMvc.perform(put("/api/v1/appointment/reschedule/{id}/timeslot/{timeSlotId}",appointmentId, timeSlotId )
                        .param("reason", "Test reason")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(appointmentService).rescheduleAppointment(appointmentId, reason, timeSlotId);
    }

    @Test
    public void testCancelAppointment() throws Exception {
        long appointmentId = 1L;
        when(appointmentService.cancelAppointment(appointmentId)).thenReturn(appointment2.isBooked());
        mockMvc.perform(put("/api/v1/appointment/cancel/{id}", appointmentId)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(appointmentService).cancelAppointment(appointmentId);
        assertEquals(appointment2.isBooked(), false);
    }

    @Test
    public void testUpdateAppointment() throws Exception {
        AppointmentService.AppointmentUpdateDTO dto = new AppointmentService.AppointmentUpdateDTO(
                1L, "Test Reason", 1L, 1L, 1L, false);

        when(appointmentService.updateAppointment(dto)).thenReturn(appointment2);

        mockMvc.perform(put("/api/v1/appointment/update")
                        .contentType(APPLICATION_JSON)
                        .content("{\"id\":1,\"patientId\":1,\"doctorId\":1,\"timeSlotId\":1,\"reason\":\"Test reason\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAppointmentById() throws Exception {
        long appointmentId = 1L;
        when(appointmentService.getAppointment(appointmentId)).thenReturn(appointment2);

        mockMvc.perform(get("/api/v1/appointment/{id}", 1L)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllAppointments() throws Exception {
        List<Appointment> appointments = List.of(appointment2);
        when(appointmentService.getAllAppointments()).thenReturn(appointments);

        mockMvc.perform(get("/api/v1/appointment/all")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        assertEquals(appointmentService.getAllAppointments(), appointments);

    }

    @Test
    public void testGetAllAppointmentsByDoctorId() throws Exception {
        // Arrange
        Pageable pageable = PageRequest.of(0, 20);
        long doctorId = 1L;
        List<AppointmentDTO> appointmentDTOList = new ArrayList<>();
        Page<AppointmentDTO> appointments = new PageImpl<>(appointmentDTOList, pageable, 0);

        // Mock the service call with specific Pageable
        when(appointmentService.getAllAppointmentsByDoctorId(eq(doctorId), eq(pageable))).thenReturn(appointments);

        // Act & Assert
        mockMvc.perform(get("/api/v1/appointment/doctor/{doctorId}", doctorId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        // Include additional assertions as needed

        // Verify the service was called with specific Pageable
        verify(appointmentService).getAllAppointmentsByDoctorId(eq(doctorId), eq(pageable));
    }



    @Test
    public void testGetAllAppointmentsByPatientId() throws Exception {
        long patientId = 1L;
        List<Appointment> appointments = List.of(appointment2);
        when(appointmentService.getAllAppointmentsByPatientId(patientId)).thenReturn(appointments);

        mockMvc.perform(get("/api/v1/appointment/patient/{patientId}", patientId)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testScheduleRecurringAppointment() throws Exception {
        // Given
        AppointmentBookingDTO bookingDTO = new AppointmentBookingDTO(1L, "patient@example.com", "Patient Name", 2L, "Check-up", "Virtual");
        int numberOfAppointments = 3;
        String frequency = "P1W"; // Weekly frequency

        // Mocking the service call
        when(appointmentService.scheduleReoccurringAppointments(eq(bookingDTO), eq(numberOfAppointments), any(Period.class)))
                .thenReturn(Collections.emptyList()); // Return an empty list for simplicity

        // When & Then
        mockMvc.perform(post("/api/v1/appointment/schedule/recurring")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookingDTO))
                        .param("numberOfAppointments", String.valueOf(numberOfAppointments))
                        .param("frequency", frequency))
                .andExpect(status().isOk()); // Assuming the controller returns HttpStatus.OK (200)

        // Additional assertions to verify the response can be added here
    }
}