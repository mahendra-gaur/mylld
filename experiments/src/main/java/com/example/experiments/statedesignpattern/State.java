package com.example.experiments.statedesignpattern;

public enum State {
    SUCCESS("success"),
    IN_PROGRESS("in-progress"),
    FAILED("failed"),
    AWAITING("awaiting");

    private final String paymentStatus;
    State(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}