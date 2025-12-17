package com.payment.Exception.CustomException;

public class PaymentIdNotFound extends RuntimeException {
    public PaymentIdNotFound(String message) {
        super(message);
    }
}
