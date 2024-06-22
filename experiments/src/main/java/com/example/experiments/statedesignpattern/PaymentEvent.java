package com.example.experiments.statedesignpattern;

import java.util.List;
import lombok.Getter;

public  enum PaymentEvent implements Event {


    PAYMENT_INITIATION_FAILED("Failed to initiate payment due to some technical error at our end") {
        @Override
        public String nextState() {
            return PaymentStates.INIT_FAILED.name();
        }

        @Override
        public List<PaymentStates> fromStates() {
            return List.of(PaymentStates.INITIATED,
                    PaymentStates.INITIATED_WITH_SUBSCRIPTION);
        }
    },

    DEBIT_FAILED("User account debit failed") {
        @Override
        public String nextState() {
            return PaymentStates.PAYMENT_NOT_RECEIVED.name();
        }

        @Override
        public List<PaymentStates> fromStates() {
            return List.of(PaymentStates.INITIATED,
                    PaymentStates.INITIATED_WITH_SUBSCRIPTION, PaymentStates.PAYMENT_IN_PROGRESS,
                    PaymentStates.TRANSACTION_TIMEOUT);
        }
        @Override
        public void process(PaymentDetails_Context payments, PaymentEvent paymentEvent,
                String eventMessage) {
            super.process(payments, paymentEvent, eventMessage);
            //deleting existing tasks from schedule as transaction debit terminal status is reached
        }
    };

    @Getter
    private final String message;
    PaymentEvent(String message) {
        this.message = message;
    }

    public void process(PaymentDetails_Context payments, PaymentEvent paymentEvent,
            String eventMessage) {
    }
}