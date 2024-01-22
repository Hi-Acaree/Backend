package org.acaree.web.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter @Setter
public class ErrResponse {
    private HttpStatus status;
    private String message;

    public ErrResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }


}
