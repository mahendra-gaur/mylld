package com.example.my_atm.mine.states;

import com.example.my_atm.mine.ATM;
import com.example.my_atm.mine.Card;
import com.example.my_atm.mine.temp.CardReader;
import com.example.my_atm.mine.temp.Keypad;

public class HasCardState extends ATMState{

    private final CardReader cardReader;
    private final Keypad keypad;


    public HasCardState(ATM atm) {
        super();
        this.cardReader = CardReader.getInstance();
        this.keypad = Keypad.getInstance();
        processCard(atm);
    }

    @Override
    public void processCard(ATM atm){
        Card card = getCard();
        Integer userEnteredPin = getCardPinFromUser();

        boolean isCorrectPinEntered = card.isCorrectPINEntered(userEnteredPin);

        if(isCorrectPinEntered) {
            atm.setCurrentATMState(new SelectOperationState(atm, card));
        } else {
            this.screen.showMessage("Invalid PIN Number");
            exit(atm);
        }
    }

    private Card getCard() {
        return this.cardReader.readCard();
    }

    private Integer getCardPinFromUser() {
        screen.showMessage("enter your card pin number");
        Integer userEnteredPin = Integer.parseInt(keypad.getInput());
        return userEnteredPin;
    }

}

