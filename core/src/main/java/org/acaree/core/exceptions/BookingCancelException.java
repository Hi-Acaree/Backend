package org.acaree.core.exceptions;


import org.acaree.core.util.ErrorType;

/**
 * Exception for when a booking is attempted for a canceling a booking.
 * <p>This exception is thrown when a booking is attempted for a canceling a booking.</p>
 * <p>It is a {@link RuntimeException} and thus does not need to be declared in the method signature.</p>
 * @see RuntimeException
 * {@code @ErrorType} annotation to provide the details of the error type.
 * {@code @message} annotation to provide the details of the error message.
 */

public class BookingCancelException extends CustomAppExceptions{
    private final ErrorType errorType;

    /**
     * Constructor for BookingCancelException.
     * @param message the error message.
     * @param errorType the error type.
     */

    public BookingCancelException(String message, ErrorType errorType) {
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
}
