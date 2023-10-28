package com.management.service.impl;

import com.management.exception.RecordNotFoundException;
import com.management.model.Course;
import com.management.model.CourseToStudent;
import com.management.model.CourseToStudentId;
import com.management.model.Student;
import com.management.model.dto.StudentDto;
import com.management.model.dto.StudentToCourseDto;
import com.management.repository.CourseRepository;
import com.management.repository.CourseToStudentRepository;
import com.management.repository.StudentRepository;
import com.management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final CourseToStudentRepository courseToStudentRepository;
    private final ModelMapper modelMapper;
    @Override
    public StudentDto findStudent(Long studentId) {
        Student studentEntity  = studentRepository.findById(studentId).orElseThrow(()->
                new RecordNotFoundException("Student not found with ID :"+studentId));
        return this.modelMapper.map(studentEntity, StudentDto.class);
    }

    @Override
    public List<StudentDto> findAllStudents() {
        List<Student> studentEntities = studentRepository.findAll();
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
