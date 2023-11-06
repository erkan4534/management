package com.school.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EntityScan("com.management.common.model")
@EnableDiscoveryClient
public class SchoolManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(SchoolManagementApplication.class, args);
    }
}
