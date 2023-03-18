package com.example.springbootjenkinsgcp.dto.response;

import com.example.springbootjenkinsgcp.model.Lesson;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentLessonsResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String tcNo;

    private String schoolNo;

    private List<LessonResponse> lessonList;
}
