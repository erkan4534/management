package com.school.management.model;

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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    @OneToMany(mappedBy = "instructor")
    private Set<Course> courses = new HashSet<>();

    public Instructor(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

}
