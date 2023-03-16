package com.example.springbootjenkinsgcp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class StudentTcNoAlreadyAvailableException extends RuntimeException{
    public StudentTcNoAlreadyAvailableException() {
    }

    public StudentTcNoAlreadyAvailableException(String message) {
        super(message);
    }

    public StudentTcNoAlreadyAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentTcNoAlreadyAvailableException(Throwable cause) {
        super(cause);
    }


}
