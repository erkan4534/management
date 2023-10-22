package com.school.management.model;

import lombok.*;
import jakarta.persistence.*;

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


