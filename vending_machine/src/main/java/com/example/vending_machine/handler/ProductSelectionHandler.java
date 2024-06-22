package com.example.vending_machine.handler;

import com.example.vending_machine.exception.InvalidProductCodeException;
import com.example.vending_machine.exception.ProductSoldOutException;
import com.example.vending_machine.shelf.ProductShelf;
import com.example.vending_machine.statemachine.Operations;
import com.example.vending_machine.inventory.Inventory;
import com.example.vending_machine.products.Product;
import com.example.vending_machine.vendingmachine.VendingMachine;
import java.util.Scanner;

public class ProductSelectionHandler {
    private Inventory inventory;
    public ProductSelectionHandler() {
        this.inventory = Inventory.getInstance();
    }

    public void selectProduct(VendingMachine machine) {
        ProductShelf productShelf = null;
        try {
            productShelf = this.getProduct(machine);
        } catch (ProductSoldOutException e) {
            System.out.println("Product sold out. Initiating refund");
            machine.setOperations(Operations.REFUND_FULL_MONEY);
        } catch (InvalidProductCodeException e) {
            System.out.println("Invalid product code. Initiating refund");
            machine.setOperations(Operations.REFUND_FULL_MONEY);
        }
        int productPrice = productShelf.getProduct().getPrice();
        int amountPaidByUser = machine.getTotalAmountPaidByUser();

        if(amountPaidByUser>productPrice) {
            int amountToRefund = amountPaidByUser - productPrice;
            machine.setAmountToRefund(amountToRefund);
            machine.setOperations(Operations.RETURN_CHANGE);
        } else if (amountPaidByUser<productPrice) {
            machine.setOperations(Operations.REFUND_FULL_MONEY);
        } else {
            machine.setUserSelectedProductShelf(productShelf);
        }



    }

    private ProductShelf getProduct(VendingMachine machine) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product code");
        int productCode = Integer.parseInt(scanner.nextLine());
        return machine.getInventory().getProduct(productCode);
    }

}
