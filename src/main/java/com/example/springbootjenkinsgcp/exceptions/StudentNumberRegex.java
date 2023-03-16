package com.example.springbootjenkinsgcp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StudentNumberRegex extends RuntimeException{

    public StudentNumberRegex() {
    }

    public StudentNumberRegex(String message) {
        super(message);
    }

    public StudentNumberRegex(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNumberRegex(Throwable cause) {
        super(cause);
    }


}
