package com.example.springbootjenkinsgcp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String tcNo;

    private String schoolNo;

    @ManyToMany
    @JoinTable(name = "student_lesson",
            joinColumns = {
                    @JoinColumn(name = "studentId")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "lessonId")
            })
    private List<Lesson> lessonList;

}
