package com.management.controller;

import com.management.model.dto.CourseDto;
import com.management.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    @GetMapping("/courses/id")
    public CourseDto findCourseById(@RequestParam Long id){
        return courseService.findCourse(id);
    }

    @GetMapping("/courses")
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

    @DeleteMapping("/courses/id")
    public String deleteCourse(@RequestParam Long id){
        return courseService.deleteCourse(id);
    }
}
