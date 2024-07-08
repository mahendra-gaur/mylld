package com.example.my_atm.mine.withdrawal;

import com.example.my_atm.mine.ATM;

import java.util.Objects;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor{

    private OneHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    public static volatile CashWithdrawProcessor instance;

    public static CashWithdrawProcessor getInstance(CashWithdrawProcessor nextCashWithdrawProcessor) {
        if(Objects.isNull(instance)) {
            synchronized(TwoThousandWithdrawProcessor.class) {
                if(Objects.isNull(instance)) {
                    instance = new OneHundredWithdrawProcessor(nextCashWithdrawProcessor);
                }
            }
        }
        return instance;
    }

    public void withdraw(ATM atm, int remainingAmount){

        int required =  remainingAmount/100;
        int balance = remainingAmount%100;

        if(required <= atm.getNoOfOneHundredNotes()) {
            atm.deductOneHundredNotes(required);
        }
        else if(required > atm.getNoOfOneHundredNotes()) {
            atm.deductOneHundredNotes(atm.getNoOfOneHundredNotes());
            balance = balance + (required-atm.getNoOfOneHundredNotes()) * 100;
        }

        if(balance != 0){
            System.out.println("Something went wrong");
        }
    }
}