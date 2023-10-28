package com.management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseToStudentId implements Serializable {
    @Column(name = "COURSE_ID")
    private Long courseId;
    @Column(name = "STUDENT_ID")
    private Long studentId;
}
