package com.report.config;

import com.report.Entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "payment-service", url = "http://localhost:8082/api/payments")
public interface PaymentClient {

    @GetMapping("/all")
    List<Payment> getAllPayments();

    @GetMapping("/user/{userId}")
    List<Payment> getPaymentsByUser(@PathVariable("userId") Long userId);
}
