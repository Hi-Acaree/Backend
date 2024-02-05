package org.acaree.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.acaree.core.dto.AppointmentBookingDTO;
import org.acaree.core.model.*;
import org.acaree.core.service.AppointmentService;
import org.acaree.core.service.TimeSlotService;
import org.acaree.web.controller.AppointmentController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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

    // Test methods will go here

    @Test
    public void testBookAppointmentByPatient() throws Exception {
        AppointmentBookingDTO bookingDTO = new AppointmentBookingDTO(1L, "cc@test.com", "", 1L, "check up");

        when(appointmentService.bookAppointmentByPatient(bookingDTO)).thenReturn(appointment2);

        mockMvc.perform(post("/api/v1/appointment/book/appointment")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookingDTO)))
                .andExpect(status().isCreated()); // Assuming the controller returns HttpStatus.CREATED (201)
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
        long doctorId = 1L;
        List<Appointment> appointments = List.of(appointment2);
       when(appointmentService.getAllAppointmentsByDoctorId(doctorId)).thenReturn(appointments);
        mockMvc.perform(get("/api/v1/appointment/doctor/{doctorId}", doctorId)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
        assertEquals(appointmentService.getAllAppointmentsByDoctorId(doctorId), appointments);

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
        AppointmentBookingDTO bookingDTO = new AppointmentBookingDTO(1L, "patient@example.com", "Patient Name", 2L, "Check-up");
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