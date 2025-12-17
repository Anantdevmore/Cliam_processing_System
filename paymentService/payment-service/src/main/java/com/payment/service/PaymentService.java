package com.payment.service;

import com.payment.DTO.PaymentDTO;
import com.payment.Entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment processPayment(PaymentDTO dto);
    Payment completePayment(Long paymentId);
    Payment failPayment(Long paymentId);
    Payment getPaymentById(Long id);
    List<Payment> getPaymentsByUser(Long userId);
}
