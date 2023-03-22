package com.example.springbootjenkinsgcp.controller;

import com.example.springbootjenkinsgcp.dto.request.LessonCreateRequest;
import com.example.springbootjenkinsgcp.dto.response.LessonCreateResponse;
import com.example.springbootjenkinsgcp.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;

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
