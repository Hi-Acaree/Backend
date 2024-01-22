package org.acaree.controller;
import org.acaree.core.model.*;
import org.acaree.core.service.AppointmentService;
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
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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

    @Autowired
    private MockMvc mockMvc;

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
        Long patientId = 1L;
        Long timeSlotId = 1L;
        String reason = "Test reason";

        when(appointmentService.bookAppointmentByPatient(patientId, reason, timeSlotId)).thenReturn(appointment2);

        mockMvc.perform(post("/api/v1/appointment/book/patient/{patientId}/timeslot/{timeSlotId}", patientId, timeSlotId)
                        .param("reason", reason)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(appointment2.getId()));
    }


    @Test
    public void testAssignAppointmentToDoctor() throws Exception {
        long appointmentId = 1L;
        long doctorId = 1L;
        long timeSlotId = 1L;

        mockMvc.perform(put("/api/v1/appointment/assign/{id}/doctor/{doctorId}/timeslot/{timeSlotId}", appointmentId, doctorId, timeSlotId)
                        .contentType(MediaType.APPLICATION_JSON))
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
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(appointmentService).rescheduleAppointment(appointmentId, reason, timeSlotId);
    }

    @Test
    public void testCancelAppointment() throws Exception {
        long appointmentId = 1L;
        when(appointmentService.cancelAppointment(appointmentId)).thenReturn(appointment2.isBooked());
        mockMvc.perform(put("/api/v1/appointment/cancel/{id}", appointmentId)
                        .contentType(MediaType.APPLICATION_JSON))
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
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"patientId\":1,\"doctorId\":1,\"timeSlotId\":1,\"reason\":\"Test reason\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAppointmentById() throws Exception {
        long appointmentId = 1L;
        when(appointmentService.getAppointment(appointmentId)).thenReturn(appointment2);

        mockMvc.perform(get("/api/v1/appointment/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllAppointments() throws Exception {
        List<Appointment> appointments = List.of(appointment2);
        when(appointmentService.getAllAppointments()).thenReturn(appointments);

        mockMvc.perform(get("/api/v1/appointment/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        assertEquals(appointmentService.getAllAppointments(), appointments);

    }

    @Test
    public void testGetAllAppointmentsByDoctorId() throws Exception {
        long doctorId = 1L;
        List<Appointment> appointments = List.of(appointment2);
       when(appointmentService.getAllAppointmentsByDoctorId(doctorId)).thenReturn(appointments);
        mockMvc.perform(get("/api/v1/appointment/doctor/{doctorId}", doctorId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        assertEquals(appointmentService.getAllAppointmentsByDoctorId(doctorId), appointments);

    }

    @Test
    public void testGetAllAppointmentsByPatientId() throws Exception {
        long patientId = 1L;
        List<Appointment> appointments = List.of(appointment2);
        when(appointmentService.getAllAppointmentsByPatientId(patientId)).thenReturn(appointments);

        mockMvc.perform(get("/api/v1/appointment/patient/{patientId}", patientId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testScheduleRecurringAppointment() throws Exception {
        long timeSlotId = 1L;
        long patientId = 1L;
        String reason = "Test reason";
        int numberOfAppointments = 5;
        Period frequency = Period.ofDays(1);


        mockMvc.perform(post("/api/v1/appointment/schedule/recurring")
                        .param("timeSlotId", String.valueOf(timeSlotId))
                        .param("patientId", String.valueOf(patientId))
                        .param("reason", reason)
                        .param("numberOfAppointments", String.valueOf(numberOfAppointments))
                        .param("frequency", String.valueOf(frequency))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}