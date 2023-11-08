package com.management.paymentservice.model;

import com.management.common.model.Instructor;
import com.management.paymentservice.service.impl.PaymentSalaryHistoryServiceImpl;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PAYMENT_SALARY")
@EntityListeners(PaymentSalaryHistoryServiceImpl.class)
public class PaymentSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String iban;
    @ManyToOne
    private Instructor instructor;
    private Double salary;
    private LocalDate createDate;
    private LocalDate updateDate;

    public PaymentSalary(String iban, Instructor instructor,Double salary) {
        this.iban = iban;
        this.instructor = instructor;
        this.salary = salary;
    }
}
