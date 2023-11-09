package com.clients.student;

import com.clients.student.dto.StudentDto;
import com.clients.student.dto.StudentToCourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient("SCHOOL-MANAGEMENT")
public interface StudentClient {
    @GetMapping("/students/{id}")
    StudentDto findStudentById(@PathVariable("id") Long id);
    @GetMapping("/students")
    List<StudentDto> findAllStudents();
    @PostMapping("/students")
    String saveStudent(@RequestBody StudentDto studentDto);
    @PutMapping("/students")
    String updateStudent(@RequestBody StudentDto studentDto);
    @PostMapping("/studentToCourses")
    String studentToCourse(@RequestBody StudentToCourseDto studentToCourseDto);
    @DeleteMapping("/students")
    String deleteStudent(@RequestParam("id") Long id);
}

