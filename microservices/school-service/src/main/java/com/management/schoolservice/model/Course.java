package com.management.schoolservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String creditScore;
    @ManyToMany
    @JoinTable(
            name = "COURSE_STUDENT",
            joinColumns = @JoinColumn(name = "STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    private Set<Student> students = new HashSet<>();
    @ManyToOne
    private Instructor instructor;

    public Course(String name, String code, String creditScore, Instructor instructor) {
        this.name = name;
        this.code = code;
        this.creditScore = creditScore;
        this.instructor = instructor;
    }
}
