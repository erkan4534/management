package com.management.paymentservice.initializer;

import com.management.common.model.Instructor;
import com.management.paymentservice.model.Payment;
import com.management.paymentservice.repository.InstructorRepository;
import com.management.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInitializer implements ApplicationRunner {

    private final PaymentRepository paymentRepository;
    private final InstructorRepository instructorRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Instructor instructor =instructorRepository.findById(1L).get();
        Payment payment = new Payment("2323",instructor);
        paymentRepository.save(payment);
    }
}
