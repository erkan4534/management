package com.clients.course;

import com.clients.course.dto.CourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("SCHOOL-MANAGEMENT")
public interface CourseClient {
    @GetMapping("/getCourses")
    CourseDto findCourseById(@RequestParam Long id);
    @GetMapping("/getAllCourses")
    List<CourseDto> findAllCourses();
    @PostMapping("/courses")
    String saveCourse(@RequestBody CourseDto course);
    @PutMapping("/courses")
    String updateCourse(@RequestBody CourseDto course);
    @DeleteMapping("/courses/id")
    String deleteCourse(@RequestParam Long id);
}
