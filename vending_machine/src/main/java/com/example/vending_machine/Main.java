package com.example.vending_machine;

import com.example.vending_machine.statemachine.Operations;
import com.example.vending_machine.vendingmachine.VendingMachine;

public class Main {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        System.out.println(vendingMachine.getInventory());
        vendingMachine.setOperations(Operations.INSERT_COIN);
        vendingMachine.setOperations(Operations.CLICKED_ON_PRODUCT_SELECTION_BUTTON);
        vendingMachine.setOperations(Operations.SELECT_PRODUCT);
        vendingMachine.setOperations(Operations.DISPENSE_PRODUCT);
        System.out.println();
    }

}
