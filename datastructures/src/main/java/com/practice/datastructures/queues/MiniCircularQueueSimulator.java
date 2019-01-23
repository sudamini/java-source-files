package com.practice.datastructures.queues;

import com.practice.datastructures.RootLogger;
import org.apache.logging.log4j.Logger;

public class MiniCircularQueueSimulator {

    public static void main(String[] args) {
        Logger logger = RootLogger.getLogger();
        CircularQueue queue = new CircularQueue();
        queue.populate();

       logger.debug ( " Return from insert: " + queue.insert(new Integer(10)));
        logger.debug( "At the front of the queue = " +queue.peek() );
        queue.print();
        queue.remove();
        queue.remove();
        queue.print();
        queue.insert(new Integer(80));
        queue.insert(new Integer(90));

        queue.print();
        logger.debug( "At the front of the queue = " +queue.peek() );

        for ( int i = 0; i < queue.getCurrent_size(); i++ ) {

            logger.debug ( queue.remove());
            queue.print();
        }

    }
}
