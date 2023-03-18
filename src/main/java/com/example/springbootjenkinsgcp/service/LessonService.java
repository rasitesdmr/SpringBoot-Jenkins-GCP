package com.example.springbootjenkinsgcp.service;

import com.example.springbootjenkinsgcp.dto.request.LessonCreateRequest;
import com.example.springbootjenkinsgcp.dto.response.LessonCreateResponse;
import com.example.springbootjenkinsgcp.dto.response.LessonListResponse;

import java.util.List;

public interface LessonService {

    LessonCreateResponse createLesson(LessonCreateRequest lessonCreateRequest);

    List<LessonListResponse> getAllLessonList();


}
