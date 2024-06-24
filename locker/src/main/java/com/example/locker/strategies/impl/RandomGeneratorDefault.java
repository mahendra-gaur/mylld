package com.example.locker.strategies.impl;

import com.example.locker.strategies.IRandomGenerator;
import lombok.NonNull;

public class RandomGeneratorDefault implements IRandomGenerator {

    @NonNull
    @Override
    public Integer getRandomNumber(Integer lessThanThis) {
        return (int) (Math.random() * lessThanThis);
    }
}