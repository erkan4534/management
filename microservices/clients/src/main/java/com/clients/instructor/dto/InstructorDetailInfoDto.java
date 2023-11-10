package com.clients.instructor.dto;

import com.clients.course.dto.CourseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class InstructorDetailInfoDto {
    private Long id;
    private String name;
    private String phoneNumber;
    private Set<CourseDto> courses = new HashSet<>();
}
