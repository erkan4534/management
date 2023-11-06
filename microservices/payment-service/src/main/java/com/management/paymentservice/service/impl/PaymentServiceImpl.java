package com.management.paymentservice.service.impl;

import com.management.common.model.Instructor;
import com.management.common.model.dto.CourseDto;
import com.management.paymentservice.exception.RecordNotFoundException;
import com.management.paymentservice.model.Payment;
import com.management.paymentservice.model.dto.PaymentDto;
import com.management.paymentservice.repository.InstructorRepository;
import com.management.paymentservice.repository.PaymentRepository;
import com.management.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final ModelMapper modelMapper;
    private PaymentRepository paymentRepository;
    private InstructorRepository instructorRepository;
    @Override
    public String savePayment(PaymentDto paymentDto) {
        Payment payment = this.modelMapper.map(paymentDto, Payment.class);
        Instructor instructor =instructorRepository.findById(paymentDto.getInstructorId()).orElseThrow(()->
                new RecordNotFoundException("Instructor not found with ID :"+paymentDto.getInstructorId()));
        payment.setInstructor(instructor);
        paymentRepository.save(payment);
        return "success";
    }

    @Override
    public String updatePayment(PaymentDto paymentDto) {
        Payment payment = this.modelMapper.map(paymentDto, Payment.class);
        Instructor instructor =instructorRepository.findById(paymentDto.getInstructorId()).orElseThrow(()->
                new RecordNotFoundException("Instructor not found with ID :"+paymentDto.getInstructorId()));
        payment.setInstructor(instructor);
        paymentRepository.save(payment);
        return "success";
    }
}
