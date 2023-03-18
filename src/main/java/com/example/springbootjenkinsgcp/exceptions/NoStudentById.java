package com.example.springbootjenkinsgcp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoStudentById extends RuntimeException{

    public NoStudentById() {
    }

    public NoStudentById(String message) {
        super(message);
    }
}
