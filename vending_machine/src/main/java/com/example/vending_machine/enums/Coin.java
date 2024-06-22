package com.example.vending_machine.enums;

public enum Coin {

    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25);

    public int value;

    Coin(int value) {
        this.value = value;
    }

    public static Coin fromValue(int value) {
        for (Coin coin : Coin.values()) {
            if (coin.value == value) {
                return coin;
            }
        }
        throw new IllegalArgumentException("No coin with value " + value);
    }
}
