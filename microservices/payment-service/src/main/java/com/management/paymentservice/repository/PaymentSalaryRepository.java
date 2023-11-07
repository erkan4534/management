package com.management.paymentservice.repository;

import com.management.paymentservice.model.PaymentSalary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentSalaryRepository extends JpaRepository<PaymentSalary, Long> {
    void deleteByInstructor_Id(Long instructorId);
}
