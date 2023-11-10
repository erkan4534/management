package com.school.management.service;

import com.clients.instructor.dto.*;
import java.util.List;

public interface InstructorService {
    InstructorDetailInfoDto getInstructorDetailInfo(Long instructorId);
    InstructorDto getInstructorById(Long instructorId);
    List<InstructorDto> getAllInstructors();
    String saveInstructor(InstructorDto instructorDto);
    String updateInstructor(InstructorDto instructorDto);
    String deleteInstructor(Long instructorId);
}
