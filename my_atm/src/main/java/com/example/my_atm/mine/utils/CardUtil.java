package com.example.my_atm.mine.utils;

import com.example.my_atm.mine.Card;

import java.time.LocalDateTime;

public class CardUtil {
    public static Card getCard() {
        return Card.builder()
                .cardNumber("1234 2345 3456 4567")
                .cvv(421)
                .expiryDate(LocalDateTime.of(2025, 12, 1, 23,59, 59))
                .holderName("Mahendra")
                .PIN_NUMBER(2341)
                .bankAccount(BankAccountUtil.getBankAccount())
                .build();
    }
}
