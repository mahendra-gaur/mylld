package com.example.locker.utils;

import static com.example.locker.utils.RandomUtils.randomEmail;
import static com.example.locker.utils.RandomUtils.randomString;

import com.example.locker.model.Buyer;
import com.example.locker.model.Contact;

public class BuyerUtils {

    public static Buyer randomBuyer() {
        return new Buyer(new Contact(randomString(), randomEmail()));
    }
}