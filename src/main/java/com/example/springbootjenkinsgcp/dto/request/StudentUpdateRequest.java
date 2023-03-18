package com.example.springbootjenkinsgcp.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentUpdateRequest {

    private String firstName;

    private String lastName;

    private String schoolNo;
}
