package com.example.my_atm.mine.withdrawal;

import com.example.my_atm.mine.ATM;

import java.util.Objects;

public class TwoThousandWithdrawProcessor extends CashWithdrawProcessor {

    private TwoThousandWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    public static volatile CashWithdrawProcessor instance;

    public static CashWithdrawProcessor getInstance(CashWithdrawProcessor nextCashWithdrawProcessor) {
        if(Objects.isNull(instance)) {
            synchronized(TwoThousandWithdrawProcessor.class) {
                if(Objects.isNull(instance)) {
                    instance = new TwoThousandWithdrawProcessor(nextCashWithdrawProcessor);
                }
            }
        }
        return instance;
    }

    public void withdraw(ATM atm, int remainingAmount) {

        int required =  remainingAmount/2000;
        int balance = remainingAmount%2000;

        if(required <= atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(required);
        }
        else if(required > atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
            balance = balance + (required-atm.getNoOfTwoThousandNotes()) * 2000;
        }

        if(balance != 0){
            super.withdraw(atm, balance);
        }
    }
}