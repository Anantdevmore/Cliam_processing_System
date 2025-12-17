package com.report.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "report_aggregates")
public class ReportAggregate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long totalClaims;
    private long approvedClaims;
    private long rejectedClaims;
    private long submittedClaims;

    private long totalPayments;
    private double totalPaidAmount;
    private long failedPayments;

    private LocalDateTime lastUpdated;

    public ReportAggregate() {
    }
    public ReportAggregate(long totalClaims, long approvedClaims, long rejectedClaims, long submittedClaims,
                           long totalPayments, double totalPaidAmount, long failedPayments, LocalDateTime lastUpdated) {
        this.totalClaims = totalClaims;
        this.approvedClaims = approvedClaims;
        this.rejectedClaims = rejectedClaims;
        this.submittedClaims = submittedClaims;
        this.totalPayments = totalPayments;
        this.totalPaidAmount = totalPaidAmount;
        this.failedPayments = failedPayments;
        this.lastUpdated = lastUpdated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getTotalClaims() {
        return totalClaims;
    }

    public void setTotalClaims(long totalClaims) {
        this.totalClaims = totalClaims;
    }

    public long getApprovedClaims() {
        return approvedClaims;
    }

    public void setApprovedClaims(long approvedClaims) {
        this.approvedClaims = approvedClaims;
    }

    public long getRejectedClaims() {
        return rejectedClaims;
    }

    public void setRejectedClaims(long rejectedClaims) {
        this.rejectedClaims = rejectedClaims;
    }

    public long getSubmittedClaims() {
        return submittedClaims;
    }

    public void setSubmittedClaims(long submittedClaims) {
        this.submittedClaims = submittedClaims;
    }

    public long getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(long totalPayments) {
        this.totalPayments = totalPayments;
    }

    public double getTotalPaidAmount() {
        return totalPaidAmount;
    }

    public void setTotalPaidAmount(double totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
    }

    public long getFailedPayments() {
        return failedPayments;
    }

    public void setFailedPayments(long failedPayments) {
        this.failedPayments = failedPayments;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "ReportAggregate{" +
                "id=" + id +
                ", totalClaims=" + totalClaims +
                ", approvedClaims=" + approvedClaims +
                ", rejectedClaims=" + rejectedClaims +
                ", submittedClaims=" + submittedClaims +
                ", totalPayments=" + totalPayments +
                ", totalPaidAmount=" + totalPaidAmount +
                ", failedPayments=" + failedPayments +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
