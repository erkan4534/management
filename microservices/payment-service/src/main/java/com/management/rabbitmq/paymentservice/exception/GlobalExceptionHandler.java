package com.management.rabbitmq.paymentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({RecordNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ExceptionMessageResponse> recordNotFoundException(RecordNotFoundException exc){
        ExceptionMessageResponse response = prepareErrorResponse(HttpStatus.NOT_FOUND,exc.getMessage());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    private ExceptionMessageResponse prepareErrorResponse(HttpStatus httpStatus, String message) {
        ExceptionMessageResponse response = new ExceptionMessageResponse();
        response.setStatus(httpStatus.value());
        response.setMessage(message);
        response.setTimestamp(System.currentTimeMillis());
        return response;
    }
}
