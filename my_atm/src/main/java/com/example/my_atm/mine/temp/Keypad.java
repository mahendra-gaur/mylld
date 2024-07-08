package com.example.my_atm.mine.temp;

import java.util.Objects;
import java.util.Scanner;

public class Keypad {
    private static volatile Keypad instance;

    private Keypad() {

    }

    public static Keypad getInstance() {
        if(Objects.isNull(instance)) {
            synchronized(Keypad.class) {
                if(Objects.isNull(instance)) {
                    instance = new Keypad();
                }
            }
        }
        return instance;
    }

    public String getInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
}
