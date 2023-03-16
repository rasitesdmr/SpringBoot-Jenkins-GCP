package com.example.springbootjenkinsgcp.service;

import com.example.springbootjenkinsgcp.dto.request.StudentCreateRequest;
import com.example.springbootjenkinsgcp.dto.response.StudentCreateResponse;
import com.example.springbootjenkinsgcp.exceptions.StudentNumberAlreadyAvailableException;
import com.example.springbootjenkinsgcp.exceptions.StudentTcNoAlreadyAvailableException;
import com.example.springbootjenkinsgcp.model.Student;
import com.example.springbootjenkinsgcp.repository.StudentRepository;
import com.example.springbootjenkinsgcp.utils.RegexUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public StudentCreateResponse createStudent(StudentCreateRequest studentCreateRequest) {
        var schoolTcNumber = studentCreateRequest.getTcNo();
        var schoolNumber = studentCreateRequest.getSchoolNo();

        var schoolTcNumberWithRegex = RegexUtils.schoolTcNo(schoolTcNumber);
        var schoolNumberNumberWithRegex = RegexUtils.schoolNumberRegex(schoolNumber);

        var schoolTcNumberCheck = studentRepository.existsByTcNo(schoolTcNumber);
        if (schoolTcNumberCheck) {
            throw new StudentTcNoAlreadyAvailableException(schoolTcNumber + " kimlik numaralı ile kayıtlı bir öğrenci var");
        }

        var schoolNumberCheck = studentRepository.existsBySchoolNo(schoolNumber);
        if (schoolNumberCheck) {
            throw new StudentNumberAlreadyAvailableException(schoolNumber + " numaralı öğrenci zaten mevcut !!!");
        }

        Student student = Student.builder()
                .firstName(studentCreateRequest.getFirstName())
                .lastName(studentCreateRequest.getLastName())
                .tcNo(studentCreateRequest.getTcNo())
                .schoolNo(studentCreateRequest.getSchoolNo())
                .build();
        studentRepository.save(student);

        StudentCreateResponse studentCreateResponse = StudentCreateResponse.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .schoolNo(schoolNumberNumberWithRegex)
                .tcNo(schoolTcNumberWithRegex)
                .build();


        return studentCreateResponse;
    }
}
