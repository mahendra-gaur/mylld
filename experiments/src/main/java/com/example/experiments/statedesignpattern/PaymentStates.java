package com.example.experiments.statedesignpattern;

import static com.example.experiments.statedesignpattern.State.AWAITING;
import static com.example.experiments.statedesignpattern.State.FAILED;
import static com.example.experiments.statedesignpattern.State.IN_PROGRESS;
import static com.example.experiments.statedesignpattern.State.SUCCESS;

import java.util.Arrays;
import java.util.List;

public enum PaymentStates {
    INITIATED(SUCCESS, AWAITING, AWAITING),
    INITIATED_WITH_SUBSCRIPTION(SUCCESS, AWAITING, AWAITING),
    INIT_FAILED(FAILED),
    PAYMENT_NOT_RECEIVED(SUCCESS, FAILED),
    PAYMENT_IN_PROGRESS(SUCCESS, IN_PROGRESS, AWAITING),
    TRANSACTION_TIMEOUT(SUCCESS, FAILED, FAILED);

    private final List<State> statusList;

    PaymentStates(State... transactionStatus) {
        statusList = Arrays.asList(transactionStatus);
    }
}
