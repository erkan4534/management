package com.school.management.controller;

import com.school.management.model.dto.StudentDto;
import com.school.management.model.dto.StudentToCourseDto;
import com.school.management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @GetMapping("/students/{id}")
    public StudentDto findStudentById(@PathVariable Long id){
        return studentService.findStudent(id);
    }

    @GetMapping("/students")
    public List<StudentDto> findAllStudents(){
        return studentService.findAllStudents();
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

    @DeleteMapping("/students/id")
    public String deleteStudent(@RequestParam Long id){
        return studentService.deleteStudent(id);
    }
}
