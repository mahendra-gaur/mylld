package com.example.vending_machine.statemachine;

import com.example.vending_machine.enums.States;
import com.example.vending_machine.vendingmachine.VendingMachine;
import java.util.List;

public interface OperationProcessor {

    States nextState();

    void process(VendingMachine machine, String eventMessage);

    List<States> fromStates();
}