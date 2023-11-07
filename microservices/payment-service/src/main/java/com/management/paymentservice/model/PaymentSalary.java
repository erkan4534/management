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
@Table(name = "PAYMENT_SALARY")
public class PaymentSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String iban;
    @ManyToOne
    private Instructor instructor;
    private Double salary;

    public PaymentSalary(String iban, Instructor instructor,Double salary) {
        this.iban = iban;
        this.instructor = instructor;
        this.salary = salary;
    }
}
