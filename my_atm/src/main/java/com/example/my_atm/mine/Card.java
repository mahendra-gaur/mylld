package com.example.my_atm.mine;

import com.example.my_atm.mine.account.BankAccount;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class Card {
    private String cardNumber;
    private Integer cvv;
    private LocalDateTime expiryDate;
    private String holderName;
    private Integer PIN_NUMBER = 112211;
    private BankAccount bankAccount;

    public boolean isCorrectPINEntered(int pin) {
        if (pin == PIN_NUMBER) {
            return true;
        }
        return false;
    }

    public Double getBankBalance(){
        return bankAccount.getAvailableBalance();
    }

    public void deductBankBalance(int amount){
        bankAccount.withdrawalBalance(amount);
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }


}
