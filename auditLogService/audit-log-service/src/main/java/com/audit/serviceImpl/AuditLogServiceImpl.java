package com.audit.serviceImpl;

import com.audit.Entity.AuditLog;
import com.audit.repository.AuditLogRepository;
import com.audit.service.AuditLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogRepository repository;

    @Autowired
    public AuditLogServiceImpl(AuditLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public AuditLog saveLog(Long userId, String serviceName, String action, String message) {
        AuditLog log = new AuditLog();
        log.setUserId(userId);
        log.setServiceName(serviceName);
        log.setAction(action);
        log.setMessage(message);
        log.setTimestamp(LocalDateTime.now());
        return repository.save(log);
    }

    @Override
    public List<AuditLog> getLogsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<AuditLog> getLogsByService(String serviceName) {
        return repository.findByServiceName(serviceName);
    }

    @Override
    public List<AuditLog> getLogsByDateRange(LocalDateTime start, LocalDateTime end) {
        return repository.findLogsBetweenDates(start, end);
    }
}
