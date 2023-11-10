package com.clients.payment;

import com.clients.payment.dto.PaymentSalaryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("PAYMENT-SERVICE")
public interface PaymentClient {
    @GetMapping("getPaymentSalaryByInstructorId")
    PaymentSalaryDto getPaymentSalaryByInstructorId(@RequestParam("instructorId")Long instructorId);
    @GetMapping("getPaymentSalaryByPaymentId")
    PaymentSalaryDto getPaymentSalaryByPaymentId(@RequestParam("paymentId")Long paymentId);
    @PostMapping("/savePaymentSalary")
    String savePaymentSalary(@RequestBody PaymentSalaryDto paymentSalaryDto);
    @PutMapping("/updatePaymentSalary")
    String updatePaymentSalary(@RequestBody PaymentSalaryDto paymentSalaryDto);
    @DeleteMapping("/deletePaymentSalary")
    String deletePaymentSalary(@RequestParam("instructorId") Long instructorId);
}
