package com.example.springbootjenkinsgcp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class StudentNumberAlreadyAvailableException extends RuntimeException {

    public StudentNumberAlreadyAvailableException() {
    }

    public StudentNumberAlreadyAvailableException(String message) {
        super(message);
    }

    public StudentNumberAlreadyAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNumberAlreadyAvailableException(Throwable cause) {
        super(cause);
    }

}
