package com.example.springbootjenkinsgcp.service;

import com.example.springbootjenkinsgcp.dto.request.StudentCreateRequest;
import com.example.springbootjenkinsgcp.dto.response.StudentCreateResponse;

public interface StudentService {

    StudentCreateResponse createStudent(StudentCreateRequest studentCreateRequest);
}
