package com.example.my_atm.mine.temp;

import com.example.my_atm.mine.Card;
import com.example.my_atm.mine.utils.CardUtil;

import java.util.Objects;

public class CardReader {

    private final Screen screen;

    private static volatile CardReader instance;

    private CardReader() {
        this.screen = Screen.getInstance();
    }

    public static CardReader getInstance() {
        if(Objects.isNull(instance)) {
            synchronized(CardReader.class) {
                if(Objects.isNull(instance)) {
                    instance = new CardReader();
                }
            }
        }
        return instance;
    }

    public Card readCard() {
        return CardUtil.getCard();
    }



}
