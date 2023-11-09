package com.clients.instructor;

import com.clients.instructor.dto.InstructorDto;
import com.clients.instructor.dto.InstructorToCourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("SCHOOL-MANAGEMENT")
public interface InstructorClient {
    @GetMapping("/instructors/{id}")
    InstructorToCourseDto findStudentById(@PathVariable Long id);
    @GetMapping("/instructors")
    InstructorDto findInstructorById(@RequestParam Long instructorId);
    @GetMapping("/instructors")
    List<InstructorDto> findAllInstructors();
    @PostMapping("/instructors")
    String saveInstructor(@RequestBody InstructorDto instructorDto);
    @PutMapping("/instructors")
    String updateInstructor(@RequestBody InstructorDto instructorDto);
    @DeleteMapping("/instructors/id")
    String deleteInstructorId(@RequestParam Long id);
}
