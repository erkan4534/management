package com.management.schoolservice.service;

import com.clients.student.dto.*;
import java.util.List;

public interface StudentService {
    StudentDto getStudentById(Long studentId);
    List<StudentDto> getAllStudents();
    String updateStudent(StudentDto studentDto);
    String saveStudent(StudentDto studentDto);
    String studentToCourse(StudentToCourseDto studentToCourseDto);
    String deleteStudent(Long StudentId);
}

