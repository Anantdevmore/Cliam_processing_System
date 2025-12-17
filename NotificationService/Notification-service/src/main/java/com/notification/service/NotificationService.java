package com.notification.service;

import com.notification.Entity.Notification;

import java.util.List;

public interface NotificationService {
    Notification saveNotification(Long userId, String message, String type);
    List<Notification> getUserNotifications(Long userId);
}
