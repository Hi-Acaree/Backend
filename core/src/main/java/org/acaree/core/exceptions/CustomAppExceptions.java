package org.acaree.core.exceptions;

import lombok.extern.slf4j.Slf4j;

/**
 * custom exception class for the application
 * {@code message} annotation to provide the details of the error message.
 * {@code @Slf4j} annotation to generate a logger field.
 *
 */

@Slf4j
public class CustomAppExceptions extends RuntimeException{
    private String message;

    public CustomAppExceptions(String message) {
        this.message = message;
        log.error("An error occurred {}", message);
    }

    public String getMessage() {
        return message;
    }
}
