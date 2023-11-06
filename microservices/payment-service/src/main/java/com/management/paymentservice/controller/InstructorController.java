package com.management.paymentservice.controller;

import com.management.paymentservice.model.dto.PaymentDto;
import com.management.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InstructorController {

    private final PaymentService paymentService;
    @PostMapping("/payment")
    public String savePayment(@RequestBody PaymentDto paymentDto){
       return paymentService.savePayment(paymentDto);
    }

    @PostMapping("/payment")
    public String updatePayment(@RequestBody PaymentDto paymentDto){
        return paymentService.updatePayment(paymentDto);
    }
}
