package com.report.Entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDate;

public class Claim {

    private Long claimId;
    private Long userId;
    private Double claimAmount;
    private String claimStatus;
    private LocalDate claimDate;

    public Claim() {
    }
    public Claim(Long claimId, Long userId, Double claimAmount, String claimStatus, LocalDate claimDate) {
        this.claimId = claimId;
        this.userId = userId;
        this.claimAmount = claimAmount;
        this.claimStatus = claimStatus;
        this.claimDate = claimDate;
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

    public Double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(Double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "claimId=" + claimId +
                ", userId=" + userId +
                ", claimAmount=" + claimAmount +
                ", claimStatus='" + claimStatus + '\'' +
                ", claimDate=" + claimDate +
                '}';
    }
}
