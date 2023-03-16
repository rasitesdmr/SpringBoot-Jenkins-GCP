package com.example.springbootjenkinsgcp.service;

import com.example.springbootjenkinsgcp.dto.request.StudentCreateRequest;
import com.example.springbootjenkinsgcp.dto.response.StudentCreateResponse;
import com.example.springbootjenkinsgcp.dto.response.StudentListResponse;

import java.util.List;

public interface StudentService {

    StudentCreateResponse createStudent(StudentCreateRequest studentCreateRequest);

   List<StudentListResponse>  getStudentList();
}
