package com.management.schoolservice.service.impl;

import com.clients.instructor.dto.*;
import com.management.schoolservice.model.Instructor;
import com.management.schoolservice.model.PermanentInstructor;
import com.management.schoolservice.model.VisitingResearcher;
import com.management.schoolservice.repository.InstructorRepository;
import com.management.schoolservice.service.InstructorService;
import com.management.schoolservice.exception.RecordNotFoundException;
import com.management.schoolservice.repository.CourseRepository;
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
