package com.management.notification.service;

import com.clients.notification.dto.NotificationDto;
import com.management.notification.model.Notification;
import com.management.notification.repository.NotificationEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final NotificationEntityRepository repository;

    public void sendNotification(NotificationDto request) {
        repository.save(
                Notification.builder()
                        .toCustomerId(request.getToCustomerId())
                        .toCustomerPhone(request.getToCustomerPhone())
                        .message(request.getMessage())
                        .sender("school management")
                        .sentAt(LocalDateTime.now())
                        .build()
        );
        log.info("Notification sent :   {}" , request.getMessage());
    }
}
