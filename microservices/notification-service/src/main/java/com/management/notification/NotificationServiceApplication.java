package com.management.notification;

import com.management.rabbitmq.RabbitMQMessageProducer;
import com.management.notification.configuration.NotificationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.clients.notification")
@EnableDiscoveryClient
@SpringBootApplication
public class NotificationServiceApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @Autowired
    RabbitMQMessageProducer producer;

    @Autowired
    NotificationConfig config;

    @Override
    public void run(String... args) throws Exception {

    }
}
