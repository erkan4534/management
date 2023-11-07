package com.management.paymentservice.service.impl;

import com.management.common.model.Instructor;
import com.management.paymentservice.exception.RecordNotFoundException;
import com.management.paymentservice.model.PaymentSalary;
import com.management.paymentservice.model.dto.PaymentSalaryDto;
import com.management.paymentservice.repository.InstructorRepository;
import com.management.paymentservice.repository.PaymentRepository;
import com.management.paymentservice.service.PaymentSalaryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentSalaryServiceImpl implements PaymentSalaryService {
    private final ModelMapper modelMapper;
    private PaymentRepository paymentRepository;
    private InstructorRepository instructorRepository;
    @Override
    public String savePaymentSalary(PaymentSalaryDto paymentSalaryDto) {
        PaymentSalary paymentSalary = this.modelMapper.map(paymentSalaryDto, PaymentSalary.class);
        Instructor instructor =instructorRepository.findById(paymentSalaryDto.getInstructorId()).orElseThrow(()->
                new RecordNotFoundException("Instructor not found with ID :"+ paymentSalaryDto.getInstructorId()));
        paymentSalary.setInstructor(instructor);
        paymentRepository.save(paymentSalary);
        return "success";
    }

    @Override
    public String updatePaymentSalary(PaymentSalaryDto paymentSalaryDto) {
        PaymentSalary paymentSalary = this.modelMapper.map(paymentSalaryDto, PaymentSalary.class);
        Instructor instructor =instructorRepository.findById(paymentSalaryDto.getInstructorId()).orElseThrow(()->
                new RecordNotFoundException("Instructor not found with ID :"+ paymentSalaryDto.getInstructorId()));
        paymentSalary.setInstructor(instructor);
        paymentRepository.save(paymentSalary);
        return "success";
    }
}
