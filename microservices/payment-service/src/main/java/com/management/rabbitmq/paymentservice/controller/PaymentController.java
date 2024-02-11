package com.management.rabbitmq.paymentservice.controller;

import com.management.rabbitmq.paymentservice.service.PaymentSalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.clients.payment.dto.PaymentSalaryDto;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentSalaryService paymentSalaryService;

    @GetMapping("getPaymentSalaryByInstructorId")
    public List<PaymentSalaryDto> getPaymentSalaryByInstructorId(@RequestParam("instructorId")Long instructorId) {
       return paymentSalaryService.getPaymentSalaryByInstructorId(instructorId);
    }

    @GetMapping("getPaymentSalaryByPaymentId")
    public PaymentSalaryDto getPaymentSalaryByPaymentId(@RequestParam("paymentId")Long paymentId) {
        return paymentSalaryService.getPaymentSalaryByPaymentId(paymentId);
    }

    @PostMapping("/savePaymentSalary")
    public String savePaymentSalary(@RequestBody PaymentSalaryDto paymentSalaryDto){
       return paymentSalaryService.savePaymentSalary(paymentSalaryDto);
    }

    @PutMapping("/updatePaymentSalary")
    public String updatePaymentSalary(@RequestBody PaymentSalaryDto paymentSalaryDto){
        return paymentSalaryService.updatePaymentSalary(paymentSalaryDto);
    }

    @DeleteMapping("/deletePaymentSalary")
    public String deletePaymentSalary(@RequestParam("instructorId") Long instructorId){
        return paymentSalaryService.deletePaymentSalary(instructorId);
    }
}
