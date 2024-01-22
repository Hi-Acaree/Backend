package org.acaree.core.exceptions;

/**
 * NotificationException is a custom exception class that extends CustomAppExceptions.
 * <p>It is a {@link RuntimeException} and thus does not need to be declared in the method signature.</p>
 * @see CustomAppExceptions
 * {@code @message} annotation to provide the details of the error message.
 */

public class NotificationException extends CustomAppExceptions{

    /**
     * Constructor for NotificationException.
     * @param message the error message.
     */
    public NotificationException(String message) {
        super(message);
    }
}
