package com.example.vending_machine.exception;

public class InvalidProductCodeException extends RuntimeException{
    public InvalidProductCodeException(String msg) {
        super(msg);
    }
}