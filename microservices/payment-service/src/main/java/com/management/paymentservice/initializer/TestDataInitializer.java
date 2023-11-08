package com.management.paymentservice.initializer;

import com.management.common.model.Instructor;
import com.management.paymentservice.model.PaymentSalary;
import com.management.paymentservice.repository.InstructorRepository;
import com.management.paymentservice.repository.PaymentSalaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class TestDataInitializer implements ApplicationRunner {

    private final PaymentSalaryRepository paymentSalaryRepository;
    private final InstructorRepository instructorRepository;
    @Override
    public void run(ApplicationArguments args)  {

        //if(paymentSalaryRepository.findAll().size()>0){
          // return;
        //}

        Instructor instructor =instructorRepository.findById(1L).get();
        PaymentSalary paymentSalary = new PaymentSalary("2323",instructor,80000D);
        paymentSalary.setCreateDate(LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth()));
        paymentSalaryRepository.save(paymentSalary);
    }
}
