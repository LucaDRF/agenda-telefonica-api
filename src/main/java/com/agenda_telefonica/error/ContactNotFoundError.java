package com.agenda_telefonica.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ContactNotFoundError extends BaseError {
    private final int status;

    public ContactNotFoundError(String message) {
        super(message);

        status = HttpStatus.BAD_REQUEST.value();
    }
}
