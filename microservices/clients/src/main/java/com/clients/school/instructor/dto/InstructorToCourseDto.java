package com.clients.school.instructor.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;
import com.clients.school.course.dto.CourseDto;
@Getter
@Setter
public class InstructorToCourseDto {
    private Long id;
    private String name;
    private String phoneNumber;
    private Set<CourseDto> courses = new HashSet<>();
}
