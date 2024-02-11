package com.management.schoolservice.service.impl;

import com.clients.student.dto.*;
import com.management.schoolservice.model.Course;
import com.management.schoolservice.model.CourseToStudent;
import com.management.schoolservice.model.CourseToStudentId;
import com.management.schoolservice.model.Student;
import com.management.schoolservice.repository.CourseToStudentRepository;
import com.management.schoolservice.repository.StudentRepository;
import com.management.schoolservice.service.StudentService;
import com.school.management.model.*;
import com.management.schoolservice.exception.RecordNotFoundException;
import com.management.schoolservice.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final CourseToStudentRepository courseToStudentRepository;
    private final ModelMapper modelMapper;
    @Override
    public StudentDto getStudentById(Long studentId) {
        Student studentEntity  = studentRepository.findById(studentId).orElseThrow(()->
                new RecordNotFoundException("Student not found with ID :"+studentId));
        return this.modelMapper.map(studentEntity, StudentDto.class);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> studentEntities = studentRepository.findAll();
        log.info("get all student successful");
        return this.modelMapper.map(studentEntities, new TypeToken<List<StudentDto>>(){}.getType());
    }

    @Override
    public String updateStudent(StudentDto studentDto) {
        Student studentEntity =this.modelMapper.map(studentDto, Student.class);
        studentRepository.save(studentEntity);
        return "success";
    }

    @Override
    public String saveStudent(StudentDto studentDto) {
        Student studentEntity =this.modelMapper.map(studentDto, Student.class);
        studentRepository.save(studentEntity);
        return "success";
    }

    @Override
    @Transactional
    public String studentToCourse(StudentToCourseDto studentToCourseDto) {
        Student studentEntity  = studentRepository.findById(studentToCourseDto.getStudentId()).orElseThrow(()->
                new RecordNotFoundException("Student not found with studentId :"+ studentToCourseDto.getStudentId()));

        studentToCourseDto.getCourses().forEach(courseId->{
           Course courseEntity =courseRepository.findById(courseId).orElseThrow(()->
                    new RecordNotFoundException("Course not found with courseId :"+courseId));

            CourseToStudentId courseToStudentId = CourseToStudentId.builder()
                   .studentId(studentEntity.getId())
                   .courseId(courseEntity.getId()).build();

            CourseToStudent courseToStudent=CourseToStudent.builder().courseToStudentId(courseToStudentId).build();
            courseToStudentRepository.save(courseToStudent);
        });
        return "success";
    }

    @Override
    @Transactional
    public String deleteStudent(Long StudentId) {
        courseToStudentRepository.deleteByCourseToStudentId_StudentId(StudentId);
        studentRepository.deleteById(StudentId);
        return "success";
    }
}
