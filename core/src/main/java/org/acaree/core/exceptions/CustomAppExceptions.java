package org.acaree.core.exceptions;

import lombok.extern.slf4j.Slf4j;

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
