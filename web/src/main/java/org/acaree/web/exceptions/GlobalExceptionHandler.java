package org.acaree.web.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.acaree.core.exceptions.AppointmentBookingException;
import org.acaree.core.exceptions.BookingCancelException;
import org.acaree.core.exceptions.DoctorException;
import org.acaree.core.exceptions.PatientException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    // Exception handling methods will go here

    @ExceptionHandler(DoctorException.class)
    public ResponseEntity<ErrResponse> handleDoctorException(DoctorException ex, WebRequest request) {
        HttpStatus status;
        switch (ex.getErrorType()) {
            case DOCTOR_NOT_FOUND:
                status = HttpStatus.NOT_FOUND;
                log.error("Doctor not found", ex);
                break;
            case DOCTOR_EXISTS:
            case DOCTOR_NOT_AVAILABLE:
            case DOCTOR_HAS_APPOINTMENTS:
                status = HttpStatus.CONFLICT;
                log.error(String.valueOf(ex));
                break;
            default:
                status = HttpStatus.BAD_REQUEST;
                log.error("Bad request", ex);
        }
        ErrResponse errorResponse = new ErrResponse(status, ex.getMessage());
        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(PatientException.class)
    public ResponseEntity<ErrResponse> handlePatientException(PatientException ex, WebRequest request) {
        HttpStatus status;
        switch (ex.getErrorType()) {
            case PATIENT_NOT_FOUND:
                status = HttpStatus.NOT_FOUND;
                log.error("Patient not found", ex);
                break;
            case PATIENT_EXISTS:
                status = HttpStatus.CONFLICT;
                log.error(String.valueOf(ex));
                break;
            default:
                status = HttpStatus.BAD_REQUEST;
                log.error("Bad request", ex);
        }
        ErrResponse errorResponse = new ErrResponse(status, ex.getMessage());
        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(AppointmentBookingException.class)
    public ResponseEntity<ErrResponse> handleAppointmentBookingException(AppointmentBookingException ex, WebRequest request) {
        HttpStatus status;
        switch (ex.getErrorType()) {
            case APPOINTMENT_ALREADY_BOOKED:
                status = HttpStatus.CONFLICT;
                log.error("Appointment already booked", ex);
                break;
            case APPOINTMENT_NOT_FOUND:
                status = HttpStatus.NOT_FOUND;
                log.error("Appointment not found", ex);
                break;
            default:
                status = HttpStatus.BAD_REQUEST;
                log.error("Bad request", ex);
        }
        ErrResponse errorResponse = new ErrResponse(status, ex.getMessage());
        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(BookingCancelException.class)
    public ResponseEntity<ErrResponse> handleBookingCancelException(BookingCancelException ex, WebRequest request) {
        HttpStatus status;
        switch (ex.getErrorType()) {
            case CANCEL_NOT_FOUND:
                status = HttpStatus.NOT_FOUND;
                log.error("Cancel not found", ex);
                break;
            case CANCEL_NOT_AVAILABLE:
                status = HttpStatus.CONFLICT;
                log.error("Cancel has appointments", ex);
                break;
            default:
                status = HttpStatus.BAD_REQUEST;
                log.error("Bad request", ex);
        }
        ErrResponse errorResponse = new ErrResponse(status, ex.getMessage());
        return new ResponseEntity<>(errorResponse, status);
    }

}

