package com.audit.config;

import com.audit.service.AuditLogService;
import com.audit.serviceImpl.AuditLogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
@RequiredArgsConstructor
public class AuditLogKafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(AuditLogKafkaConsumer.class);

    @Autowired
    private  AuditLogService auditLogService;

    @KafkaListener(topics = "claim-updates", groupId = "audit-service")
    public void listenClaimUpdates(String message) {
        log.info("Audit: claim update received: {}", message);
        auditLogService.saveLog(101L, "CLAIM", "update", message);
    }

    @KafkaListener(topics = "payment-updates", groupId = "audit-service")
    public void listenPaymentUpdates(String message) {
        log.info("Audit: payment update received: {}", message);
        auditLogService.saveLog(101L, "PAYMENT", "update", message);
    }

    @KafkaListener(topics = "notification-updates", groupId = "audit-service")
    public void listenNotificationUpdates(String message) {
        log.info("Audit: notification event received: {}", message);
        auditLogService.saveLog(101L, "NOTIFICATION", "sent", message);
    }
}
