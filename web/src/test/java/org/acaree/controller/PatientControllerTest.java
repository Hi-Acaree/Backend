package org.acaree.controller;
import org.acaree.core.model.Patient;
import org.acaree.core.model.Person;
import org.acaree.core.service.PatientService;
import org.acaree.web.controller.PatientController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PatientController.class)
class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientService patientService;

    private Patient patient;

    @BeforeEach
    void setUp() {
        patient = new Patient();
        patient.setId(1L);
        patient.setPersonDetails(new Person("Jane", "Doe", "cc@test.com", "1234567890" ));
    }

    @Test
    void addPatient() throws Exception {
        Mockito.when(patientService.savePatient(Mockito.any(Patient.class))).thenReturn(patient);

        mockMvc.perform(post("/api/v1/patient/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"personDetails\":{\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"email\":\"cc@test.com\",\"phone\":\"1234567890\"}}"))
                .andExpect(status().isCreated());
    }

    @Test
    void getPatientById() throws Exception {
        Mockito.when(patientService.getPatientById(Mockito.anyLong())).thenReturn(patient);

        mockMvc.perform(get("/api/v1/patient/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"personDetails\":{\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"email\":\"cc@test.com\"}}"));
    }

    @Test
    void getAllPatients() throws Exception {
        Mockito.when(patientService.getAllPatients()).thenReturn(Arrays.asList(patient));

        mockMvc.perform(get("/api/v1/patient/all"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"personDetails\":{\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"email\":\"cc@test.com\",\"phone\":\"1234567890\"}}]"));
    }

    @Test
    void deletePatientById() throws Exception {
        Mockito.doNothing().when(patientService).deletePatient(Mockito.anyLong());

        mockMvc.perform(delete("/api/v1/patient/1/delete"))
                .andExpect(status().isOk());
    }

    @Test
    void updatePatient() throws Exception {
        Mockito.when(patientService.updatePatient(Mockito.any(Patient.class))).thenReturn(patient);

        mockMvc.perform(put("/api/v1/patient/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"personDetails\":{\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"email\":\"cc@test.com\",\"phone\":\"1234567890\"}}"))
                .andExpect(status().isOk());
    }
}