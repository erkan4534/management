package com.school.management.service.impl;

import com.clients.instructor.dto.*;
import com.school.management.model.*;
import com.school.management.exception.RecordNotFoundException;
import com.school.management.repository.CourseRepository;
import com.school.management.repository.InstructorRepository;
import com.school.management.service.InstructorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    @Override
    public InstructorDetailInfoDto getInstructorDetailInfo(Long instructorId) {
        Instructor InstructorEntity  =instructorRepository.findById(instructorId).orElseThrow(()->
                new RecordNotFoundException("Instructor not found with ID :"+instructorId));
        return this.modelMapper.map(InstructorEntity, InstructorDetailInfoDto.class);
    }

    @Override
    public InstructorDto getInstructorById(Long instructorId) {
        Instructor InstructorEntity  =instructorRepository.findById(instructorId).orElseThrow(()->
                new RecordNotFoundException("Instructor not found with ID :"+instructorId));
        log.info("get instructor success");
        return this.modelMapper.map(InstructorEntity, InstructorDto.class);
    }

    @Override
    public List<InstructorDto> getAllInstructors() {
        List<Instructor> instructorEntities = instructorRepository.findAll();
        return this.modelMapper.map(instructorEntities, new TypeToken<List<InstructorDto>>(){}.getType());
    }

    @Override
    public String updateInstructor(InstructorDto instructorDto) {

        Instructor instructor =instructorRepository.findById(instructorDto.getId()).get();

        if(instructor instanceof PermanentInstructor){
            PermanentInstructor instructorEntity = this.modelMapper.map(instructorDto, PermanentInstructor.class);
            instructorRepository.save(instructorEntity);
        }else{
            VisitingResearcher instructorEntity = this.modelMapper.map(instructorDto, VisitingResearcher.class);
            instructorRepository.save(instructorEntity);
        }
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
