package com.report.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;


public class UserReport {
    private Long userId;
    private int totalClaims;
    private int totalPayments;

    public UserReport() {
        // Default constructor
    }
    public UserReport(Long userId, int totalClaims, int totalPayments) {
        this.userId = userId;
        this.totalClaims = totalClaims;
        this.totalPayments = totalPayments;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getTotalClaims() {
        return totalClaims;
    }

    public void setTotalClaims(int totalClaims) {
        this.totalClaims = totalClaims;
    }

    public int getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(int totalPayments) {
        this.totalPayments = totalPayments;
    }

    @Override
    public String toString() {
        return "UserReport{" +
                "userId=" + userId +
                ", totalClaims=" + totalClaims +
                ", totalPayments=" + totalPayments +
                '}';
    }
}
