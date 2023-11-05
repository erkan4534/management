package com.management.validationservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class ValidationServicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ValidationServicesApplication.class, args);
    }

}
