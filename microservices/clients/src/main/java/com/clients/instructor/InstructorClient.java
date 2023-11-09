package com.clients.instructor;

import com.clients.instructor.dto.InstructorDto;
import com.clients.instructor.dto.InstructorToCourseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient("SCHOOL-MANAGEMENT")
public interface InstructorClient {
    @GetMapping("/getInstructorDetailInfo/{instructorId}")
    InstructorToCourseDto getInstructorDetailInfo(@PathVariable("instructorId") Long instructorId);
    @GetMapping("/getInstructor")
    InstructorDto getInstructor(@RequestParam("instructorId") Long instructorId);
    @GetMapping("/getAllInstructors")
    List<InstructorDto> getAllInstructors();
    @PostMapping("/saveInstructor")
    String saveInstructor(@RequestBody InstructorDto instructorDto);
    @PutMapping("/updateInstructor")
    String updateInstructor(@RequestBody InstructorDto instructorDto);
    @DeleteMapping("/deleteInstructor")
    String deleteInstructorId(@RequestParam("instructorId") Long instructorId);
}
