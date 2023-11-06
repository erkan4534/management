package com.school.management.service;

import com.management.common.model.dto.InstructorDto;
import com.management.common.model.dto.InstructorToCourseDto;

import java.util.List;

public interface InstructorService {
    InstructorToCourseDto findInstructor(Long instructorId);
    List<InstructorDto> findAllInstructors();
    String updateInstructor(InstructorDto instructorDto);
    String saveInstructor(InstructorDto instructorDto);
    String deleteInstructor(Long instructorId);
}
