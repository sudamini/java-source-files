package main.com.practice.datastructures.stacks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
package com.practice.root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RootLogger {

    public static void main ( String args[] ) {
        Logger logger = LogManager.getRootLogger();
        logger.trace("Configuration File Defined as " + System.getProperty("log4j.configurationFile") );
        logger.trace( "Test log line " );
    }
}
 */
public class MiniStackSimulator {

    public static void main ( String args[] ) {

        Logger logger = LogManager.getRootLogger();
        logger.trace("Configuration File Defined as " + System.getProperty("log4j.configurationFile") );
        logger.trace( "Test log line " );

        Stack stack = Stack.getInstance();
        System.out.println( "Stack pop returned " +stack.pop() + " " );
        System.out.println( "Stack peek returned " +stack.peek() + " ");
        stack.populate();
        stack.push( 100 );
        System.out.println( " Stack pop returned " +stack.pop());
        stack.printStack();
        System.out.println( "Stack peek returned " +stack.peek() );
        System.out.println( Stack.getInstance().peek() );

        for ( int i = 0; i < 10; i++ ) {
            System.out.println( "Stack pop returned " +stack.pop() + " " );
        }
        stack.pop();
    }
}
