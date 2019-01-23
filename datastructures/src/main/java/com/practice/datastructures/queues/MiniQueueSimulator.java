package com.practice.datastructures.queues;

import com.practice.datastructures.RootLogger;
import org.apache.logging.log4j.Logger;


public class MiniQueueSimulator {

    public static void main( String[] args ) {
        Logger logger = RootLogger.getLogger();
        Queue queue = Queue.getInstance();
        queue.populateQueue();
        queue.print();
        int size = queue.size();
        for ( int i = 0; i < size; i++ ) {
            queue.remove();
            queue.print();
        }
        queue = Queue.getInstance();
        queue.populateQueue();
        queue.print();
        if ( !queue.insert(new Integer(100)) ) {
            logger.debug("Queue is full ");
        }

    }
}
