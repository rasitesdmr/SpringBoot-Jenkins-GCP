package com.example.springbootjenkinsgcp.controller;

import com.example.springbootjenkinsgcp.dto.request.StudentCreateRequest;
import com.example.springbootjenkinsgcp.dto.request.StudentUpdateRequest;
import com.example.springbootjenkinsgcp.dto.response.StudentCreateResponse;
import com.example.springbootjenkinsgcp.dto.response.StudentLessonsResponse;
import com.example.springbootjenkinsgcp.dto.response.StudentListResponse;
import com.example.springbootjenkinsgcp.dto.response.StudentUpdateResponse;
import com.example.springbootjenkinsgcp.repository.StudentRepository;
import com.example.springbootjenkinsgcp.service.StudentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/createStudent")
    ResponseEntity<StudentCreateResponse> createStudent(@RequestBody StudentCreateRequest studentCreateRequest) {
        return new ResponseEntity<>(studentService.createStudent(studentCreateRequest), HttpStatus.CREATED);
    }


    @GetMapping("/getAllStudent")
    ResponseEntity<List<StudentListResponse>> getAllStudent() {
        return new ResponseEntity<>(studentService.getStudentList(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudentById")
    public void getAllStudent(@RequestParam long studentId) {
        studentService.deleteStudentById(studentId);
    }

    @PutMapping("/updateStudent")
    ResponseEntity<StudentUpdateResponse> studentUpdate(@RequestParam String schoolTcNo , @RequestBody StudentUpdateRequest studentUpdateRequest) {
        return new ResponseEntity<>(studentService.studentUpdate(schoolTcNo,studentUpdateRequest),HttpStatus.OK);
    }

    @GetMapping("/lessonOfTheStudent")
    ResponseEntity<StudentLessonsResponse> allLessonOfTheStudent (@RequestParam String studentNo){
        return new ResponseEntity<>(studentService.allLessonOfTheStudent(studentNo),HttpStatus.OK);
    }

}
