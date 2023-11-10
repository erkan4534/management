package com.management.paymentservice.repository;

import com.management.paymentservice.model.PaymentSalary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentSalaryRepository extends JpaRepository<PaymentSalary, Long> {
    void deleteByInstructorId(Long instructorId);
    PaymentSalary getByInstructorId(Long instructorId);
}
