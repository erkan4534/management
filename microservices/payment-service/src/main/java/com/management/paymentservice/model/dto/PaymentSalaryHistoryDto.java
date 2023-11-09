package com.management.paymentservice.model.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
@Getter
@Setter
public class PaymentSalaryHistoryDto {
    private Long id;
    private String iban;
    private Long instructorId;
    private Double salary;
    private LocalDate updateDate;
    private LocalDate createDate;
}
