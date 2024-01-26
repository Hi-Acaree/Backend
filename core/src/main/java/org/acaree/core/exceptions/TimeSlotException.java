package org.acaree.core.exceptions;

import lombok.Getter;
import org.acaree.core.util.ErrorType;

/**
 * Exception for when a booking is attempted for a time slot that is already booked.
 * <p>
 *     This exception is thrown when a booking is attempted for a time slot that is already booked.
 *     </p>
 *     <p> It is a {@link RuntimeException} and thus does not need to be declared in the method signature.</p>
 *     @see RuntimeException
 *     {@code @message} annotation to provide the details of the error message.
 *     @see CustomAppExceptions
 *
 */

public class TimeSlotException extends CustomAppExceptions {
    private String message; // error message
    /**
     * -- GETTER --
     * Getter for errorType.
     */
    @Getter
    private final ErrorType errorType;

    /**
     * Constructor for TimeSlotException.
     *
     * @param message the error message.
     * @param errorType the error type.
     */

    public TimeSlotException(
            String message,
            ErrorType errorType) {
        super(message);
        this.errorType = errorType;
    }

}

