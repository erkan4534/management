package com.school.management.service;

import com.management.common.model.dto.CourseDto;
import java.util.List;

public interface CourseService {
    CourseDto findCourse(Long courseId);
    List<CourseDto> findAllCourses();
    String updateCourse(CourseDto course);
    String saveCourse(CourseDto course);
    String deleteCourse(Long courseId);
}
