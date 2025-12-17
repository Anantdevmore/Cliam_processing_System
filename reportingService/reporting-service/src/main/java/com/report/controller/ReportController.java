package com.report.controller;

import com.report.DTO.ClaimReport;
import com.report.DTO.PaymentReport;
import com.report.DTO.UserReport;
import com.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/claims")
    public ResponseEntity<ClaimReport> getClaimReport() {
        return ResponseEntity.ok(reportService.getClaimReport());
    }

    @GetMapping("/payments")
    public ResponseEntity<PaymentReport> getPaymentReport() {
        return ResponseEntity.ok(reportService.getPaymentReport());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserReport> getUserReport(@PathVariable Long userId) {
        return ResponseEntity.ok(reportService.getUserReport(userId));
    }

}
