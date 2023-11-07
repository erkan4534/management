package com.management.paymentservice.repository;

import com.management.paymentservice.model.PaymentSalary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentSalary, Long> {
}
