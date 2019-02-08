package com.daily.pratice.concept.multithreading;

import java.util.concurrent.CountDownLatch;

/**
 * Threads wait at the gate and will not be released until countdown is zero.
 * Usage : if in your application, you have a main service that depends on many other services, you will want to start
 * these other services before bringing up main application. So, a countdown latch will act as a gate at the start of
 * main thread - will only allow main service to come up after all other services are brought up.
 */
final class Ex_CountdownLatch {

    private static final int MAX_THREADS = 3;

    public static void main( final String[] args ) {

        CountDownLatch latch = new CountDownLatch(MAX_THREADS);

        Runnable workerRunnable = () -> {
            doWork();
            System.out.println("Decrementing latch");
            latch.countDown();
        };

        Runnable masterRunnable = () -> {
            try {
                while (latch.getCount() > 0) {
                    System.out.println("Waiting");
                    latch.await();
                }
                System.out.println("Done waiting");

            } catch ( Exception e){
                e.printStackTrace();
            }
        };

        Thread master = new Thread(masterRunnable);
        master.start();

        for( int i = 0; i <= MAX_THREADS; ++i ) {
            Thread worker = new Thread(workerRunnable);
            worker.start();
        }
    }
    private static void doWork(){
        System.out.println(Thread.currentThread() + "doing work." );
    }

}
