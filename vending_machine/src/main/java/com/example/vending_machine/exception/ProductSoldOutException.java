package com.example.vending_machine.exception;

public class ProductSoldOutException extends RuntimeException{
    public ProductSoldOutException(String msg) {
        super(msg);
    }
}
