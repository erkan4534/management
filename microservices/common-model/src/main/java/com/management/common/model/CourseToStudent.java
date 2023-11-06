package com.management.common.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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


