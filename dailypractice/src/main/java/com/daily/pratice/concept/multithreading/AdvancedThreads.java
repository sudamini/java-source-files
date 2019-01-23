package com.daily.pratice.concept.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class AdvancedThreads implements Runnable {

    public static void main(String[] args) {

        // create and populate work queue

        List<Callable<String>> workQueue = new ArrayList<>();
        Callable<String> primes = new WorkerThread("Primes");
        workQueue.add ( primes );
        Callable<String> squares = new WorkerThread("Squares");
        workQueue.add ( squares );

        // initialize threadpool executor
        ExecutorService executor = Executors.newFixedThreadPool(10);
       // ThreadPoolExecutor pool = new ThreadPoolExecutor( 2,4,1, TimeUnit.NANOSECONDS,workQueue );
        try {
            List<Future<String>> futures = executor.invokeAll(workQueue);
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println ( "Waiting");

    }


    private static class WorkerThread implements Callable<String> {
        String commandName;

        private WorkerThread( String name ) {
            commandName = name;
        }

        @Override
        public String call() {
            System.out.println ("Calculating " +commandName );
            try {
                Thread.sleep(20);
                process(commandName);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        void process ( String command ) {
            if ( command.equals("Primes")) {
                calculatePrimes();
            }
            if ( command.equals("Squares")){
                calculateSquares();
            }
        }

        void calculatePrimes(){
            System.out.println ( Thread.currentThread().getName() + " working.");
            for ( int i = 1; i < 100; i++ ){
                if ( i % 2 == 1 ) {
                    System.out.println( Thread.currentThread().getName() + ":"+i );
                }
            }
        }
        void calculateSquares(){
            System.out.println ( Thread.currentThread().getName() + " working.");
            for ( int i = 1; i < 100; i++ ) {
                System.out.println ( Thread.currentThread().getName() + ":" + i + "*"+ i + "=" +(i*i));
            }
        }
    }
}


