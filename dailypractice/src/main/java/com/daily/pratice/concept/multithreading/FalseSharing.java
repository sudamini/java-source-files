package com.daily.pratice.concept.multithreading;

/**
 * This class shows impact of false sharing on class's performance.
 * False sharing occurs because of heavy multithreading use on multicore cpus if operating system
 * uses same cache line to store multiple variables being operated by independent threads.
 */
class FalseSharing {
    private static int NUM_THREADS_MAX = 20;
    private final static long ITERATIONS = 50_000_000;

    private static VolatileLongPadded[] paddedLongs;
    private static VolatileLongUnPadded[] unPaddedLongs;

    /**
     * Uses padding so that member variable will be stored on its own cache line.
     */
    final static class VolatileLongPadded {
        long q1,q2,q3,q4,q5,q6;
        volatile long value = 0L;
        long q11,q12,q13,q14,q15,q16;
    }
    /**
     * Member variable will be most likely stored along with other variables on the same cache line.
     */
    final static class VolatileLongUnPadded {
        volatile long value = 0L;
    }

    static {
        paddedLongs = new VolatileLongPadded[NUM_THREADS_MAX];
        for( int i = 0; i < paddedLongs.length; i++ ) {
            paddedLongs[i] = new VolatileLongPadded();
        }
        unPaddedLongs = new VolatileLongUnPadded[NUM_THREADS_MAX];
        for( int i = 0; i < unPaddedLongs.length; i++ ) {
            unPaddedLongs[i] = new VolatileLongUnPadded();
        }
    }

    public static void main( final String[] args ) throws Exception {
        runBenchmark();
    }

    private static void runBenchmark() throws InterruptedException {
        long begin, end;
        for( int n = 1; n <= NUM_THREADS_MAX; n++ ){
            Thread[] threads = new Thread[n];

            for( int j = 0; j < threads.length; j++ ){
                threads[j] = new Thread( createPaddedRunnable(j));
            }
            begin = System.currentTimeMillis();
            for( Thread t : threads ){t.start(); }
            for(Thread t : threads ) {t.join(); }
            end = System.currentTimeMillis();
            System.out.printf( " Padded # threads %d - T = %dms\n", n, end - begin );

            for( int j = 0; j < threads.length; j++ ){
                threads[j] = new Thread( createUnPaddedRunnable(j));
            }
            begin = System.currentTimeMillis();
            for( Thread t : threads ){t.start(); }
            for(Thread t : threads ) {t.join(); }
            end = System.currentTimeMillis();
            System.out.printf( " UnPadded # threads %d - T = %dms\n", n, end - begin );
        }
    }

    private static Runnable createUnPaddedRunnable(final int k ) {
        return () -> {
            long i = ITERATIONS + 1;
            while( 0 != --i ){
                unPaddedLongs[k].value = i;
            }
        };
    }

    private static Runnable createPaddedRunnable(final int k ) {
        Runnable paddedTouch = () -> {
            long i = ITERATIONS + 1;
            while( 0 != --i ){
                paddedLongs[k].value = i;
            }
        };
        return paddedTouch;
    }

}
