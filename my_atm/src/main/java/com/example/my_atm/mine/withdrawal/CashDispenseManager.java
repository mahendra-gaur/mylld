package com.example.my_atm.mine.withdrawal;

import java.util.Objects;

public class CashDispenseManager {
    public static volatile CashWithdrawProcessor instance;

    public static CashWithdrawProcessor getInstance(){
        if(Objects.isNull(instance)) {
            synchronized(CashDispenseManager.class) {
                if(Objects.isNull(instance)) {
                    //using chain of responsibility for this logic, how many 2k Rs notes, how many 500 Rs notes etc, has to be withdrawal
                    instance = TwoThousandWithdrawProcessor.getInstance(
                            FiveHundredWithdrawProcessor.getInstance(
                                    OneHundredWithdrawProcessor.getInstance(null)
                            )
                    );
                }
            }
        }
        return instance;
    }
}
