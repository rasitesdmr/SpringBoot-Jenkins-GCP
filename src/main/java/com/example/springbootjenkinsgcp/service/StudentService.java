package com.example.springbootjenkinsgcp.service;

import com.example.springbootjenkinsgcp.dto.request.StudentCreateRequest;
import com.example.springbootjenkinsgcp.dto.request.StudentUpdateRequest;
import com.example.springbootjenkinsgcp.dto.response.StudentCreateResponse;
import com.example.springbootjenkinsgcp.dto.response.StudentLessonsResponse;
import com.example.springbootjenkinsgcp.dto.response.StudentListResponse;
import com.example.springbootjenkinsgcp.dto.response.StudentUpdateResponse;

import java.util.List;

public interface StudentService {

    StudentCreateResponse createStudent(StudentCreateRequest studentCreateRequest);

   List<StudentListResponse>  getStudentList();

   void deleteStudentById(long studentId);

   StudentUpdateResponse studentUpdate(String studentTC , StudentUpdateRequest studentUpdateRequest);

   StudentLessonsResponse allLessonOfTheStudent(String studentNo);


}
