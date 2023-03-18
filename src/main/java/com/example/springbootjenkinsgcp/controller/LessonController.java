package com.example.springbootjenkinsgcp.controller;

import com.example.springbootjenkinsgcp.dto.request.LessonCreateRequest;
import com.example.springbootjenkinsgcp.dto.response.LessonCreateResponse;
import com.example.springbootjenkinsgcp.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lesson")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @PostMapping("/createLesson")
    ResponseEntity<LessonCreateResponse> createLesson(LessonCreateRequest lessonCreateRequest){
        return new ResponseEntity<>(lessonService.createLesson(lessonCreateRequest), HttpStatus.CREATED);
    }
}
