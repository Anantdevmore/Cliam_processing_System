package com.payment.Entity;

import com.payment.Enum.PaymentStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private Long claimId;
    private Long userId;
    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status; // INITIATED, COMPLETED, FAILED

    private LocalDateTime initiatedAt;
    private LocalDateTime completedAt;

    public Payment() {
    }

    public Payment(Long paymentId, Long claimId, Long userId, Double amount, PaymentStatus status, LocalDateTime initiatedAt, LocalDateTime completedAt) {
        this.paymentId = paymentId;
        this.claimId = claimId;
        this.userId = userId;
        this.amount = amount;
        this.status = status;
        this.initiatedAt = initiatedAt;
        this.completedAt = completedAt;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public LocalDateTime getInitiatedAt() {
        return initiatedAt;
    }

    public void setInitiatedAt(LocalDateTime initiatedAt) {
        this.initiatedAt = initiatedAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", claimId=" + claimId +
                ", userId=" + userId +
                ", amount=" + amount +
                ", status=" + status +
                ", initiatedAt=" + initiatedAt +
                ", completedAt=" + completedAt +
                '}';
    }
}
