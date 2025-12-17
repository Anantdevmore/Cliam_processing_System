package com.report.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;


public class ClaimReport {

    private long submitted;
    private long approved;
    private long rejected;
    private long totalClaims;

    public ClaimReport() {
        // Default constructor
    }
    public ClaimReport(long submitted, long approved, long rejected, long totalClaims) {
        this.submitted = submitted;
        this.approved = approved;
        this.rejected = rejected;
        this.totalClaims = totalClaims;
    }

    public long getSubmitted() {
        return submitted;
    }

    public void setSubmitted(long submitted) {
        this.submitted = submitted;
    }

    public long getApproved() {
        return approved;
    }

    public void setApproved(long approved) {
        this.approved = approved;
    }

    public long getRejected() {
        return rejected;
    }

    public void setRejected(long rejected) {
        this.rejected = rejected;
    }

    public long getTotalClaims() {
        return totalClaims;
    }

    public void setTotalClaims(long totalClaims) {
        this.totalClaims = totalClaims;
    }

    @Override
    public String toString() {
        return "ClaimReport{" +
                "submitted=" + submitted +
                ", approved=" + approved +
                ", rejected=" + rejected +
                ", totalClaims=" + totalClaims +
                '}';
    }
}
