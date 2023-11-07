package com.management.paymentservice.service.impl;

import com.management.common.model.Instructor;
import com.management.paymentservice.exception.RecordNotFoundException;
import com.management.paymentservice.model.PaymentSalary;
import com.management.paymentservice.model.dto.PaymentSalaryDto;
import com.management.paymentservice.repository.InstructorRepository;
import com.management.paymentservice.repository.PaymentSalaryRepository;
import com.management.paymentservice.service.PaymentSalaryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PaymentSalaryServiceImpl implements PaymentSalaryService {
    private final ModelMapper modelMapper;
    private PaymentSalaryRepository paymentSalaryRepository;
    private InstructorRepository instructorRepository;
    @Override
    public String savePaymentSalary(PaymentSalaryDto paymentSalaryDto) {
        PaymentSalary paymentSalary = this.modelMapper.map(paymentSalaryDto, PaymentSalary.class);
        Instructor instructor =instructorRepository.findById(paymentSalaryDto.getInstructorId()).orElseThrow(()->
                new RecordNotFoundException("Instructor not found with ID :"+ paymentSalaryDto.getInstructorId()));
        paymentSalary.setInstructor(instructor);
        //paymentSalary.setCreateDate(LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth()));
        paymentSalaryRepository.save(paymentSalary);
        return "success";
    }

    @Override
    public String updatePaymentSalary(PaymentSalaryDto paymentSalaryDto) {
        PaymentSalary paymentSalary = this.modelMapper.map(paymentSalaryDto, PaymentSalary.class);
        Instructor instructor =instructorRepository.findById(paymentSalaryDto.getInstructorId()).orElseThrow(()->
                new RecordNotFoundException("Instructor not found with ID :"+ paymentSalaryDto.getInstructorId()));
        paymentSalary.setInstructor(instructor);
        //paymentSalary.setUpdateDate(LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth()));
        paymentSalaryRepository.save(paymentSalary);
        return "success";
    }

    @Override
    public String deletePaymentSalary(Long instructorId) {
        instructorRepository.findById(instructorId).orElseThrow(()->
                new RecordNotFoundException("Instructor not found with ID :"+ instructorId));
        paymentSalaryRepository.deleteByInstructor_Id(instructorId);




        return "success";
    }
}
