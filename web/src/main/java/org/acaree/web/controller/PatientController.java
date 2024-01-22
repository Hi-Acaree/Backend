package org.acaree.web.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.model.Patient;
import org.acaree.core.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.acaree.web.ApiMappings.*;
import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequestMapping(PATIENT_BASE_URL)
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @Operation(summary = "Add a new patient", description = "This API is used to add a new patient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Patient added successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping(ADD_PATIENT_URL)
    public ResponseEntity<Patient> addPatient(@Valid @RequestBody Patient patient) {
        log.info("Inside addPatient() method of PatientController class");
        log.info("Patient object: {}", patient);
        return ResponseEntity.status(CREATED).body(patientService.savePatient(patient));
    }

    @Operation(summary = "Get a patient by id", description = "This API is used to get a patient by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Patient fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Patient not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @GetMapping(GET_PATIENT_BY_ID_URL)
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Long id) {
        log.info("Inside getPatientById() method of PatientController class");
        Patient patient = patientService.getPatientById(id);
        return ResponseEntity.ok(patient);
    }

    @Operation(summary = "Get all patients", description = "This API is used to get all patients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Patients fetched successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @GetMapping(GET_ALL_PATIENTS_URL)
    public ResponseEntity<Iterable<Patient>> getAllPatients() {
        log.info("Inside getAllPatients() method of PatientController class");
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @Operation(summary = "Delete a patient by id", description = "This API is used to delete a patient by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Patient deleted successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @DeleteMapping(DELETE_PATIENT_BY_ID_URL)
    public ResponseEntity<?> deletePatientById(@PathVariable("id") Long id) {
        log.info("Inside deletePatientById() method of PatientController class");
        log.info("Patient with id: {}, deleted", id);
        patientService.deletePatient(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Update a patient", description = "This API is used to update a patient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Patient updated successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @PutMapping(UPDATE_PATIENT_URL)
    public ResponseEntity<Patient> updatePatient(@Valid @RequestBody Patient patient) {
        log.info("Inside updatePatient() method of PatientController class");
        return ResponseEntity.ok(patientService.updatePatient(patient));
    }


}
