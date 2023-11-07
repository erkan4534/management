package com.management.paymentservice.model;

import com.management.common.model.Instructor;
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
@Table(name = "PAYMENT_SALARY_HISTORY")
public class PaymentSalaryHistory {
    @Id
    private Long id;
    private String iban;
    @ManyToOne
    private Instructor instructor;
    private Double salary;
    @CreatedDate
    private LocalDate createDate;
    @LastModifiedDate
    private LocalDate updateDate;
}
