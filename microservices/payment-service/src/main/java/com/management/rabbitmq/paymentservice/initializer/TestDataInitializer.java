package com.management.rabbitmq.paymentservice.initializer;

import com.clients.instructor.InstructorClient;
import com.clients.instructor.dto.InstructorDto;
import com.management.rabbitmq.paymentservice.model.PaymentSalary;
import com.management.rabbitmq.paymentservice.repository.PaymentSalaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class TestDataInitializer implements ApplicationRunner {

    private final PaymentSalaryRepository paymentSalaryRepository;
    private final InstructorClient instructorClient;
    @Override
    public void run(ApplicationArguments args)  {

        if(paymentSalaryRepository.findAll().size()>0){
           return;
        }

        InstructorDto instructor= instructorClient.getInstructorById(1L);
        PaymentSalary paymentSalary = new PaymentSalary("2323",instructor.getId(),80000D);
        paymentSalary.setCreateDate(LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth()));
        paymentSalaryRepository.save(paymentSalary);
    }
}
