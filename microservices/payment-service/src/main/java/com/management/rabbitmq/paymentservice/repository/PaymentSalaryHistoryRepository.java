package com.management.rabbitmq.paymentservice.repository;

import com.management.rabbitmq.paymentservice.model.PaymentSalaryHistory;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PaymentSalaryHistoryRepository extends JpaRepository<PaymentSalaryHistory, Long> {
}
