package com.user.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClaimsByUserResponse {
    private Long claimId;

    private Long userId;
    private LocalDate claimDate;
    private Double claimAmount;
    private String claimType; // e.g., auto, home, life
    private String claimStatus; // submitted, approved, denied
    private LocalDateTime lastUpdated;
    public ClaimsByUserResponse() {
    }
    public ClaimsByUserResponse(Long claimId, Long userId, LocalDate claimDate, Double claimAmount, String claimType, String claimStatus, LocalDateTime lastUpdated) {
        this.claimId = claimId;
        this.userId = userId;
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
        this.claimType = claimType;
        this.claimStatus = claimStatus;
        this.lastUpdated = lastUpdated;
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

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    public Double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(Double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
