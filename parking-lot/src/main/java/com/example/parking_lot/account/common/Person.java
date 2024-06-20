package com.example.parking_lot.account.common;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Person {
    private Person(){}
    private Address address;
    private Contact contact;
    private String firstName;
    private String lastName;
}