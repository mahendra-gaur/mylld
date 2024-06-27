package com.example.loggingframework.abstractloggers.impl;

import com.example.loggingframework.message.LogMessage;
import com.example.loggingframework.abstractloggers.AbstractLogger;
import com.example.loggingframework.enums.LogLevel;

public class InfoLogger extends AbstractLogger {

    public InfoLogger() {
        this.level = LogLevel.INFO;
    }

    @Override
    public void display(LogMessage logMessage) {
        this.logAppender.append(logMessage);
    }
}