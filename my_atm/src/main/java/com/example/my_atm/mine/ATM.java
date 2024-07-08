package com.example.my_atm.mine;

import com.example.my_atm.mine.states.ATMState;
import com.example.my_atm.mine.states.IdleState;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


public class ATM {
    private static volatile ATM INSTANCE;
    @Setter
    @Getter
    ATMState currentATMState;
    @Getter
    private int atmBalance;
    @Getter
    int noOfTwoThousandNotes;
    @Getter
    int noOfFiveHundredNotes;
    @Getter
    int noOfOneHundredNotes;

    private ATM(){
        this.noOfTwoThousandNotes = 0;
        this.noOfFiveHundredNotes = 0;
        this.noOfOneHundredNotes = 0;
        this.atmBalance = 0;
    }

    public static ATM getAtmInstance() {
        if(Objects.isNull(INSTANCE)) {
            synchronized (ATM.class) {
                if(Objects.isNull(INSTANCE)) {
                    INSTANCE = new ATM();
                    INSTANCE.setCurrentATMState(new IdleState());
                }
            }
        }
        return INSTANCE;
    }

    public void setAtmBalance(int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes) {
        this.noOfTwoThousandNotes += noOfTwoThousandNotes;
        this.noOfFiveHundredNotes += noOfFiveHundredNotes;
        this.noOfOneHundredNotes += noOfOneHundredNotes;
        this.atmBalance = calculateAtmBalance();
    }

    private Integer calculateAtmBalance(){
        return (2000 * this.noOfTwoThousandNotes) +
                (500 * this.noOfFiveHundredNotes) +
                (100 * this.noOfOneHundredNotes);
    }

    public void deductATMBalance(int amount) {
        atmBalance = atmBalance - amount;
    }

    public void deductTwoThousandNotes(int number) {
        noOfTwoThousandNotes = noOfTwoThousandNotes - number;
    }

    public void deductFiveHundredNotes(int number) {
        noOfFiveHundredNotes = noOfFiveHundredNotes - number;
    }

    public void deductOneHundredNotes(int number) {
        noOfOneHundredNotes = noOfOneHundredNotes - number;
    }

    public void printCurrentATMStatus(){
        System.out.println("Balance: " + atmBalance);
        System.out.println("2kNotes: " + noOfTwoThousandNotes);
        System.out.println("500Notes: " + noOfFiveHundredNotes);
        System.out.println("100Notes: " + noOfOneHundredNotes);

    }




}
