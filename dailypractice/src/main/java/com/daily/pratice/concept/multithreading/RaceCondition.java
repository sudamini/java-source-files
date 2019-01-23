package com.daily.pratice.concept.multithreading;

import java.lang.Thread;
/*
Race condition occurs when a given code fragment gives inconsistent results when called by more than one thread in an
unsynchronized manner.
 */

class RaceCondition {
    private int counter;

    public static void main (String[] args ) {
        RaceCondition race = new RaceCondition();
        Worker1 worker1 = race.new Worker1();
        Worker2 worker2 = race.new Worker2();

        new Thread( worker1).start();
        new Thread( worker2).start();

    }

    private int incrementCounter() {
        return ++counter;
    }

    private class Worker1 implements Runnable {

        @Override
        public void run() {
            int currentCount = 0;
            while (currentCount < 20 ) {
                currentCount = currentCount = incrementCounter();
                System.out.println("Current count for " + Thread.currentThread().getName() + " is " + currentCount);
            }
        }

    }

    private class Worker2 implements Runnable {
        @Override
        public void run() {
            int currentCount = 0;
            while ( currentCount < 20 ) {
                currentCount = incrementCounter();
                System.out.println("Current count for  " + Thread.currentThread().getName() + " is  " + currentCount);
            }
        }
    }
}
