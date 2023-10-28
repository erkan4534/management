package com.management.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentToCourseDto {
    private Long studentId;
    private List<Long> courses;
}
