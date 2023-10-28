package com.management.service;

import com.management.model.dto.StudentDto;
import com.management.model.dto.StudentToCourseDto;

import java.util.List;

public interface StudentService {
    StudentDto findStudent(Long studentId);
    List<StudentDto> findAllStudents();
    String updateStudent(StudentDto studentDto);
    String saveStudent(StudentDto studentDto);
    String studentToCourse(StudentToCourseDto studentToCourseDto);
    String deleteStudent(Long StudentId);
}

