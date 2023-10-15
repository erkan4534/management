package com.school.management.model.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
public class StudentDto {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String address;
    private String gender;
}
