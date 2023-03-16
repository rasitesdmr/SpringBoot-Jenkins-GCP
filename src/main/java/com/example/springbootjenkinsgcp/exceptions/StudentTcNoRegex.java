package com.example.springbootjenkinsgcp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StudentTcNoRegex extends RuntimeException{

    public StudentTcNoRegex() {
    }

    public StudentTcNoRegex(String message) {
        super(message);
    }

    public StudentTcNoRegex(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentTcNoRegex(Throwable cause) {
        super(cause);
    }


}
