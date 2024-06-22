package com.example.vending_machine.handler;

import com.example.vending_machine.products.Product;
import com.example.vending_machine.vendingmachine.VendingMachine;

public class ProductDispenseHandler {

    public void dispenseProduct(VendingMachine machine) {
        System.out.println("Dispensed the product to the items trey for the user - "+machine.getUserSelectedProductShelf().getProduct());
        machine.getInventory().updateSoldOutProduct(machine.getUserSelectedProductShelf().getCode());
    }

}
