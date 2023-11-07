package com.management.paymentservice.controller;

import com.management.paymentservice.model.dto.PaymentSalaryDto;
import com.management.paymentservice.service.PaymentSalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentSalaryService paymentSalaryService;
    @PostMapping("/payment-salary")
    public String savePaymentSalary(@RequestBody PaymentSalaryDto paymentSalaryDto){
       return paymentSalaryService.savePaymentSalary(paymentSalaryDto);
    }

    @PostMapping("/payment-salary")
    public String updatePaymentSalary(@RequestBody PaymentSalaryDto paymentSalaryDto){
        return paymentSalaryService.updatePaymentSalary(paymentSalaryDto);
    }

    @DeleteMapping("/payment-salary/instructorId")
    public String deletePaymentSalary(@RequestParam Long instructorId){
        return paymentSalaryService.deletePaymentSalary(instructorId);
    }



}
