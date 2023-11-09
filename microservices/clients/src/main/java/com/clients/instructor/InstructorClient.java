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
    @GetMapping("/getInstructor")
    InstructorDto getInstructor(@RequestParam("id") Long id);
    @GetMapping("/getAllInstructors")
    List<InstructorDto> getAllInstructors();
    @PostMapping("/saveInstructor")
    String saveInstructor(@RequestBody InstructorDto instructorDto);
    @PutMapping("/updateInstructor")
    String updateInstructor(@RequestBody InstructorDto instructorDto);
    @DeleteMapping("/deleteInstructor")
    String deleteInstructorId(@RequestParam("id") Long id);
}
