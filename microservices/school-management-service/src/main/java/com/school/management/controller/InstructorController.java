package com.school.management.controller;

import com.school.management.model.dto.*;
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
        return instructorService.findStudentById(id);
    }

    @GetMapping("/getInstructor")
    public InstructorDto getInstructor(@RequestParam("instructorId") Long instructorId){
        return instructorService.getInstructor(instructorId);
    }

    @GetMapping("/getAllInstructors")
    public List<InstructorDto> getAllInstructors(){
        return instructorService.getAllInstructors();
    }

    @PostMapping("/saveInstructor")
    public String saveInstructor(@RequestBody InstructorDto instructorDto){
        return instructorService.saveInstructor(instructorDto);
    }

    @PutMapping("/updateInstructor")
    public String updateInstructor(@RequestBody InstructorDto instructorDto){
        return instructorService.updateInstructor(instructorDto);
    }

    @DeleteMapping("/deleteInstructorId")
    public String deleteInstructorId(@RequestParam("id") Long id){
        return instructorService.deleteInstructor(id);
    }
}
