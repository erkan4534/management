package com.management.paymentservice.service.impl;

import com.management.paymentservice.model.PaymentSalary;
import com.management.paymentservice.model.PaymentSalaryHistory;
import com.management.paymentservice.repository.PaymentSalaryHistoryRepository;
import com.management.paymentservice.service.PaymentSalaryHistoryService;
import jakarta.persistence.PreRemove;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor(force = true)
public class PaymentSalaryHistoryServiceImpl implements PaymentSalaryHistoryService {
    private final ApplicationContext applicationContext;
    public PaymentSalaryHistoryServiceImpl(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    @PreRemove
    public void beforeAnyOperation(Object object) {
        ModelMapper modelMapper = (ModelMapper) applicationContext.getBean("modelMapper");
        PaymentSalaryHistoryRepository repository = (PaymentSalaryHistoryRepository) applicationContext.getBean("paymentSalaryHistoryRepository");
        PaymentSalaryHistory paymentSalaryHistory = modelMapper.map(object, PaymentSalaryHistory.class);
        paymentSalaryHistory.setInstructorId(((PaymentSalary) object).getInstructorId());
        repository.save(paymentSalaryHistory);
    }
}
