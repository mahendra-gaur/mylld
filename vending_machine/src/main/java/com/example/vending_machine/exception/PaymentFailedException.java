package com.example.vending_machine.exception;

public class PaymentFailedException extends RuntimeException{
    public PaymentFailedException(String msg) {
        super(msg);
    }
}
