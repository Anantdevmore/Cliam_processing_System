package com.payment.serviceImpl;

import com.payment.DTO.PaymentDTO;
import com.payment.Entity.Payment;
import com.payment.Enum.PaymentStatus;
import com.payment.Exception.CustomException.PaymentIdNotFound;
import com.payment.kafkaProducer.PaymentEventProducer;
import com.payment.repository.PaymentRepository;
import com.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentEventProducer kafkaProducer;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentEventProducer kafkaProducer) {
        this.paymentRepository = paymentRepository;
        this.kafkaProducer = kafkaProducer;
    }
    @Override
    public Payment processPayment(PaymentDTO dto) {
        Payment payment = new Payment();
        payment.setClaimId(dto.getClaimId());
        payment.setUserId(dto.getUserId());
        payment.setAmount(dto.getAmount());
        payment.setStatus(PaymentStatus.INITIATED);
        payment.setInitiatedAt(LocalDateTime.now());

        Payment saved = paymentRepository.save(payment);
        kafkaProducer.publishPaymentEvent(saved.getPaymentId(), "initiated");

        return saved;
    }

    @Override
    public Payment completePayment(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new PaymentIdNotFound("Payment ID not found"));
        payment.setStatus(PaymentStatus.COMPLETED);
        payment.setCompletedAt(LocalDateTime.now());
        Payment updated = paymentRepository.save(payment);

        kafkaProducer.publishPaymentEvent(paymentId, "completed");
        return updated;
    }

    @Override
    public Payment failPayment(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new PaymentIdNotFound("Payment ID not found"));
        payment.setStatus(PaymentStatus.FAILED);
        payment.setCompletedAt(LocalDateTime.now());
        Payment updated = paymentRepository.save(payment);

        kafkaProducer.publishPaymentEvent(paymentId, "failed");
        return updated;
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentIdNotFound("Payment ID not found"));
    }

    @Override
    public List<Payment> getPaymentsByUser(Long userId) {
        return paymentRepository.findByUserId(userId);
    }
}
