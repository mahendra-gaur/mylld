package com.example.cricbuzz.player;

import lombok.Getter;
import lombok.NonNull;


public class Person {
    @Getter
    private final String name;
    private int age;
    private String address;

    protected Person(@NonNull final String name) {
        this.name = name;
    }
}
