package com.report.Entity;

import lombok.Data;

@Data
public class Payment {
    private Long paymentId;
    private Long claimId;
    private Long userId;
    private Double amount;
    private String status;

    public Payment() {
        // Default constructor
    }
    public Payment(Long paymentId, Long claimId, Long userId, Double amount, String status) {
        this.paymentId = paymentId;
        this.claimId = claimId;
        this.userId = userId;
        this.amount = amount;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", claimId=" + claimId +
                ", userId=" + userId +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
