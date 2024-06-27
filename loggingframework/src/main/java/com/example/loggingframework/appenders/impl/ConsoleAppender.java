package com.example.loggingframework.appenders.impl;

import com.example.loggingframework.message.LogMessage;
import com.example.loggingframework.appenders.LogAppender;

public class ConsoleAppender implements LogAppender {
    @Override
    public void append(LogMessage message) {
        System.out.println("CONSOLE MESSAGE : "+ message);
    }
}