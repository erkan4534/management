package com.school.management.repository;

import com.school.management.model.CourseToStudent;
import com.school.management.model.CourseToStudentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseToStudentRepository extends JpaRepository<CourseToStudent, CourseToStudentId> {
     Long deleteByCourseToStudentId_StudentId(Long studentId);
     Long deleteByCourseToStudentId_CourseId(Long courseId);
}
