package com.example.loggingframework.abstractloggers.impl;

import com.example.loggingframework.message.LogMessage;
import com.example.loggingframework.enums.LogLevel;
import com.example.loggingframework.abstractloggers.AbstractLogger;

public class DebugLogger extends AbstractLogger {

    public DebugLogger() {
        this.level = LogLevel.DEBUG;
    }

    @Override
    public void display(LogMessage logMessage) {
        this.logAppender.append(logMessage);
    }
}