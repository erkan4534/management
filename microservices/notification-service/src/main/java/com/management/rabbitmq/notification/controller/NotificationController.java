package com.management.rabbitmq.notification.controller;

import com.clients.notification.dto.NotificationDto;
import com.management.rabbitmq.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService service;

    @PostMapping("/notifications")
    public void sendNotification(@RequestBody NotificationDto request){
        service.sendNotification(request);
    }

}
