package com.clients.notification;

import com.clients.notification.dto.NotificationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification-service")
public interface NotificationClient {

    @PostMapping("/notifications")
    public void sendNotification(@RequestBody NotificationDto request);

}
