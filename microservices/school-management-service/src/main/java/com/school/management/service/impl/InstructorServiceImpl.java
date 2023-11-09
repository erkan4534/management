package com.school.management.service.impl;

import com.school.management.model.*;
import com.school.management.model.dto.*;
import com.school.management.exception.RecordNotFoundException;
import com.school.management.repository.CourseRepository;
import com.school.management.repository.InstructorRepository;
import com.school.management.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    @Override
    public InstructorToCourseDto findStudentById(Long instructorId) {
        Instructor InstructorEntity  =instructorRepository.findById(instructorId).orElseThrow(()->
                new RecordNotFoundException("Instructor not found with ID :"+instructorId));
        return this.modelMapper.map(InstructorEntity, InstructorToCourseDto.class);
    }

    @Override
    public InstructorDto getInstructor(Long instructorId) {
        Instructor InstructorEntity  =instructorRepository.findById(instructorId).orElseThrow(()->
                new RecordNotFoundException("Instructor not found with ID :"+instructorId));
        return this.modelMapper.map(InstructorEntity, InstructorDto.class);
    }

    @Override
    public List<InstructorDto> getAllInstructors() {
        List<Instructor> instructorEntities = instructorRepository.findAll();
        return this.modelMapper.map(instructorEntities, new TypeToken<List<InstructorDto>>(){}.getType());
    }

    @Override
    public String updateInstructor(InstructorDto instructorDto) {
        Instructor instructorEntity = this.modelMapper.map(instructorDto, Instructor.class);
        instructorRepository.save(instructorEntity);
        return "success";
    }

    @Override
    public String saveInstructor(InstructorDto instructorDto) {
         Instructor instructorEntity = this.modelMapper.map(instructorDto, Instructor.class);
         instructorRepository.save(instructorEntity);
         return "success";
    }

    @Override
    @Transactional
    public String deleteInstructor(Long instructorId) {
        courseRepository.updateCourseSetNullInstructorId(instructorId);
        restTemplate.delete("http://PAYMENT-SERVICE/payment-salary?instructorId={instructorId}",instructorId);
        instructorRepository.deleteById(instructorId);
        return "success";
    }
}
