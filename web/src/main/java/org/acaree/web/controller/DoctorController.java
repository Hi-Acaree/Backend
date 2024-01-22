package org.acaree.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.model.Appointment;
import org.acaree.core.model.Doctor;
import org.acaree.core.model.TimeSlot;
import org.acaree.core.service.DoctorService;
import org.acaree.web.dto.DoctorAvailabilityDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.acaree.web.ApiMappings.*;
import static org.springframework.http.HttpStatus.*;

/**
 * This class is responsible for handling all the requests related to the doctor.
 * It will be responsible for the following:
 * 1. Adding a new doctor
 * 2. Updating a doctor
 * 3. Deleting a doctor
 * 4. Getting a doctor
 * 5. Getting all the doctors
 * 6. Getting all the doctors by a particular specialization
 * 7. Getting all the doctors by a particular department
 * 8. Getting all appointments of a particular doctor
 * 9. Getting all the patients of a particular doctor
 */

@Slf4j
@RestController
@RequestMapping(BASE_URL)
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Operation(summary = "Add a new doctor", description = "This API is used to add a new doctor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Doctor added successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping(ADD_DOCTOR_URL)
    public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor doctor) {
        log.info("Inside addDoctor() method of DoctorController class");
        return ResponseEntity.status(CREATED).body(doctorService.saveDoctor(doctor));

    }

    @Operation(summary = "Update a doctor", description = "This API is used to update a doctor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Doctor updated successfully"),
            @ApiResponse(responseCode = "404", description = "Doctor not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @PutMapping(UPDATE_DOCTOR_URL)
    public ResponseEntity<Doctor> updateDoctor(@Valid @RequestBody Doctor doctor) {
        log.info("Inside updateDoctor() method of DoctorController class");
        return ResponseEntity.status(OK).body(doctorService.updateDoctor(doctor));
    }

    @Operation(summary = "Delete a doctor by id", description = "This API is used to delete a doctor by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Doctor deleted successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping(DELETE_DOCTOR_BY_ID_URL)
    public ResponseEntity<?> deleteDoctorById(@PathVariable("id") Long id) {
        log.info("Inside deleteDoctor() method of DoctorController class");
        doctorService.deleteDoctorById(id);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @Operation(summary = "Get a doctor by id", description = "This API is used to get a doctor by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Doctor fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Doctor not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @GetMapping(GET_DOCTOR_BY_ID_URL)
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") Long id) {
        log.info("Inside getDoctorById() method of DoctorController class");
        Optional<Doctor> doctorOptional = doctorService.getDoctorById(id);
        return doctorOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get all doctors", description = "This API is used to get all doctors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Doctors fetched successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @GetMapping(GET_ALL_DOCTORS_URL)
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        log.info("Inside getAllDoctors() method of DoctorController class");
        return ResponseEntity.ok().body(doctorService.getAllDoctors());
    }

    @Operation(summary = "Get all doctors by specialization", description = "This API is used to get all doctors by specialization")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Doctors fetched successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @GetMapping(GET_DOCTORS_BY_SPECIALIZATION_URL)
    public ResponseEntity<List<Doctor>> getDoctorsBySpecialization(@RequestParam("specialization") String specialization) {
        log.info("Inside getDoctorsBySpecialization() method of DoctorController class");
        return ResponseEntity.ok().body(doctorService.getDoctorsBySpecialization(specialization));
    }

    @Operation(summary = "Get all doctors appointments by patient id", description = "This API is used to get all doctors appointments by patient id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Doctors appointments fetched successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @GetMapping( GET_DOCTORS_APPOINTMENTS_BY_PATIENT_ID)
    public ResponseEntity<List<Appointment>> getDoctorsAppointmentsByPatientId(@PathVariable("id") Long id,
          @RequestParam("patientId") Long patientId) {
        log.info("Inside getDoctorsAppointmentsByPatientId() method of DoctorController class");
        return ResponseEntity.ok().body(doctorService.getDoctorsAppointmentsByPatientId(id, patientId));
    }

    @Operation(summary = "Get all doctors appointments by patient id and time slot id", description = "This API is used to get all doctors appointments by patient id and time slot id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Doctors appointments fetched successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @GetMapping(GET_DOCTORS_APPOINTMENTS_BY_PATIENT_ID_BY_TIME_SLOT_ID)
    public ResponseEntity<List<Appointment>> getDoctorsAppointmentByPatientIdByTimeSlotId(@PathVariable("id") Long id,
          @PathVariable("patientId") Long patientId, @RequestParam("timeSlotId") Long timeSlotId) {
        log.info("Inside getDoctorsAppointmentByPatientIdByTimeSlotId() method of DoctorController class");
        return ResponseEntity.ok().body(doctorService.getDoctorsAppointmentsByPatientIdAndTimeSlotId(id, patientId, timeSlotId));
    }

    @Operation(summary = "Get all doctors appointments by id", description = "This API is used to get all doctors appointments by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Doctors appointments fetched successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @GetMapping(GET_DOCTORS_APPOINTMENTS_BY_ID)
    public ResponseEntity<List<Appointment>> getDoctorsAppointmentsById(@PathVariable("id") Long id) {
        log.info("Inside getDoctorsAppointmentsById() method of DoctorController class");
        return ResponseEntity.ok().body(doctorService.getDoctorsAppointments(id));
    }

    @Operation(summary = "Get all doctors appointments by time slot id", description = "This API is used to get all doctors appointments by time slot id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Doctors appointments fetched successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @GetMapping(GET_DOCTORS_APPOINTMENTS_BY_TIME_SLOT_ID)
    public ResponseEntity<List<Appointment>> getDoctorsAppointmentsByTimeSlotId( @PathVariable("id") Long doctorId,
        @RequestParam("timeSlotId") Long timeSlotId) {
        log.info("Inside getDoctorsAppointmentsByTimeSlotId() method of DoctorController class");
        return ResponseEntity.ok().body(doctorService.getDoctorsAppointmentsByTimeSlotId(doctorId, timeSlotId));
    }

    @Operation(summary = "Get all doctors by department", description = "This API is used to get all doctors by department")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Doctors fetched successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @GetMapping(GET_DOCTORS_BY_DEPARTMENT_URL)
    public ResponseEntity<List<Doctor>> getDoctorsByDepartment(@RequestParam("department") String department) {
        log.info("Inside getDoctorsByDepartment() method of DoctorController class");
        return ResponseEntity.ok().body(doctorService.getDoctorsByDepartment(department));
    }

    @Operation(summary = "Get all doctors appointments by patient id and time slot id", description = "This API is used to get all doctors appointments by patient id and time slot id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Doctors appointments fetched successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @PutMapping(SET_DOCTOR_AVAILABILITY_URL)
    public ResponseEntity<Void> setDoctorAvailability(@PathVariable("id") Long doctorId,
                                      @Valid @RequestBody DoctorAvailabilityDTO doctorAvailabilityDTO) {
        log.info("Inside setDoctorAvailability() method of DoctorController class");
        doctorService.setDoctorAvailability(doctorId, doctorAvailabilityDTO.getDaysOfTheWeek(), doctorAvailabilityDTO.getTimeSlots());
        return ResponseEntity.status(OK).build();
    }

    @Operation(summary = "Remove doctor availability", description = "This API is used to remove doctor availability")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Doctor availability removed successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping(REMOVE_DOCTOR_AVAILABILITY_URL)
    public ResponseEntity<Void> removeDoctorAvailability(@PathVariable("id") Long doctorId,
      @Valid @RequestBody DoctorAvailabilityDTO doctorAvailabilityDTO) {
        log.info("Inside removeDoctorAvailability() method of DoctorController class");
        doctorService.removeDoctorAvailability(doctorId, doctorAvailabilityDTO.getDaysOfTheWeek());
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @Operation(summary = "Update doctor weekly schedule", description = "This API is used to update doctor weekly schedule")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Doctor weekly schedule updated successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })



    @PutMapping(UPDATE_DOCTOR_WEEKLY_SCHEDULE_URL)
    public ResponseEntity<Void> updateDoctorWeeklySchedule(@PathVariable("id") Long doctorId,
      @Valid @RequestBody DoctorAvailabilityDTO doctorAvailabilityDTO) {
        log.info("Inside updateDoctorWeeklySchedule() method of DoctorController class");
        Map<Doctor.DaysOfTheWeek, Set<TimeSlot>> weeklySchedule = doctorAvailabilityDTO.getWeeklySchedule();

        doctorService.updateDoctorWeeklySchedule(doctorId, weeklySchedule);
        return ResponseEntity.status(OK).build();
    }

    @Operation(summary = "Get doctor availability", description = "This API is used to get doctor availability")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Doctor availability fetched successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @GetMapping(GET_DOCTOR_AVAILABILITY_URL)
    public ResponseEntity<Map<Doctor.DaysOfTheWeek, Set<TimeSlot>>> getDoctorAvailability(@RequestParam("id") Long doctorId) {
        log.info("Inside getDoctorAvailability() method of DoctorController class");
        return ResponseEntity.ok().body(doctorService.getDoctorAvailability(doctorId));
    }





}
