package com.clients.student;

import com.clients.student.dto.StudentDto;
import com.clients.student.dto.StudentToCourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient("SCHOOL-MANAGEMENT")
public interface StudentClient {
    @GetMapping("/getStudentById/{studentId}")
    StudentDto getStudentById(@PathVariable("studentId") Long studentId);
    @GetMapping("/getAllStudents")
    List<StudentDto> getAllStudents();
    @PostMapping("/saveStudent")
    String saveStudent(@RequestBody StudentDto studentDto);
    @PutMapping("/updateStudent")
    String updateStudent(@RequestBody StudentDto studentDto);
    @PostMapping("/studentToCourses")
    String studentToCourse(@RequestBody StudentToCourseDto studentToCourseDto);
    @DeleteMapping("/deleteStudent")
    String deleteStudent(@RequestParam("studentId") Long studentId);
}

