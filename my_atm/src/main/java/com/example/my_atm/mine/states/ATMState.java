package com.example.my_atm.mine.states;

import com.example.my_atm.mine.ATM;
import com.example.my_atm.mine.Card;
import com.example.my_atm.mine.helper.Screen;

public abstract class ATMState {

    protected final Screen screen;

    protected ATMState() {
        this.screen = Screen.getInstance();
    }

    public void insertCard(ATM atm) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void processCard(ATM atm){
        System.out.println("OOPS!! Something went wrong");
    }

    public void selectOperation(ATM atm, Card card){
        System.out.println("OOPS!! Something went wrong");
    }

    public void cashWithdrawal(ATM atm, Card card){
        System.out.println("OOPS!! Something went wrong");
    }

    public void displayBalance(ATM atm, Card card){
        System.out.println("OOPS!! Something went wrong");
    }

    protected void exit(ATM atmObject){
        returnCard();
        atmObject.setCurrentATMState(new IdleState());
    }

    protected void returnCard(){
        this.screen.showMessage("Please collect your card");
    }

}
