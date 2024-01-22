package org.acaree.core.exceptions;

import org.acaree.core.util.ErrorType;

/**
 * PatientException is a custom exception class that extends CustomAppExceptions.
 * @see CustomAppExceptions
 * @see ErrorType
 * @see PatientException.PatientHasAppointmentsException
 * {@code @ErrorType} annotation to provide the details of the error type.
 * {@code @message} annotation to provide the details of the error message.
 */

public class PatientException extends CustomAppExceptions {
    private final ErrorType errorType;

    /**
     * Constructor for PatientException.
     * @param message the error message.
     * @param errorType the error type.
     */
    public PatientException(String message, ErrorType errorType) {
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
     * PatientHasAppointmentsException is a custom exception class that extends PatientException.
     * @see PatientException
     * @see ErrorType
     * {@code @ErrorType} annotation to provide the details of the error type.
     * {@code @message} annotation to provide the details of the error message.
     */

    public static class PatientHasAppointmentsException extends PatientException {
        public PatientHasAppointmentsException(String message) {
            super(message, ErrorType.PATIENT_HAS_APPOINTMENTS);
        }
    }


}
