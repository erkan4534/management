package com.management.paymentservice.model.dto;

import com.management.common.model.Instructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
@Getter
@Setter
public class PaymentSalaryHistoryDto {
    private Long id;
    private String iban;
    private Instructor instructor;
    private Double salary;
    private LocalDate updateDate;
    private LocalDate createDate;
}
