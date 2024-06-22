package com.example.vending_machine.handler;

import com.example.vending_machine.vendingmachine.VendingMachine;

public interface PaymentHandler {

    void makePayment(VendingMachine machine);

    boolean refundPayment(int refundAmount);

}
