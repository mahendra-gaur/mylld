package com.example.locker.strategies;

import lombok.NonNull;

public interface IOtpGenerator {

    @NonNull
    String generateOtp();
}