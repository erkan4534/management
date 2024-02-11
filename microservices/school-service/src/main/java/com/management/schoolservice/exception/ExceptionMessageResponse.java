package com.management.schoolservice.exception;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ExceptionMessageResponse {
    private int status;
    private String message;
    private long timestamp;
}
