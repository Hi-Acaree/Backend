package org.acaree.web.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.dto.AppointmentBookingDTO;
import org.acaree.core.model.Appointment;
import org.acaree.core.model.Doctor;
import org.acaree.core.model.TimeSlot;
import org.acaree.core.service.AppointmentService;
import org.acaree.core.service.TimeSlotService;
import org.acaree.core.dto.AppointmentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Period;
import java.util.List;
import java.util.NoSuchElementException;

import static org.acaree.web.ApiMappings.*;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(APPOINTMENT_BASE_URL)
public class AppointmentController {
    private final AppointmentService appointmentService;

    private final TimeSlotService timeSlotService;
    private final AppointmentNotificationController appointmentNotificationController;


    public AppointmentController(AppointmentService appointmentService,
                                 TimeSlotService timeSlotService,
                                 AppointmentNotificationController appointmentNotificationController) {
        this.appointmentService = appointmentService;
        this.timeSlotService = timeSlotService;
        this.appointmentNotificationController = appointmentNotificationController;
    }


    @SneakyThrows
    @Operation(summary = "Book an appointment by patient", description = "This API is used to book an appointment by patient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Appointment booked successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping(BOOK_APPOINTMENT_BY_PATIENT_URL) // http://localhost:8080/api/v1/appointment/book/appointment
    public ResponseEntity<Appointment> bookAppointmentByPatient(@Valid
            @RequestBody AppointmentBookingDTO bookingDTO){
        log.info("Inside bookAppointmentByPatient() method of AppointmentController class");
        ResponseEntity<Appointment> res = ResponseEntity.status(HttpStatus.CREATED)
                .body(appointmentService.bookAppointmentByPatient(bookingDTO));
        appointmentNotificationController.notifyNewAppointment(res.getBody());
        return res;
    }


    @Operation(summary = "Assign appointment to doctor by admin", description = "This API is used to assign appointment to doctor by admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Appointment booked successfully"),
            @ApiResponse(responseCode = "404", description = "Appointment not found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @PutMapping(ASSIGN_APPOINTMENT_TO_DOCTOR_URL)
    public ResponseEntity<Void> assignAppointmentToDoctor(
            @PathVariable("id") Long appointmentId,
            @PathVariable("doctorId") Long doctorId,
            @PathVariable("timeSlotId") Long timeSlotId) throws JsonProcessingException {
        log.info("Inside assignAppointmentToDoctor() method of AppointmentController class");
        appointmentService.assignDoctorToAppointment(appointmentId, doctorId,timeSlotId);
        return ResponseEntity.ok().build();
    }

    @SneakyThrows
    @Operation(summary = "Reschedule appointment by patient", description = "This API is used to reschedule appointment by patient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Appointment rescheduled successfully"),
            @ApiResponse(responseCode = "404", description = "Appointment not found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @PutMapping(RESCHEDULE_APPOINTMENT_URL)
    public ResponseEntity<Void> rescheduleAppointment(
            @PathVariable("id") Long appointmentId,
            @PathVariable("timeSlotId") Long timeSlotId,
            @RequestParam("reason") String reason) {
        log.info("Inside rescheduleAppointment() method of AppointmentController class");
        appointmentService.rescheduleAppointment(appointmentId,reason, timeSlotId);
        return ResponseEntity.ok().build();
    }

    @SneakyThrows
    @Operation(summary = "Cancel appointment", description = "This API is used to cancel appointment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Appointment cancelled successfully"),
            @ApiResponse(responseCode = "404", description = "Appointment not found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @PutMapping(CANCEL_APPOINTMENT_URL)
    public ResponseEntity<Void> cancelAppointment(@PathVariable("id") Long appointmentId) {
        log.info("Inside cancelAppointment() method of AppointmentController class");
        appointmentService.cancelAppointment(appointmentId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Update appointment", description = "This API is used to update appointment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Appointment updated successfully"),
            @ApiResponse(responseCode = "404", description = "Appointment not found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @PutMapping(UPDATE_APPOINTMENT_URL)
    public ResponseEntity<Appointment> updateAppointment(@Valid @RequestBody AppointmentService.AppointmentUpdateDTO dto) {
        log.info("Inside updateAppointment() method of AppointmentController class");
        return ResponseEntity.ok().body(appointmentService.updateAppointment(dto));
    }

    @Operation(summary = "Get appointment by id", description = "This API is used to get appointment by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Appointment fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Appointment not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @GetMapping(GET_AVAILABLE_TIME_SLOTS_FOR_DOCTOR_DAY_URL)
    public ResponseEntity<List<TimeSlot>> getAvailableTimeSlotsForDoctorDay(
            @RequestParam("doctorId") Long doctorId,
            @RequestParam("day") Doctor.DaysOfTheWeek day) {
        log.info("Inside getAvailableTimeSlotsForDoctorDay() method of AppointmentController class");
       try {
           return ResponseEntity.ok().body(timeSlotService.findAvailableTimeSlotsForDoctorAndDay(doctorId, day));
       } catch (NoSuchElementException e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
    }

    @GetMapping(GET_APPOINTMENT_BY_ID_URL)
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") Long id) {
        log.info("Inside getAppointmentById() method of AppointmentController class");
        return ResponseEntity.ok().body(appointmentService.getAppointment(id));
    }

    @Operation(summary = "Get all appointments", description = "This API is used to get all appointments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Appointments fetched successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @GetMapping(GET_ALL_APPOINTMENTS_URL)
    public ResponseEntity<Iterable<Appointment>> getAllAppointments() {
        log.info("Inside getAllAppointments() method of AppointmentController class");
        return ResponseEntity.ok().body(appointmentService.getAllAppointments());
    }

    @Operation(summary = "Get all appointments by doctor id", description = "This API is used to get all appointments by doctor id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Appointments fetched successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @GetMapping(GET_ALL_APPOINTMENTS_BY_DOCTOR_ID_URL)
    public ResponseEntity<Page<AppointmentDTO>> getAllAppointmentsByDoctorId(@PathVariable("doctorId") Long id, Pageable pageable) {
        log.info("Inside getAllAppointmentsByDoctorId() method of AppointmentController class");
        ResponseEntity<Page<AppointmentDTO>>  res = ResponseEntity.ok().body(appointmentService.getAllAppointmentsByDoctorId(id, pageable));
        log.info("res, {}", res);
        return res;

    }



    @Operation(summary = "Get all appointments by doctor id and time slot id", description = "This API is used to get all appointments by doctor id and time slot id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Appointments fetched successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @GetMapping(GET_ALL_APPOINTMENTS_BY_PATIENT_ID_URL)
    public ResponseEntity<List<Appointment>> getAllAppointmentsByPatientId(@PathVariable("patientId") Long id) {
        log.info("Inside getAllAppointmentsByPatientId() method of AppointmentController class");
        return ResponseEntity.ok().body(appointmentService.getAllAppointmentsByPatientId(id));
    }

    @SneakyThrows
    @Operation(summary = "Schedule recurring appointments", description = "This API is used to schedule recurring appointments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Appointments scheduled successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @PostMapping(SCHEDULE_RECURRING_APPOINTMENT_URL)
    public ResponseEntity<List<Appointment>> scheduleRecurringAppointment(
            @Valid @RequestBody AppointmentBookingDTO bookingDTO,
            @NotNull @RequestParam("numberOfAppointments") int numberOfAppointments,
            @NotNull @RequestParam("frequency") String frequency) {
        log.info("Inside scheduleRecurringAppointment() method of AppointmentController class");
        Period periodFrequency = Period.parse(frequency); // Convert string to Period
        return ResponseEntity.ok().body(appointmentService.scheduleReoccurringAppointments(bookingDTO, numberOfAppointments, periodFrequency));
    }






}
