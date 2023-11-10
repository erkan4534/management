package com.school.management.service.impl;

import com.clients.course.dto.*;
import com.school.management.model.*;
import com.school.management.exception.RecordNotFoundException;
import com.school.management.repository.CourseRepository;
import com.school.management.repository.CourseToStudentRepository;
import com.school.management.repository.InstructorRepository;
import com.school.management.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final CourseToStudentRepository courseToStudentRepository;
    private final ModelMapper modelMapper;

    @Override
    public CourseDto getCourseById(Long courseId) {
        Course courseEntity =courseRepository.findById(courseId).orElseThrow(()->
                new RecordNotFoundException("Course not found with ID :"+courseId));
        CourseDto courseDto = this.modelMapper.map(courseEntity, CourseDto.class);
        courseDto.setInstructorId(courseEntity.getInstructor().getId());
        return courseDto;
    }

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courseEntities =courseRepository.findAll();
        List<CourseDto> courses= courseEntities.stream().map(a->{
            CourseDto courseDto = this.modelMapper.map(a, CourseDto.class);
            courseDto.setInstructorId(a.getInstructor().getId());
            return courseDto;
        }).collect(Collectors.toList());
        return courses;
    }

    @Override
    public String updateCourse(CourseDto courseDto) {
        Course courseEntity = this.modelMapper.map(courseDto, Course.class);
        Instructor instructor = instructorRepository.findById(courseDto.getInstructorId())
                .orElseThrow(()->new RecordNotFoundException("Sistemde kayıtlı bir eğitmen giriniz!"));
        courseEntity.setInstructor(instructor);
        courseRepository.save(courseEntity);
        return "success";
    }

    @Override
    public String saveCourse(CourseDto courseDto) {
        Course courseEntity = this.modelMapper.map(courseDto, Course.class);
        Instructor instructor  =instructorRepository.findById(courseDto.getInstructorId())
                .orElseThrow(()->new RecordNotFoundException("Sistemde kayıtlı bir eğitmen giriniz!"));
        courseEntity.setInstructor(instructor);
        courseRepository.save(courseEntity);
        return "success";
    }

    @Override
    @Transactional
    public String deleteCourse(Long courseId) {
        courseToStudentRepository.deleteByCourseToStudentId_CourseId(courseId);
        courseRepository.deleteById(courseId);
        return "success";
    }
}
