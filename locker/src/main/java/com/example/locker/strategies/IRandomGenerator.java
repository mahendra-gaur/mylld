package com.example.locker.strategies;

import lombok.NonNull;

public interface IRandomGenerator {

    @NonNull
    Integer getRandomNumber(@NonNull Integer lessThanThis);
}