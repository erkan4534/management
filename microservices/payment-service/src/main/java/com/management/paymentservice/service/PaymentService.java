package com.management.paymentservice.service;

import com.management.paymentservice.model.Payment;
import com.management.paymentservice.model.dto.PaymentDto;

public interface PaymentService {
    String savePayment(PaymentDto paymentDto);
    String updatePayment(PaymentDto paymentDto);
}
