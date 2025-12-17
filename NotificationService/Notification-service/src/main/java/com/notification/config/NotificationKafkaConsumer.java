package com.notification.config;

import com.notification.serviceImpl.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationKafkaConsumer {

    private final EmailService emailService;

    public NotificationKafkaConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "claim-updates", groupId = "notification-service")
    public void listenClaimUpdates(String message) {
        log.info("Received claim update: {}", message);

        // Dummy data (In real app, fetch user's email/phone from User Service)
        String userEmail = "anantdevmore1008@gmail.com";
        emailService.sendEmail(userEmail, "Claim Status Update", message);
    }

    @KafkaListener(topics = "payment-updates", groupId = "notification-service")
    public void listenPaymentUpdates(String message) {
        log.info("Received payment update: {}", message);

        String userEmail = "anantdevmore1008@gmail.com";

        emailService.sendEmail(userEmail, "Payment Status Update", message);
    }
}
