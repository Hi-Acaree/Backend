package org.acaree.core.exceptions;

/**
 * Exception for when a booking is attempted for a time slot that is already booked.
 * <p>
 *     This exception is thrown when a booking is attempted for a time slot that is already booked.
 *     </p>
 *
 */

public class TimeSlotAvailabilityException extends CustomAppExceptions{
    private String message;

    public TimeSlotAvailabilityException(
            String message) {super(message);}


}
