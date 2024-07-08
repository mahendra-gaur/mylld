package com.example.my_atm.mine.states;

import com.example.my_atm.mine.ATM;

public class IdleState extends ATMState {

    public IdleState() {
        super();
    }

    @Override
    public void insertCard(ATM atm) {
        this.screen.showMessage("Card is inserted");
        atm.setCurrentATMState(new HasCardState(atm));
    }

    @Override
    public void returnCard(){
        this.screen.showMessage("OOPS!! Something went wrong");
    }

    @Override
    public void exit(ATM atm){
        this.screen.showMessage("OOPS!! Something went wrong");
    }
}
