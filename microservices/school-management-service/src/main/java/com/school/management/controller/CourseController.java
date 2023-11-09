package com.school.management.controller;

import com.school.management.model.dto.*;
import com.school.management.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    @GetMapping("/getCourses")
    public CourseDto findCourseById(@RequestParam("id") Long id){
        return courseService.findCourse(id);
    }

    @GetMapping("/getAllCourses")
    public List<CourseDto> findAllCourses(){
        return courseService.findAllCourses();
    }

    @PostMapping("/courses")
    public String saveCourse(@RequestBody CourseDto course){
        return courseService.saveCourse(course);
    }

    @PutMapping("/courses")
    public String updateCourse(@RequestBody CourseDto course){
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/courses")
    public String deleteCourse(@RequestParam("id") Long id){
        return courseService.deleteCourse(id);
    }
}
