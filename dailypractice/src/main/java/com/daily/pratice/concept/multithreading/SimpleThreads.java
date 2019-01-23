package com.daily.pratice.concept.multithreading;

/*
consists of two threads. The first is the main thread that every Java application has.
The main thread creates a new thread from the Runnable object, MessageLoop, and waits for it to finish.
If the MessageLoop thread takes too long to finish, the main thread interrupts it.
 */

class SimpleThreads {

    public static void main ( String[] args ) throws InterruptedException {
        SimpleThreads simpleThreads = new SimpleThreads();
        MessageLoop messageLoop = simpleThreads.new MessageLoop();
        long patience = 2000;
        long currentTime = System.currentTimeMillis();
        Thread t = new Thread( messageLoop );
        t.start();

        while ( t.isAlive() ) {
            System.out.println ( Thread.currentThread().getName() + " waiting");
            t.join(3000 );
            if ( System.currentTimeMillis() - currentTime > patience && t.isAlive() ) {
                System.out.println ("I am losing it! Its time for "+ t.getName() +" to die!!");
                t.interrupt();
            }
        }
    }

   private class MessageLoop implements Runnable {
        String[] messageLoop = new String[]{"message one ", "message two ", "message three ", "message four ", "message five ", "message six ", "message seven "};

        @Override
        public void run() {

            try {
                for (String str : messageLoop) {
                    System.out.println( Thread.currentThread().getName() +  " printing " + str );
                    Thread.sleep(5000);
                }
            } catch ( InterruptedException e) {
                System.out.println ( Thread.currentThread().getName() + " was not done! ");
            }

        }
    }

}
