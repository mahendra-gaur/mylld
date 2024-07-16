package org.example.controller;

public interface ICache <Key, Value>{

    void initialize();
    void put(Key key, Value value);
    void put(Key key, Value value, long timeInMilliSeconds);
    Value get(Key key);
}
