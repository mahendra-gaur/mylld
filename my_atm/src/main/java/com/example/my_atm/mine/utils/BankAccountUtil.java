package com.example.my_atm.mine.utils;

import com.example.my_atm.mine.account.BankAccount;
import com.example.my_atm.mine.account.SavingAccount;

public class BankAccountUtil {
    public static BankAccount getBankAccount(){
        return SavingAccount.builder().accountNumber("1020304050").availableBalance(3000.0).build();
    }
}
