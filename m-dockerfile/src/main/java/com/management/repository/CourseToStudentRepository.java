package com.management.repository;

import com.management.model.CourseToStudent;
import com.management.model.CourseToStudentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseToStudentRepository extends JpaRepository<CourseToStudent, CourseToStudentId> {
     Long deleteByCourseToStudentId_StudentId(Long studentId);
     Long deleteByCourseToStudentId_CourseId(Long courseId);
}
