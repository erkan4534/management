package com.clients.payment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("PAYMENT-SERVICE")
public interface PaymentClient {
    @DeleteMapping("/payment-salary")
    String deletePaymentSalary(@RequestParam("instructorId") Long instructorId);
}
