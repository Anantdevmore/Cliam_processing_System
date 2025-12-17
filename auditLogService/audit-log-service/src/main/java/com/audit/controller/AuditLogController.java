package com.audit.controller;

import com.audit.DTO.AuditLogRequestDto;
import com.audit.Entity.AuditLog;
import com.audit.service.AuditLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditLogController {


    private final AuditLogService auditLogService;

    @Autowired
    public AuditLogController(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @GetMapping("/")
    public String redirectToSwagger() {
        return "redirect:/swagger-ui/index.html";
    }


    @PostMapping("/log")
    public ResponseEntity<AuditLog> createAuditLog(@RequestBody AuditLogRequestDto dto) {
        AuditLog log = auditLogService.saveLog(
                dto.getUserId(),
                dto.getServiceName(),
                dto.getAction(),
                dto.getMessage()
        );
        return new ResponseEntity<>(log, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AuditLog>> getLogsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(auditLogService.getLogsByUser(userId));
    }

    @GetMapping("/service/{serviceName}")
    public ResponseEntity<List<AuditLog>> getLogsByService(@PathVariable String serviceName) {
        return ResponseEntity.ok(auditLogService.getLogsByService(serviceName));
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<AuditLog>> getLogsByDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {

        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);
        return ResponseEntity.ok(auditLogService.getLogsByDateRange(start, end));
    }
}
