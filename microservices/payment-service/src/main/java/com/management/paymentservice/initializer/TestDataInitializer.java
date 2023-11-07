package com.management.paymentservice.initializer;

import com.management.common.model.Instructor;
import com.management.paymentservice.model.PaymentSalary;
import com.management.paymentservice.repository.InstructorRepository;
import com.management.paymentservice.repository.PaymentSalaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInitializer implements ApplicationRunner {

    private final PaymentSalaryRepository paymentSalaryRepository;
    private final InstructorRepository instructorRepository;
    @Override
    public void run(ApplicationArguments args)  {
        Instructor instructor =instructorRepository.findById(1L).get();
        PaymentSalary paymentSalary = new PaymentSalary("2323",instructor,80000D);
        paymentSalaryRepository.save(paymentSalary);
    }
}
