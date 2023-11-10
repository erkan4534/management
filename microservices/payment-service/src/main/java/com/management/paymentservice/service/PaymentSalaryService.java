package com.management.paymentservice.service;

import com.management.paymentservice.model.dto.PaymentSalaryDto;

public interface PaymentSalaryService {
    String savePaymentSalary(PaymentSalaryDto paymentSalaryDto);
    String updatePaymentSalary(PaymentSalaryDto paymentSalaryDto);
    String deletePaymentSalary(Long instructorId);
    PaymentSalaryDto getPaymentSalaryByInstructorId(Long instructorId);
    PaymentSalaryDto getPaymentSalaryByPaymentId(Long paymentId);
}
