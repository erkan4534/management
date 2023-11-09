package com.clients.course.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {
    private Long id;
    private String name;
    private String code;
    private String creditScore;
    private Long instructorId;
}
