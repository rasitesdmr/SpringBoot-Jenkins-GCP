package com.example.springbootjenkinsgcp.service;

import com.example.springbootjenkinsgcp.dto.request.LessonCreateRequest;
import com.example.springbootjenkinsgcp.dto.response.LessonCreateResponse;
import com.example.springbootjenkinsgcp.dto.response.LessonListResponse;
import com.example.springbootjenkinsgcp.exceptions.LessonAlreadyAvailableException;
import com.example.springbootjenkinsgcp.model.Lesson;
import com.example.springbootjenkinsgcp.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    @Override
    public LessonCreateResponse createLesson(LessonCreateRequest lessonCreateRequest) {

        String lessonCode = lessonCreateRequest.getCode();
        boolean lessonControl = lessonRepository.existsByCode(lessonCode);
        if (lessonControl) {
            throw new LessonAlreadyAvailableException(lessonCode + " koda sahip ders zaten mevcut");
        }
        Lesson lesson = Lesson.builder()
                .name(lessonCreateRequest.getName())
                .code(lessonCreateRequest.getCode())
                .build();
        lessonRepository.save(lesson);

        LessonCreateResponse lessonCreateResponse = LessonCreateResponse.builder()
                .id(lesson.getId())
                .name(lesson.getName())
                .code(lesson.getCode())
                .build();

        return lessonCreateResponse;
    }

    @Override
    public List<LessonListResponse> getAllLessonList() {
       // TODO LİSTE EKLENECEK
        return null;
    }
}
