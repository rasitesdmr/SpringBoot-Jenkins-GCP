package com.example.springbootjenkinsgcp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class LessonAlreadyAvailableException extends RuntimeException{

    public LessonAlreadyAvailableException() {
    }

    public LessonAlreadyAvailableException(String message) {
        super(message);
    }
}
