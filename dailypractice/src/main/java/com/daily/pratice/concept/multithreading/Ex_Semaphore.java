package com.daily.pratice.concept.multithreading;

import java.util.concurrent.Semaphore;

/**
 * Semaphores are used as counters. If you want to control how many threads can access a given resource concurrently.
 */
final class Ex_Semaphore {

    public static void main( final String[] args ) {
        Semaphore semaphore = new Semaphore(5);
        Runnable runnable = () -> {
            if( semaphore.tryAcquire() ) {
                process( semaphore.availablePermits() );
            }
        };
        while( semaphore.availablePermits() > 0 ) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }

    private static void process(int permits ){
        System.out.println("Available permits " + permits );
    }

}
