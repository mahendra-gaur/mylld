package com.example.loggingframework.logger;

import com.example.loggingframework.abstractloggers.AbstractLogger;
import com.example.loggingframework.abstractloggers.impl.DebugLogger;
import com.example.loggingframework.abstractloggers.impl.ErrorLogger;
import com.example.loggingframework.abstractloggers.impl.FatalLogger;
import com.example.loggingframework.abstractloggers.impl.InfoLogger;
import com.example.loggingframework.abstractloggers.impl.TraceLogger;
import com.example.loggingframework.abstractloggers.impl.WarnLogger;
import com.example.loggingframework.config.LoggerConfig;
import com.example.loggingframework.enums.LogLevel;
import com.example.loggingframework.message.LogMessage;
import java.io.Serializable;
import lombok.Getter;

public class Logger implements Cloneable, Serializable {

    @Getter
    private LoggerConfig config;

    private AbstractLogger abstractLogger;

    private Logger() {
        this.config = LoggerConfig.getLoggerConfig();
        this.abstractLogger = this.getAbstractLogger();
    }

    private static volatile Logger logger;
    public static Logger getLogger() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
//
//    protected Object readResolve() {
//        return logger;
//    }

    public void trace(String message) {
        this.log(LogLevel.TRACE, message);
    }
    public void debug(String message) {
        this.log(LogLevel.DEBUG, message);
    }
    public void info(String message) {
        this.log(LogLevel.INFO, message);
    }
    public void warn(String message) {
        this.log(LogLevel.WARN, message);
    }
    public void error(String message) {
        this.log(LogLevel.ERROR, message);
    }
    public void fatal(String message) {
        this.log(LogLevel.FATAL, message);
    }

    private void log(LogLevel level, String message){
        if (level.ordinal() >= config.getLogLevel().ordinal()) {
            LogMessage logMessage = new LogMessage(level, message);
            this.abstractLogger.logMessage(logMessage);
//            config.getLogAppender().append(logMessage);
        }
    }

    private AbstractLogger getAbstractLogger() {
//      TRACE, DEBUG, INFO, WARN, ERROR, FATAL;

        AbstractLogger traceLogger = new TraceLogger();

        AbstractLogger debugLogger = new DebugLogger();
        traceLogger.setNextLevelLogger(debugLogger);

        AbstractLogger infoLogger = new InfoLogger();
        debugLogger.setNextLevelLogger(infoLogger);

        AbstractLogger warnLogger = new WarnLogger();
        infoLogger.setNextLevelLogger(warnLogger);

        AbstractLogger errorLogger = new ErrorLogger();
        warnLogger.setNextLevelLogger(errorLogger);

        AbstractLogger fatalLogger = new FatalLogger();
        errorLogger.setNextLevelLogger(fatalLogger);

        return traceLogger;
    }
}