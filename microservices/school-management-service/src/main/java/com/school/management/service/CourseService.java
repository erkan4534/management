package com.school.management.service;

import com.school.management.model.dto.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public interface CourseService {
    CourseDto getCourse(@RequestParam Long id);
    List<CourseDto> getAllCourses();
    String saveCourse(@RequestBody CourseDto course);
    String updateCourse(@RequestBody CourseDto course);
    @DeleteMapping("/deleteCourse")
    String deleteCourse(@RequestParam Long id);
}
