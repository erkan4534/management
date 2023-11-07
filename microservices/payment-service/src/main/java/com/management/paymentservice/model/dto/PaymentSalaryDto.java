package com.management.paymentservice.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentSalaryDto {
    private Long id;
    private String iban;
    private Long instructorId;
    private Double salary;
}
