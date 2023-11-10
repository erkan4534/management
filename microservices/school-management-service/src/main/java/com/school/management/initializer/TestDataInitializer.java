package com.school.management.initializer;

import com.school.management.model.*;
import com.school.management.model.enums.Gender;
import com.school.management.repository.CourseRepository;
import com.school.management.repository.InstructorRepository;
import com.school.management.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.Month;

@Component
@RequiredArgsConstructor
public class TestDataInitializer implements ApplicationRunner {

    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args)  {
        System.out.println("Start....");

        if(studentRepository.findAll().size()!=0){
            return;
        }

        Instructor instructor1 = new PermanentInstructor("İrfan","12344",10000D);
        Instructor instructor2 = new VisitingResearcher("Serdar","445566",100D);

        Course course1 = new Course("Matematik","mtm","50",instructor1);
        Course course2 = new Course("Türkçe","tkç","40",instructor2);
        Course course3 = new Course("İngilizce","ing","70",instructor2);

        Student student1 = new Student("Ali", LocalDate.of(2000, Month.APRIL,22),"Kadıköy", Gender.MALE.getGender());
        Student student2 = new Student("Kemal", LocalDate.of(2001, Month.JANUARY,22),"Bostancı", Gender.MALE.getGender());
        Student student3 = new Student("Ekin", LocalDate.of(2000, Month.DECEMBER,22),"Suadiye",Gender.FEMALE.getGender());

        student1.getCourses().add(course1);
        student1.getCourses().add(course2);
        student2.getCourses().add(course1);
        student3.getCourses().add(course1);
        student3.getCourses().add(course3);

        course1.getStudents().add(student1);
        course1.getStudents().add(student2);
        course2.getStudents().add(student3);

        instructor1.getCourses().add(course1);
        instructor2.getCourses().add(course2);
        instructor2.getCourses().add(course3);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);

        instructorRepository.save(instructor1);
        instructorRepository.save(instructor2);

        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);

        System.out.println("Start....");
    }
}
