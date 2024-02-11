package com.management.rabbitmq.notification.repository;

import com.management.rabbitmq.notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationEntityRepository extends JpaRepository<Notification, Integer> {
}
