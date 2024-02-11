package com.management.schoolservice.repository;

import com.management.schoolservice.model.Instructor;
import com.school.management.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
