package com.daily.pratice.concept.multithreading;

public class Test {
    static Test test;
    public static void main(String[] args) {
        System.out.println(" Test wait");
        test = new Test();

    }
    synchronized void testme() {
        try {
            test.wait();
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
}


