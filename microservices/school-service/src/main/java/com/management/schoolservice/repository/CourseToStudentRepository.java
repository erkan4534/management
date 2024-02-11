package com.management.schoolservice.repository;

import com.management.schoolservice.model.CourseToStudent;
import com.management.schoolservice.model.CourseToStudentId;
import com.school.management.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseToStudentRepository extends JpaRepository<CourseToStudent, CourseToStudentId> {
     Long deleteByCourseToStudentId_StudentId(Long studentId);
     Long deleteByCourseToStudentId_CourseId(Long courseId);
}
