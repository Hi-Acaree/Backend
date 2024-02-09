package org.acaree.core.exceptions;

import lombok.Getter;
import org.acaree.core.util.ErrorType;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

/**
 * PersonException is a custom exception class that extends CustomAppExceptions.
 * @see CustomAppExceptions
 * @see ErrorType
 * {@code @ErrorType} annotation to provide the details of the error type.
 * {@code @message} annotation to provide the details of the error message.
 */
@Getter
public class PersonException extends CustomAppExceptions{

    private final ErrorType errorType;


    public PersonException(String message, ErrorType errorType) {
        super(message);
        this.errorType = errorType;
    }



}
