package com.management.rabbitmq.paymentservice.exception;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(String message) {
        super(message);
    }
}
