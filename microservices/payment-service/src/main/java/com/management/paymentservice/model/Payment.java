package com.management.paymentservice.model;

import com.management.common.model.Instructor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String iban;
    @ManyToOne
    private Instructor instructor;

    public Payment(String iban, Instructor instructor) {
        this.iban = iban;
        this.instructor = instructor;
    }
}
