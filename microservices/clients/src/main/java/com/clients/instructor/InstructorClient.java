package com.clients.instructor;

import com.clients.instructor.dto.InstructorDto;
import com.clients.instructor.dto.InstructorToCourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient("SCHOOL-MANAGEMENT")
public interface InstructorClient {
    @GetMapping("/instructors/{id}")
    InstructorToCourseDto findStudentById(@PathVariable("id") Long id);
    @GetMapping("/getInstructors")
    InstructorDto findInstructorById(@RequestParam("instructorId") Long instructorId);
    @GetMapping("/getAllInstructors")
    List<InstructorDto> findAllInstructors();
    @PostMapping("/instructors")
    String saveInstructor(@RequestBody InstructorDto instructorDto);
    @PutMapping("/instructors")
    String updateInstructor(@RequestBody InstructorDto instructorDto);
    @DeleteMapping("/instructors")
    String deleteInstructorId(@RequestParam("id") Long id);
}
