package com.school.management.repository;

import com.management.common.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    //method driven query
   @Modifying
   @Query("update Course c set c.instructor.id=null where c.id=:instructorId")
   void updateCourseSetNullInstructorId(Long instructorId);
}
