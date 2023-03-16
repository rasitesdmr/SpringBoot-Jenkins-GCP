package com.example.springbootjenkinsgcp.controller;

import com.example.springbootjenkinsgcp.dto.request.StudentCreateRequest;
import com.example.springbootjenkinsgcp.dto.response.StudentCreateResponse;
import com.example.springbootjenkinsgcp.dto.response.StudentListResponse;
import com.example.springbootjenkinsgcp.service.StudentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/createStudent")
    ResponseEntity<StudentCreateResponse> createStudent(StudentCreateRequest studentCreateRequest) {
        return new ResponseEntity<>(studentService.createStudent(studentCreateRequest), HttpStatus.CREATED);
    }


    @GetMapping("/getAllStudent")
    ResponseEntity<List<StudentListResponse>> getAllStudent() {
        return new ResponseEntity<>(studentService.getStudentList(), HttpStatus.OK);
    }
}
