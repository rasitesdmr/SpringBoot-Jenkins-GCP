package com.example.springbootjenkinsgcp.repository;

import com.example.springbootjenkinsgcp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsBySchoolNo(String schoolNo);

    boolean existsByTcNo(String tcNo);

}
