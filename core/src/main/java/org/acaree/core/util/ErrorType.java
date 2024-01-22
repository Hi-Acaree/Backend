package org.acaree.core.util;

/**
 * ErrorType is an enum class that contains all the error types that can occur in the application.
 * @see ErrorType
 * @see org.acaree.core.exceptions.AppointmentBookingException
 * @see org.acaree.core.exceptions.DoctorException
 * @see org.acaree.core.exceptions.PatientException
 * @see org.acaree.core.exceptions.TimeSlotException
 * @see org.acaree.core.exceptions.BookingCancelException
 * @see org.acaree.core.exceptions.CustomAppExceptions
 *
 */

public enum ErrorType {

        // == Doctor ==
        DOCTOR_EXISTS,
        DOCTOR_HAS_APPOINTMENTS,
        DOCTOR_NOT_FOUND,
        DOCTOR_NOT_AVAILABLE,
        DOCTOR_INVALID_INPUT,

        //== Patient ==
        PATIENT_EXISTS,
        PATIENT_NOT_FOUND,
        PATIENT_INVALID_INPUT,
        PATIENT_HAS_APPOINTMENTS,

        //== Appointment ==
        APPOINTMENT_ALREADY_BOOKED,
        APPOINTMENT_NOT_FOUND,
        APPOINTMENT_INVALID_INPUT,

        //== cancel ==
        CANCEL_NOT_FOUND,
        CANCEL_NOT_AVAILABLE,


    }