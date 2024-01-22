package org.acaree.core.exceptions;

import org.acaree.core.util.ErrorType;

/**
 * Exception for when a booking is attempted for a time slot that is already booked.
 * <p>This exception is thrown when a booking is attempted for a time slot that is already booked.</p>
 * <p>It is a {@link RuntimeException} and thus does not need to be declared in the method signature.</p>
 * @see RuntimeException
 * {@code @ErrorType} annotation to provide the details of the error type.
 * {@code @message} annotation to provide the details of the error message.
 * @see ErrorType
 * @see RuntimeException
 * @see org.acaree.core.exceptions.CustomAppExceptions
 *
 *
 */

public class AppointmentBookingException extends CustomAppExceptions {


    private final ErrorType errorType;

    /**
     * Constructor for AppointmentBookingException.
     * @param message the error message.
     * @param errorType the error type.
     */

    public AppointmentBookingException(String message, ErrorType errorType) {
        super(message);
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }



}
