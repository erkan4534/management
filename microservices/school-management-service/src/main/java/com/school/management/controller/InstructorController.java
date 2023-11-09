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
    @GetMapping("/getInstructorDetailInfo/{id}")
    public InstructorDetailInfoDto getInstructorDetailInfo(@PathVariable Long id){
        return instructorService.getInstructorDetailInfo(id);
    }

    @GetMapping("/getInstructor")
    public InstructorDto getInstructor(@RequestParam("id") Long id){
        return instructorService.getInstructor(id);
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
