package com.example.vending_machine.enums;

public enum States {
    IDLE("idle"),
    ACCEPTING_COIN("accepting_coin"),
    PRODUCT_SELECTION("product_selection"),
    DISPENSING("dispensing");

    private final String VMState;
    States(String VMState) {
        this.VMState = VMState;
    }
}