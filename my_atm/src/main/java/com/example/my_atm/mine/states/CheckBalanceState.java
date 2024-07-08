package com.example.my_atm.mine.states;

import com.example.my_atm.mine.ATM;
import com.example.my_atm.mine.Card;

public class CheckBalanceState extends ATMState{

    public CheckBalanceState(ATM atm, Card card) {
        super();
        displayBalance(atm, card);
    }

    @Override
    public void displayBalance(ATM atm, Card card){
        this.screen.showMessage("Your Balance is: " + card.getBankBalance());
        exit(atm);
    }

}


