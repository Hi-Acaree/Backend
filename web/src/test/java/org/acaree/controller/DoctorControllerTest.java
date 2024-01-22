package org.acaree.controller;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.acaree.core.model.*;
import org.acaree.core.service.DoctorService;
import org.acaree.web.controller.DoctorController;
import org.acaree.web.dto.DoctorAvailabilityDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;
import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@ExtendWith(SpringExtension.class)
@WebMvcTest(DoctorController.class)
public class DoctorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DoctorService doctorService;

    private Doctor doctor;

    private DoctorAvailability doctorAvailability;

    private ObjectMapper objectMapper;

    private Appointment appointment;

    private TimeSlot timeSlot;
    private TimeSlot timeSlot1;
    private TimeSlot timeSlot2;

    private Patient patient;

    private DoctorAvailabilityDTO doctorAvailabilityDTO;

    @BeforeEach
    void setUp() {
        // Set up test data
        timeSlot = new TimeSlot();
        timeSlot.setId(1L);
        timeSlot.setStartTime(LocalDateTime.now());
        timeSlot.setEndTime(LocalDateTime.now().plusHours(1));
        timeSlot.setBooked(false);

        timeSlot1 = new TimeSlot();
        timeSlot1.setId(2L);
        timeSlot1.setStartTime(LocalDateTime.now().plusHours(1));
        timeSlot1.setEndTime(LocalDateTime.now().plusHours(2));
        timeSlot1.setBooked(false);

        timeSlot2 = new TimeSlot();
        timeSlot2.setId(3L);
        timeSlot2.setStartTime(LocalDateTime.now().plusHours(2));
        timeSlot2.setEndTime(LocalDateTime.now().plusHours(3));
        timeSlot2.setBooked(false);

        doctor = new Doctor();
        doctor.setId(1L);
        doctor.setSpecialization("Cardiologist");
        doctor.setHospitalName("Apollo");
        doctor.setDepartmentName("Cardiology");
        doctor.setPersonDetails(new Person("John", "Doe", "john@test.com", "1234567890"));

        patient = new Patient();
        patient.setId(1L);
        patient.setPersonDetails(new Person("Jane", "Doe", "jane@test.com", "1234567890"));

        doctorAvailability = new DoctorAvailability();
        doctorAvailability.setId(1L);
        doctorAvailability.setDayOfWeek(Doctor.DaysOfTheWeek.MONDAY);
        doctorAvailability.setTimeSlots(Set.of(timeSlot, timeSlot1, timeSlot2));
        doctorAvailability.setDoctor(doctor);

        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        appointment = new Appointment();
        appointment.setId(1L);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setTimeSlot(timeSlot);

        doctor.setAppointments(List.of(appointment));
        doctor.setDaysAvailable(Set.of(doctorAvailability));

        doctorAvailabilityDTO = new DoctorAvailabilityDTO();
        doctorAvailabilityDTO.setDaysOfTheWeek(Doctor.DaysOfTheWeek.MONDAY);
        doctorAvailabilityDTO.setTimeSlots(new LinkedHashSet<>(Arrays.asList(timeSlot, timeSlot1, timeSlot2)));
        doctorAvailabilityDTO.setWeeklySchedule(Map.of(Doctor.DaysOfTheWeek.MONDAY, Set.of(timeSlot, timeSlot1, timeSlot2)));





    }
    @Test
    void testAddDoctor() throws Exception {
        Doctor doctor = new Doctor();

        when(doctorService.saveDoctor(any(Doctor.class))).thenReturn(doctor);
        String doctorJson = objectMapper.writeValueAsString(doctor);

        mockMvc.perform(post("/api/v1/doctor/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(doctorJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(doctor.getId())); // Use jsonPath to verify properties of the returned doctor object
    }

    @Test
    void testUpdateDoctor() throws Exception {
        when(doctorService.updateDoctor(any(Doctor.class))).thenReturn(doctor);
        mockMvc.perform(put("/api/v1/doctor/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(doctor)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(doctor.getId()));

    }

    @Test
    void testDeleteDoctorById() throws Exception {
        Long doctorId = 1L;
        mockMvc.perform(delete("/api/v1/doctor/{id}/delete", doctorId))
                .andExpect(status().isNoContent());

        verify(doctorService, times(1)).deleteDoctorById(doctorId);
    }

    @Test
    void testGetDoctorById() throws Exception {
        Long doctorId = 1L;
        when(doctorService.getDoctorById(doctorId)).thenReturn(java.util.Optional.of(doctor));
        mockMvc.perform(get("/api/v1/doctor/{id}", doctorId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(doctor.getId()));
    }

    @Test
    void testGetAllDoctors() throws Exception {
        when(doctorService.getAllDoctors()).thenReturn(List.of(doctor));
        mockMvc.perform(get("/api/v1/doctor/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(doctor.getId()));
    }

    @Test
    void testGetDoctorsBySpecialization() throws Exception {
        String specialization = "Cardiologist";
        when(doctorService.getDoctorsBySpecialization(specialization)).thenReturn(List.of(doctor));
        mockMvc.perform(get("/api/v1/doctor/specialization?specialization={specialization}", specialization))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(doctor.getId()));
    }

    @Test
    void testGetDoctorsAppointmentsByPatientId() throws Exception {
        Long doctorId = 1L;
        Long patientId = 1L;
        when(doctorService.getDoctorsAppointmentsByPatientId(doctorId, patientId)).thenReturn(List.of(appointment));
        mockMvc.perform(get("/api/v1/doctor/appointments/{id}/patientId?patientId={patientId}", doctorId, patientId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(appointment.getId()));
    }

    @Test
    void testGetDoctorsAppointmentsByPatientIdByTimeSlotId() throws Exception {
        Long doctorId = 1L;
        Long patientId = 1L;
        Long timeSlotId = 1L;
        when(doctorService.getDoctorsAppointmentsByPatientIdAndTimeSlotId(doctorId, patientId, timeSlotId)).thenReturn(List.of(appointment));
        mockMvc.perform(get("/api/v1/doctor/appointments/{id}/patient/{patientId}/timeslotId?timeSlotId={timeSlotId}", doctorId, patientId, timeSlotId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(appointment.getId()));
    }

    @Test
    void testGetDoctorsAppointmentsById() throws Exception {
        Long doctorId = 1L;
        when(doctorService.getDoctorsAppointments(doctorId)).thenReturn(List.of(appointment));
        mockMvc.perform(get("/api/v1/doctor/appointments/{id}", doctorId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(appointment.getId()));
    }

    @Test
    void testGetDoctorsAppointmentsByTimeSlotId() throws Exception {
        Long doctorId = 1L;
        Long timeSlotId = 1L;
        when(doctorService.getDoctorsAppointmentsByTimeSlotId(doctorId, timeSlotId)).thenReturn(List.of(appointment));
        mockMvc.perform(get("/api/v1/doctor/appointments/{id}/timeslotId?timeSlotId={timeSlotId}", doctorId, timeSlotId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(appointment.getId()));
    }

    @Test
    void testGetDoctorsByDepartment() throws Exception {
        String department = "Cardiology";
        when(doctorService.getDoctorsByDepartment(department)).thenReturn(List.of(doctor));
        mockMvc.perform(get("/api/v1/doctor/department?department={department}", department))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(doctor.getId()));
    }

    @Test
    void testSetDoctorAvailability() throws Exception {
        Long doctorId = 1L;
        doctorAvailabilityDTO = new DoctorAvailabilityDTO();
        doctorAvailabilityDTO.setDaysOfTheWeek(Doctor.DaysOfTheWeek.MONDAY);
        doctorAvailabilityDTO.setTimeSlots(Set.of(timeSlot, timeSlot1, timeSlot2));
        doctorAvailabilityDTO.setWeeklySchedule(Map.of(Doctor.DaysOfTheWeek.MONDAY, Set.of(timeSlot, timeSlot1, timeSlot2)));

        doNothing().when(doctorService).setDoctorAvailability(eq(doctorId),
                eq(Doctor.DaysOfTheWeek.MONDAY),
                anySet());

        mockMvc.perform(put("/api/v1/doctor/availability/{id}/set", doctorId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(doctorAvailabilityDTO)))
                .andExpect(status().isOk());

        verify(doctorService, times(1)).setDoctorAvailability(
                eq(doctorId),
                eq(Doctor.DaysOfTheWeek.MONDAY),
                anySet());
    }


    @Test
    void testRemoveDoctorAvailability() throws Exception {
    Long doctorId = 1L;
    DoctorAvailabilityDTO doctorAvailabilityDTO = new DoctorAvailabilityDTO();
    doctorAvailabilityDTO.setDaysOfTheWeek(Doctor.DaysOfTheWeek.MONDAY);
    doctorAvailabilityDTO.setTimeSlots(Set.of(timeSlot, timeSlot1, timeSlot2));
    doctorAvailabilityDTO.setWeeklySchedule(Map.of(Doctor.DaysOfTheWeek.MONDAY, Set.of(timeSlot, timeSlot1, timeSlot2)));

    doNothing().when(doctorService).removeDoctorAvailability(eq(doctorId), any(Doctor.DaysOfTheWeek.class));

    mockMvc.perform(delete("/api/v1/doctor/availability/{id}/remove", doctorId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(doctorAvailabilityDTO)))
            .andExpect(status().isNoContent());

    verify(doctorService, times(1)).removeDoctorAvailability(eq(doctorId), any(Doctor.DaysOfTheWeek.class));
    }

    @Test
    void testUpdateDoctorWeeklySchedule() throws Exception {
        Long doctorId = 1L;
        DoctorAvailabilityDTO doctorAvailabilityDTO = new DoctorAvailabilityDTO();
        doctorAvailabilityDTO.setDaysOfTheWeek(Doctor.DaysOfTheWeek.MONDAY);
        doctorAvailabilityDTO.setTimeSlots(Set.of(timeSlot, timeSlot1, timeSlot2));
        doctorAvailabilityDTO.setWeeklySchedule(Map.of(Doctor.DaysOfTheWeek.MONDAY, Set.of(timeSlot, timeSlot1, timeSlot2)));

        doNothing().when(doctorService).updateDoctorWeeklySchedule(eq(doctorId), eq(doctorAvailabilityDTO.getWeeklySchedule()));

        mockMvc.perform(put("/api/v1/doctor/schedule/{id}", doctorId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(doctorAvailabilityDTO)))
                .andExpect(status().isOk());

        verify(doctorService, times(1)).updateDoctorWeeklySchedule(eq(doctorId), eq(doctorAvailabilityDTO.getWeeklySchedule()));
    }

    @Test
    void testGetDoctorAvailability() throws Exception {
        Long doctorId = 1L;
        when(doctorService.getDoctorAvailability(doctorId)).thenReturn(Map.of(Doctor.DaysOfTheWeek.MONDAY, new LinkedHashSet<>(Arrays.asList(timeSlot, timeSlot1, timeSlot2))));

        mockMvc.perform(get("/api/v1/doctor/availability?id={id}", doctorId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.MONDAY").exists())
                .andExpect(jsonPath("$.MONDAY[0].id").value(timeSlot.getId()))
                .andExpect(jsonPath("$.MONDAY[1].id").value(timeSlot1.getId()))
                .andExpect(jsonPath("$.MONDAY[2].id").value(timeSlot2.getId()));
    }






}
