package com.example.my_atm.mine;

public class Main {
    public static void main(String[] args) {
        ATM atm = ATM.getAtmInstance();
        atm.setAtmBalance(1,2,5);
        atm.getCurrentATMState().insertCard(atm);
    }
}
