package com.management.common.model.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class InstructorToCourseDto {
    private Long id;
    private String name;
    private String phoneNumber;
    private Set<CourseDto> courses = new HashSet<>();
}
