package com.management.rabbitmq.paymentservice.repository;

import com.management.rabbitmq.paymentservice.model.PaymentSalary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentSalaryRepository extends JpaRepository<PaymentSalary, Long> {
    void deleteByInstructorId(Long instructorId);
    List<PaymentSalary> findByInstructorId(Long instructorId);

}
