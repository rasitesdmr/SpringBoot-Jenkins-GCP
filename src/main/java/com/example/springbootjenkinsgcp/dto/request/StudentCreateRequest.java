package com.example.springbootjenkinsgcp.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCreateRequest {

    private String firstName;

    private String lastName;

    private String tcNo;

    private String schoolNo;
}
