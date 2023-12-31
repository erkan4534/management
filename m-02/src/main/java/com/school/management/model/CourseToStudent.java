package com.school.management.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "COURSE_STUDENT")
public class CourseToStudent {
  @EmbeddedId
  private CourseToStudentId courseToStudentId;
}


