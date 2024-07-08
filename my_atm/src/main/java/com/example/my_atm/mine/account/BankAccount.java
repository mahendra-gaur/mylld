package com.example.my_atm.mine.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class BankAccount {
    protected String accountNumber;
    @Getter
    @Setter
    protected Double availableBalance;

    public void withdrawalBalance(int amount) {
        this.availableBalance = this.availableBalance - amount;
    }
    public Double withdrawalLimit() {
        return this.availableBalance;
    }

}
