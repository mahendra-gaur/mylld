package com.example.my_atm.mine.helper;

import java.util.Objects;

public class Screen {
    private static volatile Screen instance;

    private Screen() {

    }

    public static Screen getInstance() {
        if(Objects.isNull(instance)) {
            synchronized(Screen.class) {
                if(Objects.isNull(instance)) {
                    instance = new Screen();
                }
            }
        }
        return instance;
    }

    public Boolean showMessage(String message) {
        System.out.println(message);
        return true;
    }
}
