package com.management.schoolservice.controller;

import com.clients.course.dto.*;
import com.management.schoolservice.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/school")
public class CourseController {

    private final CourseService courseService;
    @GetMapping("/getCourseById")
    public CourseDto getCourseById(@RequestParam("courseId") Long courseId){
        return courseService.getCourseById(courseId);
    }

    @GetMapping("/getAllCourses")
    public List<CourseDto> findAllCourses(){
        return courseService.getAllCourses();
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@RequestBody CourseDto course){
        return courseService.saveCourse(course);
    }

    @PutMapping("/updateCourse")
    public String updateCourse(@RequestBody CourseDto course){
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/deleteCourse")
    public String deleteCourse(@RequestParam("id") Long id){
        return courseService.deleteCourse(id);
    }
}
