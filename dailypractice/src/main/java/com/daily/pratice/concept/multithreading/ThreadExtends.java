package com.daily.pratice.concept.multithreading;

class ThreadExtends  extends Thread {

    private int counter;

    public static void main (String[] args) throws InterruptedException {
        ThreadExtends te1 = new ThreadExtends();
        te1.start();
        ThreadExtends te2 = new ThreadExtends();
        te2.start();
        te1.interrupt();
        te2.join();

    }

    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                System.out.println(this.getName() + " counter " + incrementCounter());
                Thread.sleep(1000);
            }
        } catch ( Exception e ) {
            System.out.println ("I have been interrupted." +this.getName());
            e.printStackTrace();
            return;
        }
    }

    private int incrementCounter() {
        System.out.println ("Counter value before " + counter);
        ++counter;
        System.out.println ("Counter value after " + counter);
        return counter;
    }
}
