package com.report.serviceImpl;

import com.report.DTO.ClaimReport;
import com.report.DTO.PaymentReport;
import com.report.DTO.UserReport;
import com.report.Entity.Claim;
import com.report.Entity.Payment;
import com.report.config.ClaimClient;
import com.report.config.PaymentClient;
import com.report.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ClaimClient claimClient;
    private final PaymentClient paymentClient;

    public ReportServiceImpl(ClaimClient claimClient, PaymentClient paymentClient) {
        this.claimClient = claimClient;
        this.paymentClient = paymentClient;
    }


    @Override
    public ClaimReport getClaimReport() {
        List<Claim> claims = claimClient.getAllClaims();
        long submitted = claims.stream().filter(c -> "submitted".equalsIgnoreCase(c.getClaimStatus())).count();
        long approved = claims.stream().filter(c -> "approved".equalsIgnoreCase(c.getClaimStatus())).count();
        long rejected = claims.stream().filter(c -> "rejected".equalsIgnoreCase(c.getClaimStatus())).count();

        return new ClaimReport(submitted, approved, rejected, claims.size());
    }

    @Override
    public PaymentReport getPaymentReport() {
        List<Payment> payments = paymentClient.getAllPayments();
        double totalPaid = payments.stream()
                .filter(p -> "COMPLETED".equalsIgnoreCase(p.getStatus()))
                .mapToDouble(Payment::getAmount)
                .sum();

        long failed = payments.stream()
                .filter(p -> "FAILED".equalsIgnoreCase(p.getStatus()))
                .count();

        return new PaymentReport(totalPaid, failed, payments.size());
    }

    @Override
    public UserReport getUserReport(Long userId) {
        List<Claim> userClaims = claimClient.getClaimsByUser(userId);
        List<Payment> userPayments = paymentClient.getPaymentsByUser(userId);

        return new UserReport(userId, userClaims.size(), userPayments.size());
    }
}
