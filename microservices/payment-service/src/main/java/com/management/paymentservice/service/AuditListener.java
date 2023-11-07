package com.management.paymentservice.service;

import jakarta.persistence.PreRemove;

public class AuditListener {


    @PreRemove
    private void beforeAnyOperation(Object object) {

        System.out.println(object);
    }
}
