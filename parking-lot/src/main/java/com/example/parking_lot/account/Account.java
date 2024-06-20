package com.example.parking_lot.account;

import com.example.parking_lot.account.common.Person;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public abstract class Account {
    private String id;
    private String username;
    private String password;
    private Person person;

}