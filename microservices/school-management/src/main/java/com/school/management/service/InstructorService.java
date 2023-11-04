package com.school.management.service;

import com.school.management.model.dto.InstructorDto;
import com.school.management.model.dto.InstructorToCourseDto;

import java.util.List;

public interface InstructorService {
    InstructorToCourseDto findInstructor(Long instructorId);
    List<InstructorDto> findAllInstructors();
    String updateInstructor(InstructorDto instructorDto);
    String saveInstructor(InstructorDto instructorDto);
    String deleteInstructor(Long instructorId);
}
