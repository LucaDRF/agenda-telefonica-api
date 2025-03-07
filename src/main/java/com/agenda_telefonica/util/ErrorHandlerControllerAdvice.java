package com.agenda_telefonica.util;

import com.agenda_telefonica.error.BaseError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerControllerAdvice {
    @ExceptionHandler(BaseError.class)
    public ResponseEntity handleException(BaseError e) {
        return ResponseEntity.status(e.getStatus()).body(e.getMessage());
    }
}
