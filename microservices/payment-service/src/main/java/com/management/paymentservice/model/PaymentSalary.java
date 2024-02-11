package com.management.paymentservice.model;

import com.management.paymentservice.service.impl.PaymentSalaryHistoryServiceImpl;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    @Column(name = "ID")
    private Long id;
    @Column(name = "IBAN")
    private String iban;
    @Column(name="INSTRUCTOR_ID")
    private Long instructorId;
    @Column(name = "SALARY")
    private Double salary;
    @Column(name = "UPDATE_DATE")
    private LocalDate updateDate;
    @Column(name = "CREATE_DATE")
    private LocalDate createDate;

    public PaymentSalary(String iban, Long instructorId,Double salary) {
        this.iban = iban;
        this.instructorId = instructorId;
        this.salary = salary;
    }
}
