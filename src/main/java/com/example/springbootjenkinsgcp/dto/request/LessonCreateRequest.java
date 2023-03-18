package com.example.springbootjenkinsgcp.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonCreateRequest {

    private String name;

    private String code;
}
