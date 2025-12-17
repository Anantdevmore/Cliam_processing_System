package com.report.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

public class PaymentReport {
    private double totalPaid;
    private long failedPayments;
    private long totalPayments;

    public PaymentReport() {
        // Default constructor
    }
    public PaymentReport(double totalPaid, long failedPayments, long totalPayments) {
        this.totalPaid = totalPaid;
        this.failedPayments = failedPayments;
        this.totalPayments = totalPayments;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public long getFailedPayments() {
        return failedPayments;
    }

    public void setFailedPayments(long failedPayments) {
        this.failedPayments = failedPayments;
    }

    public long getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(long totalPayments) {
        this.totalPayments = totalPayments;
    }

    @Override
    public String toString() {
        return "PaymentReport{" +
                "totalPaid=" + totalPaid +
                ", failedPayments=" + failedPayments +
                ", totalPayments=" + totalPayments +
                '}';
    }
}
