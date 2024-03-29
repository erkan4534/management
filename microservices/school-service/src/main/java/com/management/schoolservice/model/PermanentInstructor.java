package com.management.schoolservice.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PermanentInstructor extends Instructor {
    private Double fixedSalary;
    public PermanentInstructor(String name, String phoneNumber,Double fixedSalary) {
        super(name,phoneNumber);
        this.fixedSalary=fixedSalary;
    }
}

