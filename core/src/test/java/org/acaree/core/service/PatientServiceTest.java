package org.acaree.core.service;

import org.acaree.core.exceptions.PatientException;
import org.acaree.core.model.Patient;
import org.acaree.core.model.Person;
import org.acaree.core.repository.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
 class PatientServiceTest {
    @Mock
    private PatientRepository patientRepository;
    @InjectMocks
    private PatientService patientService;
    private Patient patient;

    @BeforeEach
    void setUp() {
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("John");
        person.setLastName("Doe");

        patient = new Patient();
        patient.setPersonDetails(person);
        patient.setId(1L);


    }

    @Test
    void test_Save_Patient_Success() {
        when(patientRepository.save(any(Patient.class))).thenAnswer(i -> i.getArguments()[0]);

        Patient savedPatient = patientService.savePatient(patient);

        assertNotNull(savedPatient);
        assertEquals(patient.getId(), savedPatient.getId());
        assertEquals(patient.getPersonDetails(), savedPatient.getPersonDetails());

        verify(patientRepository).save(patient);
        verify(patientRepository).save(any(Patient.class));


    }

    @Test
    void test_SavePatient_Failure() {
        when(patientRepository.save(any(Patient.class))).thenThrow(PatientException.class);

        assertThrows(PatientException.class, () -> patientService.savePatient(patient));



    }

    @Test
    void test_GetPatientById_Success() {
        when(patientRepository.findById(any(Long.class))).thenReturn(java.util.Optional.ofNullable(patient));

        Optional<Patient> patientById = patientService.getPatientById(1L);

        assertNotNull(patientById);
        assertEquals(patient.getId(), patientById.isPresent() ? patientById.get().getId() : null);
        assertEquals(patient.getPersonDetails(), patientById.<Object>map(Patient::getPersonDetails).orElse(null));

    }

    @Test
    void test_GetPatientById_Failure() {
        when(patientRepository.findById(any(Long.class))).thenThrow(PatientException.class);

        assertThrows(PatientException.class, () -> patientService.getPatientById(1L));

    }
    @Test
    void testUpdatePatient_Success() {
        // Arrange
        when(patientRepository.findById(patient.getId())).thenReturn(Optional.of(patient));
        when(patientRepository.save(any(Patient.class))).thenAnswer(i -> i.getArguments()[0]);

        // Act
        Patient updatedPatient = patientService.updatePatient(patient);

        // Assert
        assertNotNull(updatedPatient);
        assertEquals(patient.getId(), updatedPatient.getId());
        assertEquals(patient.getPersonDetails(), updatedPatient.getPersonDetails());

        // Verify interactions
        verify(patientRepository).findById(patient.getId());
        verify(patientRepository).save(patient);
    }

    @Test
    void testUpdatePatient_Failure() {
        // Arrange
        when(patientRepository.findById(patient.getId())).thenThrow(PatientException.class);

        // Act and Assert
        assertThrows(PatientException.class, () -> patientService.updatePatient(patient));
    }

    @Test
    void testDeletePatient_Success() {
    }


}
