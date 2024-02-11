package com.management.paymentservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PAYMENT_SALARY_HISTORY")
public class PaymentSalaryHistory {
    @Id
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
}
