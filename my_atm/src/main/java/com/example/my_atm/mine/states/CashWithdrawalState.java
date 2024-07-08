package com.example.my_atm.mine.states;

import com.example.my_atm.mine.ATM;
import com.example.my_atm.mine.Card;
import com.example.my_atm.mine.temp.Keypad;
import com.example.my_atm.mine.withdrawal.*;

public class CashWithdrawalState extends ATMState {

    private final Keypad keypad;
    private final CashWithdrawProcessor withdrawProcessor;


    public CashWithdrawalState(ATM atm, Card card) {
        super();
        this.keypad = Keypad.getInstance();
        this.withdrawProcessor = CashDispenseManager.getInstance();
        this.cashWithdrawal(atm, card);
    }


    public void cashWithdrawal(ATM atmObject, Card card) {
        this.screen.showMessage("Please enter the Withdrawal Amount");
        Integer userEnteredAmount = Integer.parseInt(keypad.getInput());

        if (atmObject.getAtmBalance() < userEnteredAmount) {
            this.screen.showMessage("Insufficient fund in the ATM Machine");
            exit(atmObject);
        } else if (card.getBankBalance() < userEnteredAmount) {
            this.screen.showMessage("Insufficient fund in the your Bank Account");
            exit(atmObject);
        } else {

            card.deductBankBalance(userEnteredAmount);
            atmObject.deductATMBalance(userEnteredAmount);

            this.withdrawProcessor.withdraw(atmObject, userEnteredAmount);
            exit(atmObject);
        }
    }
}


