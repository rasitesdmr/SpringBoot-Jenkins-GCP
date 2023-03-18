package com.example.springbootjenkinsgcp.repository;

import com.example.springbootjenkinsgcp.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Long> {

    boolean existsByCode(String code);

    Lesson findById(long id);

}
