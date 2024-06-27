package com.example.loggingframework.abstractloggers;

import com.example.loggingframework.message.LogMessage;
import com.example.loggingframework.config.LoggerConfig;
import com.example.loggingframework.enums.LogLevel;
import com.example.loggingframework.appenders.LogAppender;

public abstract class AbstractLogger {
    protected LogLevel level;
    protected AbstractLogger nextLevelLogger;
    protected LogAppender logAppender;
    public AbstractLogger() {
        this.logAppender = LoggerConfig.getLoggerConfig().getLogAppender();
    }

    public void setNextLevelLogger(AbstractLogger nextLevelLogger) {
        this.nextLevelLogger = nextLevelLogger;
    }

    public void logMessage(LogMessage logMessage){
        if(this.level==logMessage.getLevel()){
            this.display(logMessage);
        }

        if (nextLevelLogger!=null) {
            nextLevelLogger.logMessage(logMessage);
        }
    }
    protected abstract void display(LogMessage logMessage);
}