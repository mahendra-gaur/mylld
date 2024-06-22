package com.example.vending_machine.vendingmachine;

import com.example.vending_machine.enums.Coin;
import com.example.vending_machine.enums.States;
import com.example.vending_machine.inventory.Inventory;
import com.example.vending_machine.products.Product;
import com.example.vending_machine.shelf.ProductShelf;
import com.example.vending_machine.statemachine.Operations;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendingMachine {
    private States vendingMachineState;
    private Operations operations;
    private Inventory inventory;
    private List<Coin> coinList;
    private ProductShelf userSelectedProductShelf;
    private int amountToRefund;

    public VendingMachine(){
        this.vendingMachineState = States.IDLE;
        this.operations = null;
        this.inventory = Inventory.getInstance();
        this.coinList = new ArrayList<>();
        this.userSelectedProductShelf = null;
        this.amountToRefund = 0;
    }

    public void setOperations(Operations currentOperation) {
        this.setOperations(currentOperation, "Test Message");
    }

    private void setOperations(Operations currentOperation, String operationMessage) {
        currentOperation.process(this, operationMessage);
        this.operations = currentOperation;
        this.setVendingMachineState(currentOperation.nextState());
    }

    public int getTotalAmountPaidByUser() {
        return this.coinList.stream().mapToInt(coin->coin.value).sum();
    }

}
