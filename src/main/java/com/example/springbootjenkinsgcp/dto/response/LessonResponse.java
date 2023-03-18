package com.example.springbootjenkinsgcp.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonResponse {

    private Long id;

    private String name;

    private String code;
}
