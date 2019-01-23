package com.practice.datastructures;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RootLogger {

    static Logger logger;

    static {
        logger = LogManager.getRootLogger();
        System.setProperty("log4j.configurationFile", "E:\\data\\workspaces\\datastructures\\src\\main\\resources\\log4j2.xml");
    }

    public static void main ( String args[] ) {
        //Logger logger = LogManager.getRootLogger();
        //System.setProperty("log4j.configurationFile", "E:\\data\\workspaces\\datastructures\\src\\main\\resources\\log4j2.xml");
        //logger.trace("Configuration File Defined as " + System.getProperty("log4j.configurationFile") );
        //logger.trace( "Test log line " );
    }

    public static Logger getLogger () {
        return logger;
    }
}
