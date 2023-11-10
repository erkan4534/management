package com.school.management.service;

import com.clients.course.dto.*;
import java.util.List;

public interface CourseService {
    CourseDto getCourseById(Long courseId);
    List<CourseDto> getAllCourses();
    String saveCourse(CourseDto course);
    String updateCourse(CourseDto course);
    String deleteCourse(Long courseId);
}
