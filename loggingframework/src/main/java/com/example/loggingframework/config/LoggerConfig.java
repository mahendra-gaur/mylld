package com.example.loggingframework.config;

import com.example.loggingframework.enums.LogLevel;
import com.example.loggingframework.appenders.LogAppender;
import com.example.loggingframework.appenders.impl.ConsoleAppender;

public class LoggerConfig {
    private LogLevel logLevel;
    private LogAppender logAppender;

    private static volatile LoggerConfig loggerConfig;

    private LoggerConfig() {
        this.logLevel = LogLevel.INFO;
        this.logAppender = new ConsoleAppender();
    }

    public static LoggerConfig getLoggerConfig() {
        if (loggerConfig == null) {
            synchronized (LoggerConfig.class) {
                if (loggerConfig == null) {
                    loggerConfig = new LoggerConfig();
                }
            }
        }
        return loggerConfig;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public LogAppender getLogAppender() {
        return logAppender;
    }

    public void setLogAppender(LogAppender logAppender) {
        this.logAppender = logAppender;
    }

}
