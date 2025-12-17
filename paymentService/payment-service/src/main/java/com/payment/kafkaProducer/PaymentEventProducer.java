package com.payment.kafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentEventProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;


    private static final String TOPIC = "payment-updates";

    @Autowired
    public PaymentEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishPaymentEvent(Long paymentId, String status) {
        String message = "PaymentID: " + paymentId + ", Status: " + status;
        kafkaTemplate.send(TOPIC, message);
    }
}
