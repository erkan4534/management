package com.management.validationservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ValidationServicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ValidationServicesApplication.class, args);
    }

}
