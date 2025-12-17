package com.report.service;

import com.report.DTO.ClaimReport;
import com.report.DTO.PaymentReport;
import com.report.DTO.UserReport;

public interface ReportService {
        ClaimReport getClaimReport();
        PaymentReport getPaymentReport();
        UserReport getUserReport(Long userId);
}
