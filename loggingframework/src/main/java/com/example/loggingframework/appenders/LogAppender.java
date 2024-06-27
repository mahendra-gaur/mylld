package com.example.loggingframework.appenders;

import com.example.loggingframework.message.LogMessage;

public interface LogAppender {
    void append(LogMessage message);
}