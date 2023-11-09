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
    @GetMapping("/getInstructorDetailInfo/{instructorId}")
    public InstructorDetailInfoDto getInstructorDetailInfo(@PathVariable("instructorId") Long instructorId){
        return instructorService.getInstructorDetailInfo(instructorId);
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

    @DeleteMapping("/deleteInstructor")
    public String deleteInstructor(@RequestParam("instructorId") Long instructorId){
        return instructorService.deleteInstructor(instructorId);
    }
}
