package com.example.my_atm.mine.temp;

import java.util.Objects;

public class Printer {
    private static volatile Printer instance;

    private Printer() {

    }

    public static Printer getInstance() {
        if(Objects.isNull(instance)) {
            synchronized(Printer.class) {
                if(Objects.isNull(instance)) {
                    instance = new Printer();
                }
            }
        }
        return instance;
    }

    public Boolean print(String message) {
        System.out.println("Print - " + message);
        return true;
    }
}
