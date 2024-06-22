package com.example.experiments.statedesignpattern;

import java.util.List;

public interface Event {

    String nextState();

    void process(PaymentDetails_Context payment, PaymentEvent paymentEvent, String eventMessage);

    List<PaymentStates> fromStates();
}
