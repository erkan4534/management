package com.management.paymentservice.model;

import com.management.common.model.Instructor;
import com.management.paymentservice.service.AuditListener;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PAYMENT_SALARY")
@EntityListeners(AuditListener.class)
public class PaymentSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String iban;
    @ManyToOne
    private Instructor instructor;
    private Double salary;
    @CreatedDate
    private LocalDate createDate;
    @LastModifiedDate
    private LocalDate updateDate;

    public PaymentSalary(String iban, Instructor instructor,Double salary) {
        this.iban = iban;
        this.instructor = instructor;
        this.salary = salary;
    }

    @PreRemove
    void preRemove(){

    }
}
