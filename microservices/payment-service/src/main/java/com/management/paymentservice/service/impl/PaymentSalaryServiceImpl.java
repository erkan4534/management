package com.management.paymentservice.service.impl;

import com.clients.instructor.InstructorClient;
import com.clients.instructor.dto.InstructorDto;
import com.clients.payment.dto.PaymentSalaryDto;
import com.management.paymentservice.exception.RecordNotFoundException;
import com.management.paymentservice.model.PaymentSalary;
import com.management.paymentservice.repository.PaymentSalaryRepository;
import com.management.paymentservice.service.PaymentSalaryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentSalaryServiceImpl implements PaymentSalaryService {
    private final ModelMapper modelMapper;
    private final PaymentSalaryRepository paymentSalaryRepository;
    private final InstructorClient instructorClient;

    @Override
    public List<PaymentSalaryDto> getPaymentSalaryByInstructorId(Long instructorId) {
        List<PaymentSalary> paymentSalaries = paymentSalaryRepository.findByInstructorId(instructorId);
        return this.modelMapper.map(paymentSalaries, new TypeToken<List<PaymentSalaryDto>>(){}.getType());
    }

    @Override
    public PaymentSalaryDto getPaymentSalaryByPaymentId(Long paymentId) {
        PaymentSalary paymentSalary  =paymentSalaryRepository.findById(paymentId).orElseThrow(()->
                new RecordNotFoundException("Payment not found with ID :"+paymentId));
        PaymentSalaryDto paymentSalaryDto = this.modelMapper.map(paymentSalary, PaymentSalaryDto.class);
        return paymentSalaryDto;
    }

    @Override
    public String savePaymentSalary(PaymentSalaryDto paymentSalaryDto) {
        PaymentSalary paymentSalary = this.modelMapper.map(paymentSalaryDto, PaymentSalary.class);
        InstructorDto instructorDto = instructorClient.getInstructorById(paymentSalaryDto.getInstructorId());
        paymentSalary.setInstructorId(instructorDto.getId());
        paymentSalary.setCreateDate(LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth()));
        paymentSalaryRepository.save(paymentSalary);
        return "success";
    }

    @Override
    public String updatePaymentSalary(PaymentSalaryDto paymentSalaryDto) {
        PaymentSalary paymentSalary = paymentSalaryRepository.findById(paymentSalaryDto.getId()).orElseThrow(()->
                new RecordNotFoundException("Payment not found with ID :"+paymentSalaryDto.getId()));
        this.modelMapper.map(paymentSalaryDto, paymentSalary);
        InstructorDto instructorDto = instructorClient.getInstructorById(paymentSalaryDto.getInstructorId());
        paymentSalary.setInstructorId(instructorDto.getId());
        paymentSalary.setUpdateDate(LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth()));
        paymentSalaryRepository.save(paymentSalary);
        return "success";
    }

    @Override
    @Transactional
    public String deletePaymentSalary(Long instructorId) {
        instructorClient.getInstructorById(instructorId);
        paymentSalaryRepository.deleteByInstructorId(instructorId);
        return "success";
    }
}
