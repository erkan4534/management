package com.management.paymentservice.service;

import com.clients.payment.dto.PaymentSalaryDto;
import java.util.List;

public interface PaymentSalaryService {
    String savePaymentSalary(PaymentSalaryDto paymentSalaryDto);
    String updatePaymentSalary(PaymentSalaryDto paymentSalaryDto);
    String deletePaymentSalary(Long instructorId);
    List<PaymentSalaryDto> getPaymentSalaryByInstructorId(Long instructorId);
    PaymentSalaryDto getPaymentSalaryByPaymentId(Long paymentId);
}
