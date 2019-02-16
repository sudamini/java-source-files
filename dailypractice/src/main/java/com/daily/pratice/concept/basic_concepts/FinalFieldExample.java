package com.daily.pratice.concept.basic_concepts;

final class FinalFieldExample {
    private final int x;
    private int y;
    private static FinalFieldExample f;

    private FinalFieldExample() {
        x = 3;
        y = 4;
    }

    private static void writer() {
        f = new FinalFieldExample();
    }
    /*
    Will not see anything until f's creation is complete.
     */
    private static void reader() {
        if (f != null) {
            int i = f.x;  // guaranteed to see 3
            int j = f.y;  // could see 0
            System.out.println("i = " + i + " j = " +j );
        }
    }

    public static void main (final String[] args ){
        Runnable writerTask = () -> {
            try {
                System.out.println("Thread " + Thread.currentThread().getName());
                Thread.sleep(100);
                writer();
            } catch( InterruptedException e){
                e.printStackTrace();
            }
        };

        Runnable readerTask = () -> {
            try {
                System.out.println("Thread " + Thread.currentThread().getName());
                Thread.sleep(500);
                reader();
            } catch( InterruptedException e){
                e.printStackTrace();
            }
        };
        new Thread(writerTask).start();
        new Thread(readerTask).start();
    }
}
