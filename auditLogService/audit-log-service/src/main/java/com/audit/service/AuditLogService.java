package com.audit.service;

import com.audit.Entity.AuditLog;

import java.time.LocalDateTime;
import java.util.List;

public interface AuditLogService {
    AuditLog saveLog(Long userId, String serviceName, String action, String message);
    List<AuditLog> getLogsByUser(Long userId);
    List<AuditLog> getLogsByService(String serviceName);
    List<AuditLog> getLogsByDateRange(LocalDateTime start, LocalDateTime end);
}
