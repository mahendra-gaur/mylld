package com.example.vending_machine.statemachine;

import com.example.vending_machine.enums.States;
import com.example.vending_machine.exception.PaymentFailedException;
import com.example.vending_machine.handler.PaymentHandler;
import com.example.vending_machine.handler.CoinPaymentHandler;
import com.example.vending_machine.handler.ProductDispenseHandler;
import com.example.vending_machine.handler.ProductSelectionHandler;
import com.example.vending_machine.vendingmachine.VendingMachine;
import java.util.ArrayList;
import java.util.List;

public enum Operations implements OperationProcessor {

//    CLICKED_ON_INSERT_COIN_BUTTON("OPERATION - CLICKED ON INSERT COIN BUTTON") {           // 1         - Completed
//        @Override
//        public States nextState() {
//            return States.ACCEPTING_COIN;
//        }
//
//        @Override
//        public void process(VendingMachine machine, String eventMessage) {
//            super.process(machine, eventMessage);       // first controller will come here.
//        }
//
//        @Override
//        public List<States> fromStates() {
//            return List.of(States.IDLE);
//        }
//    },

    INSERT_COIN("OPERATION - INSERT COIN") {                       // 2             - Completed
        @Override
        public States nextState() {
            return States.ACCEPTING_COIN;
        }

        @Override
        public void process(VendingMachine machine, String eventMessage) {
            super.process(machine, eventMessage);       // first controller will come here.
            try{
                this.paymentHandler.makePayment(machine);
            }catch (PaymentFailedException e) {
                machine.setOperations(CANCLE_REQUEST);
            }
        }

        @Override
        public List<States> fromStates() {
            return List.of(States.IDLE);
        }
    },

    CANCLE_REQUEST("OPERATION - CANCLE REQUEST") {                        // 3        // 5      - Completed
        @Override
        public States nextState() {
            return States.IDLE;
        }

        @Override
        public void process(VendingMachine machine, String eventMessage) {
            super.process(machine, eventMessage);       // first controller will come here.
            machine.setCoinList(new ArrayList<>());
            machine.setVendingMachineState(States.IDLE);
        }

        @Override
        public List<States> fromStates() {
            return List.of(States.ACCEPTING_COIN, States.PRODUCT_SELECTION);
        }
    },
    CLICKED_ON_PRODUCT_SELECTION_BUTTON("OPERATION - CLICKED ON PRODUCT SELECTION BUTTON") {               // 4         - done
        @Override
        public States nextState() {
            return States.PRODUCT_SELECTION;
        }

        @Override
        public void process(VendingMachine machine, String eventMessage) {
            super.process(machine, eventMessage);       // first controller will come here.
        }

        @Override
        public List<States> fromStates() {
            return List.of(States.ACCEPTING_COIN);
        }

    },
    SELECT_PRODUCT("OPERATION - SELECT PRODUCT") {                // 6              - done
        @Override
        public States nextState() {
            return States.DISPENSING;
        }

        @Override
        public void process(VendingMachine machine, String eventMessage) {
            super.process(machine, eventMessage);       // first controller will come here.
            this.productSelectionHandler.selectProduct(machine);
        }

        @Override
        public List<States> fromStates() {
            return List.of(States.PRODUCT_SELECTION);
        }

    },
    RETURN_CHANGE("OPERATION - RETURN CHANGE") {                     // 7           - done
        @Override
        public States nextState() {
            return States.PRODUCT_SELECTION;
        }

        @Override
        public void process(VendingMachine machine, String eventMessage) {
            super.process(machine, eventMessage);       // first controller will come here.
            this.paymentHandler.refundPayment(machine.getAmountToRefund());
        }

        @Override
        public List<States> fromStates() {
            return List.of(States.PRODUCT_SELECTION);
        }

    },
    DISPENSE_PRODUCT("OPERATION - DISPENSE PRODUCT") {                  // 9
        @Override
        public States nextState() {
            return States.IDLE;
        }

        @Override
        public void process(VendingMachine machine, String eventMessage) {
            super.process(machine, eventMessage);       // first controller will come here.
            this.productDispenseHandler.dispenseProduct(machine);
        }

        @Override
        public List<States> fromStates() {
            return List.of(States.DISPENSING);
        }

    },
    REFUND_FULL_MONEY("OPERATION - REFUND FULL MONEY") {             // 8
        @Override
        public States nextState() {
            return States.IDLE;
        }

        @Override
        public void process(VendingMachine machine, String eventMessage) {
            super.process(machine, eventMessage);       // first controller will come here.
            this.paymentHandler.refundPayment(machine.getTotalAmountPaidByUser());
        }

        @Override
        public List<States> fromStates() {
            return List.of(States.PRODUCT_SELECTION);
        }

    };

//    UPDATE_INVENTORY("OPERATION - UPDATE INVENTORY") {                  // 10
//        @Override
//        public States nextState() {
//            return States.IDLE;
//        }
//
//        @Override
//        public void process(VendingMachine machine, String eventMessage) {
//            super.process(machine, eventMessage);       // first controller will come here.
//        }
//
//        @Override
//        public List<States> fromStates() {
//            return List.of(States.DISPENSING);
//        }
//    };

    protected final String message;
    protected final PaymentHandler paymentHandler;
    protected final ProductSelectionHandler productSelectionHandler;
    protected final ProductDispenseHandler productDispenseHandler;
    Operations(String message) {
        this.message = message;
        this.paymentHandler = new CoinPaymentHandler();
        this.productSelectionHandler = new ProductSelectionHandler();
        this.productDispenseHandler = new ProductDispenseHandler();
    }

    @Override
    public void process(VendingMachine machine, String eventMessage) {
        this.operationValidation(machine);
        System.out.println("Common processing for all the operations");
    }

    private void operationValidation(VendingMachine machine){
        if (!this.fromStates().contains(machine.getVendingMachineState())) {
            throw new RuntimeException("Error in state validation");
        }
    }

}
