package com.example.springbootjenkinsgcp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {


    // TODO :  Exceptionlar düzenlenecek
    @ExceptionHandler(StudentNumberAlreadyAvailableException.class)
    public String handler(StudentNumberAlreadyAvailableException exception) {
        return exception.getMessage();
    }

    // TODO :  Exceptionlar düzenlenecek
    @ExceptionHandler(StudentNumberRegex.class)
    public String handler(StudentNumberRegex exception) {
        return exception.getMessage();
    }


    @ExceptionHandler(StudentTcNoRegex.class)
    public ResponseEntity<?> handle(StudentTcNoRegex exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoStudentById.class)
    public ResponseEntity<?> handle(NoStudentById exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LessonAlreadyAvailableException.class)
    public ResponseEntity<?> handle(LessonAlreadyAvailableException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // TODO :  Exceptionlar düzenlenecek
    @ExceptionHandler(StudentTcNoAlreadyAvailableException.class)
    public String handler(StudentTcNoAlreadyAvailableException exception) {
        return exception.getMessage();
    }
}
