package com.example.experiments.statedesignpattern;

import org.springframework.http.HttpStatus;

public class PaymentDetails_Context {

    private PaymentEvent paymentEvent;
    private String state;

    public PaymentEvent getPaymentEvent() {
        return this.paymentEvent;
    }

    public void setPaymentEvent(PaymentEvent paymentEvent) {
        setPaymentEvent(paymentEvent, "Some message");
    }

    public String getState() {
        return this.state;
    }

    public void setState(String status) {
        this.state = status;
    }

    public void setPaymentEvent(PaymentEvent paymentEvent, String eventMessage) {
        commonValidation(paymentEvent);
        this.paymentEvent = paymentEvent;
        setState(paymentEvent.nextState());
        paymentEvent.process(this, paymentEvent, eventMessage);
    }

    private void commonValidation(PaymentEvent paymentEvent) {
        if (!paymentEvent.fromStates().contains(PaymentStates.valueOf(this.getState()))) {
            throw new RuntimeException("Not a valid state transition");
        }
    }

}
