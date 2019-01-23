package com.daily.pratice.concept.multithreading.producerconsumer;

import java.util.LinkedList;

/**
 * Buffer is a linked list shared between a producer and a consumer.
 * Producer will synchronize on buffer, insert values into buffer until its full.
 * Once its full, it will call wait, release monitor and wait for consumer to consume.
 * Consumer will consume values from buffer, notify producer to produce new values.
 * Once all values are consumed. it will call wait, release the monitor and wait for producer to produce.
 * Will run only 15 iterations, configurable in variable ITERATIONS.
 */

final class ProducerConsumer {

    private static final LinkedList<Integer> buffer;
    private static final int CAPACITY = 5;
    private static final int ITERATIONS = 15;

    static {
        buffer = new LinkedList<>();
    }

    public static void main (final String[] args ) {
        try {
            Producer producer = new Producer();
            Consumer consumer = new Consumer();

            Runnable produceRunnable = () -> producer.produce();

            Runnable consumeRunnable = () -> consumer.consume();

            Thread producerThread = new Thread(produceRunnable);
            Thread consumerThread = new Thread(consumeRunnable);

            producerThread.start();
            consumerThread.start();

            producerThread.join();
            consumerThread.join();

        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    private static class Producer {
        void produce(){
            int val = 0;
            try {
                synchronized (buffer) {
                    while ( true ) {
                    if( buffer.size() == CAPACITY ) {
                        buffer.wait();
                    }
                    if ( val == ITERATIONS + 1 ) {
                        return;
                    }
                    System.out.println("Producer produced " + val );
                    buffer.add(val++);
                    Thread.sleep(1000);
                    buffer.notify();
                }
            }
            } catch (Exception e ) {
                e.printStackTrace();
            }
        }
    }

    private static class Consumer {
        void consume() {
            int val;
            try {
                synchronized (buffer) {
                    while (true) {
                        if (buffer.size() == 0) {
                            buffer.wait();
                        }
                        val = buffer.removeFirst();
                        if ( val == ITERATIONS ) {
                            return;
                        }
                        System.out.println("Consumer consumed " + val);
                        Thread.sleep(1000);
                        buffer.notify();
                    }
                }
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        }
    }
}
