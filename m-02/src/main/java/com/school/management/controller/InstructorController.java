package com.school.management.controller;

import com.school.management.model.dto.InstructorDto;
import com.school.management.model.dto.InstructorToCourseDto;
import com.school.management.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;
    @GetMapping("/instructors/{id}")
    public InstructorToCourseDto findStudentById(@PathVariable Long id){
        return instructorService.findInstructor(id);
    }

    @GetMapping("/instructors")
    public List<InstructorDto> findAllStudents(){
        return instructorService.findAllInstructors();
    }

    @PostMapping("/instructors")
    public String saveInstructor(@RequestBody InstructorDto instructorDto){
        return instructorService.saveInstructor(instructorDto);
    }

    @PutMapping("/instructors")
    public String updateInstructor(@RequestBody InstructorDto instructorDto){
        return instructorService.updateInstructor(instructorDto);
    }

    @DeleteMapping("/instructors/id")
    public String deleteInstructorId(@RequestParam Long id){
        return instructorService.deleteInstructor(id);
    }
}
