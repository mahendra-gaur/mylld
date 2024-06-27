package com.example.loggingframework;

import com.example.loggingframework.logger.Logger;

public class Main {

    public static void main(String[] args) {
//        TRACE, DEBUG, INFO, WARN, ERROR, FATAL;


        Logger logger = Logger.getLogger();
        logger.trace("This is trace log");
        logger.debug("This is debug log");
        logger.info("This is info log");
        logger.warn("This is warn log");
        logger.error("This is error log");
        logger.fatal("This is fatal log");
    }

}
