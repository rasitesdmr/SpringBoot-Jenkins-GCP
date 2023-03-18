package com.example.springbootjenkinsgcp.service;

import com.example.springbootjenkinsgcp.dto.request.StudentCreateRequest;
import com.example.springbootjenkinsgcp.dto.request.StudentUpdateRequest;
import com.example.springbootjenkinsgcp.dto.response.*;
import com.example.springbootjenkinsgcp.exceptions.NoStudentById;
import com.example.springbootjenkinsgcp.exceptions.StudentNumberAlreadyAvailableException;
import com.example.springbootjenkinsgcp.exceptions.StudentTcNoAlreadyAvailableException;
import com.example.springbootjenkinsgcp.model.Lesson;
import com.example.springbootjenkinsgcp.model.Student;
import com.example.springbootjenkinsgcp.repository.StudentRepository;
import com.example.springbootjenkinsgcp.utils.RegexUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
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

    @Override
    public List<StudentListResponse> getStudentList() {
        List<Student> student = studentRepository.findAll();
        List<StudentListResponse> studentListResponses = new ArrayList<>();

        for (Student newStudent : student) {
            StudentListResponse studentListResponse = new StudentListResponse();
            studentListResponse.setId(newStudent.getId());
            studentListResponse.setFirstName(newStudent.getFirstName());
            studentListResponse.setLastName(newStudent.getLastName());
            studentListResponse.setTcNo(newStudent.getTcNo());
            studentListResponse.setSchoolNo(newStudent.getSchoolNo());
            studentListResponses.add(studentListResponse);
        }

        return studentListResponses;
    }

    @Override
    public void deleteStudentById(long studentId) {

        try {
            var student = studentRepository.findById(studentId);
            studentRepository.delete(student);
            log.info(studentId + " numaralı id'ye sahip öğrenci silindi");
        } catch (Exception exception) {
            throw new NoStudentById(studentId + " numaralı id'ye sahip öğrenci yok ");
        }


    }

    @Override
    public StudentUpdateResponse studentUpdate(String studentTC, StudentUpdateRequest studentUpdateRequest) {

        try {
            boolean currentStudent = studentRepository.existsByTcNo(studentTC);
            if (currentStudent) {
                Student student = studentRepository.findByTcNo(studentTC);
                student.setFirstName(studentUpdateRequest.getFirstName());
                student.setLastName(studentUpdateRequest.getLastName());
                student.setSchoolNo(studentUpdateRequest.getSchoolNo());
                studentRepository.save(student);

                StudentUpdateResponse studentUpdateResponse = StudentUpdateResponse.builder()
                        .id(student.getId())
                        .firstName(student.getFirstName())
                        .lastName(student.getLastName())
                        .schoolNo(student.getSchoolNo())
                        .tcNo(student.getTcNo())
                        .build();

                return studentUpdateResponse;
            }
        } catch (Exception exception) {
            throw new RuntimeException();
        }
        return null;
    }

    @Override
    public StudentLessonsResponse allLessonOfTheStudent(String studentNo) {
        boolean currentExistStudent = studentRepository.existsBySchoolNo(studentNo);
        if (currentExistStudent) {
            Student student = studentRepository.findBySchoolNo(studentNo);
            List<Lesson> lessonList = student.getLessonList();
            List<LessonResponse> lessonResponseList = new ArrayList<>();
            for (Lesson lesson : lessonList) {
                LessonResponse lessonResponse = new LessonResponse();
                lessonResponse.setId(lesson.getId());
                lessonResponse.setName(lesson.getName());
                lessonResponse.setCode(lesson.getCode());

                lessonResponseList.add(lessonResponse);
            }
            StudentLessonsResponse studentLessonsResponse = StudentLessonsResponse.builder()
                    .id(student.getId())
                    .firstName(student.getFirstName())
                    .lastName(student.getLastName())
                    .schoolNo(student.getSchoolNo())
                    .tcNo(student.getTcNo())
                    .lessonList(lessonResponseList)
                    .build();

            return studentLessonsResponse;
        }


        return null;
    }


}
