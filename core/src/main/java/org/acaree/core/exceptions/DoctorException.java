package org.acaree.core.exceptions;

import org.acaree.core.util.ErrorType;

/**
 * DoctorException is a custom exception class that extends CustomAppExceptions.
 * @see CustomAppExceptions
 * @see ErrorType
 * @see DoctorException.DoctorHasAppointmentsException
 * {@code @ErrorType} annotation to provide the details of the error type.
 * {@code @message} annotation to provide the details of the error message.
 */

public class DoctorException extends CustomAppExceptions {

    private final ErrorType errorType;

    /**
     * Constructor for DoctorException.
     * @param message the error message.
     * @param errorType the error type.
     */

    public DoctorException(String message, ErrorType errorType) {
        super(message);
        this.errorType = errorType;
    }

    /**
     * Getter for errorType.
     * @return the error type.
     */

    public ErrorType getErrorType() {
        return errorType;
    }

    /**
     * DoctorHasAppointmentsException is a custom exception class that extends DoctorException.
     * @see DoctorException
     * @see ErrorType
     * {@code @ErrorType} annotation to provide the details of the error type.
     * {@code @message} annotation to provide the details of the error message.
     */

    public static class DoctorHasAppointmentsException extends DoctorException {
        public DoctorHasAppointmentsException(String message) {
            super(message, ErrorType.DOCTOR_HAS_APPOINTMENTS);
        }
    }


}

