package com.school.management.service;

import com.school.management.model.dto.*;
import java.util.List;

public interface CourseService {
    CourseDto getCourse(Long courseId);
    List<CourseDto> getAllCourses();
    String saveCourse(CourseDto course);
    String updateCourse(CourseDto course);
    String deleteCourse(Long courseId);
}
