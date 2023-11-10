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
    @GetMapping("/getStudentById/{studentId}")
    public StudentDto getStudentById(@PathVariable("studentId") Long studentId){
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/getAllStudents")
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@RequestBody StudentDto studentDto){
        return studentService.saveStudent(studentDto);
    }

    @PutMapping("/updateStudent")
    public String updateStudent(@RequestBody StudentDto studentDto){
        return studentService.updateStudent(studentDto);
    }

    @PostMapping("/studentToCourses")
    public String studentToCourse(@RequestBody StudentToCourseDto studentToCourseDto){
        return studentService.studentToCourse(studentToCourseDto);
    }

    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") Long studentId){
        return studentService.deleteStudent(studentId);
    }
}
