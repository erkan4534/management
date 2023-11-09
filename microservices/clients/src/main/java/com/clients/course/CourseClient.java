package com.clients.course;

import com.clients.course.dto.CourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("SCHOOL-MANAGEMENT")
public interface CourseClient {
    @GetMapping("/getCourse")
    CourseDto getCourse(@RequestParam("courseId") Long courseId);
    @GetMapping("/getAllCourses")
    List<CourseDto> getAllCourses();
    @PostMapping("/saveCourse")
    String saveCourse(@RequestBody CourseDto course);
    @PutMapping("/updateCourse")
    String updateCourse(@RequestBody CourseDto course);
    @DeleteMapping("/deleteCourse")
    String deleteCourse(@RequestParam Long courseId);
}
