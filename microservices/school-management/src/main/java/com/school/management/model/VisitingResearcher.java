package com.school.management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class VisitingResearcher extends Instructor{
    private Double hourlyWage;
    public VisitingResearcher(String name, String phoneNumber,Double hourlyWage) {
        super(name,phoneNumber);
        this.hourlyWage=hourlyWage;
    }
}

