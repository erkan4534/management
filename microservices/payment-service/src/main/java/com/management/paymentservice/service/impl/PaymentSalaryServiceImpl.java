package com.management.paymentservice.service.impl;

import com.clients.instructor.InstructorClient;
import com.clients.instructor.dto.InstructorDto;
import com.management.paymentservice.exception.RecordNotFoundException;
import com.management.paymentservice.model.PaymentSalary;
import com.management.paymentservice.model.dto.PaymentSalaryDto;
import com.management.paymentservice.repository.PaymentSalaryRepository;
import com.management.paymentservice.service.PaymentSalaryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PaymentSalaryServiceImpl implements PaymentSalaryService {
    private final ModelMapper modelMapper;
    private final PaymentSalaryRepository paymentSalaryRepository;
    private final InstructorClient instructorClient;
    @Override
    public String savePaymentSalary(PaymentSalaryDto paymentSalaryDto) {
        PaymentSalary paymentSalary = this.modelMapper.map(paymentSalaryDto, PaymentSalary.class);
        InstructorDto instructorDto = instructorClient.findInstructorById(paymentSalaryDto.getInstructorId());
        paymentSalary.setInstructorId(instructorDto.getId());
        paymentSalary.setCreateDate(LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth()));
        paymentSalaryRepository.save(paymentSalary);
        return "success";
    }

    @Override
    public String updatePaymentSalary(PaymentSalaryDto paymentSalaryDto) {
        PaymentSalary paymentSalary = this.modelMapper.map(paymentSalaryDto, PaymentSalary.class);
        InstructorDto instructorDto = instructorClient.findInstructorById(paymentSalaryDto.getInstructorId());
        paymentSalary.setInstructorId(instructorDto.getId());
        paymentSalary.setUpdateDate(LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth()));
        paymentSalaryRepository.save(paymentSalary);
        return "success";
    }

    @Override
    @Transactional
    public String deletePaymentSalary(Long instructorId) {
        instructorClient.findInstructorById(instructorId);
        paymentSalaryRepository.deleteByInstructor_Id(instructorId);
        return "success";
    }
}
