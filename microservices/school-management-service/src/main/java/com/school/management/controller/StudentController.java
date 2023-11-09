package com.school.management.controller;

import com.school.management.model.dto.*;
import com.school.management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @GetMapping("/students/{id}")
    public StudentDto findStudentById(@PathVariable("id") Long id){
        return studentService.getStudent(id);
    }

    @GetMapping("/students")
    public List<StudentDto> findAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/students")
    public String saveStudent(@RequestBody StudentDto studentDto){
        return studentService.saveStudent(studentDto);
    }

    @PutMapping("/students")
    public String updateStudent(@RequestBody StudentDto studentDto){
        return studentService.updateStudent(studentDto);
    }

    @PostMapping("/studentToCourses")
    public String studentToCourse(@RequestBody StudentToCourseDto studentToCourseDto){
        return studentService.studentToCourse(studentToCourseDto);
    }

    @DeleteMapping("/students")
    public String deleteStudent(@RequestParam("id") Long id){
        return studentService.deleteStudent(id);
    }
}
