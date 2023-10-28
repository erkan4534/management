package com.management.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentDto {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String address;
    private String gender;
}
