package com.example.my_atm.mine.withdrawal;

import com.example.my_atm.mine.ATM;

import java.util.Objects;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor{

    private FiveHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    public static volatile CashWithdrawProcessor instance;

    public static CashWithdrawProcessor getInstance(CashWithdrawProcessor nextCashWithdrawProcessor) {
        if(Objects.isNull(instance)) {
            synchronized(TwoThousandWithdrawProcessor.class) {
                if(Objects.isNull(instance)) {
                    instance = new FiveHundredWithdrawProcessor(nextCashWithdrawProcessor);
                }
            }
        }
        return instance;
    }

    public void withdraw(ATM atm, int remainingAmount){

        int required =  remainingAmount/500;
        int balance = remainingAmount%500;

        if(required <= atm.getNoOfFiveHundredNotes()) {
            atm.deductFiveHundredNotes(required);
        }
        else if(required > atm.getNoOfFiveHundredNotes()) {
            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
            balance = balance + (required-atm.getNoOfFiveHundredNotes()) * 500;
        }

        if(balance != 0){
            super.withdraw(atm, balance);
        }
    }
}