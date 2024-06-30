package com.example.loggingframework.abstractloggers.impl;

import com.example.loggingframework.message.LogMessage;
import com.example.loggingframework.abstractloggers.AbstractLogger;
import com.example.loggingframework.enums.LogLevel;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger() {
        this.level = LogLevel.ERROR;
    }

}