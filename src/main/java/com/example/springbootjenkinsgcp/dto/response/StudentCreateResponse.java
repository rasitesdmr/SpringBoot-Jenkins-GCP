package com.example.springbootjenkinsgcp.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCreateResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String tcNo;

    private String schoolNo;
}
