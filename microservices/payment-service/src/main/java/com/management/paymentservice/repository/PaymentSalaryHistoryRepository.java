package com.management.paymentservice.repository;

import com.management.paymentservice.model.PaymentSalaryHistory;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PaymentSalaryHistoryRepository extends JpaRepository<PaymentSalaryHistory, Long> {
}
