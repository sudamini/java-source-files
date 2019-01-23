package com.daily.pratice.concept.recursion;

public class Factorial {

    public static void main ( String args[] ) {
        int n = 10;
        int result;
        result = recursiveFactorial(n);
        System.out.println ("Recursive Factorial Result: " + result );
        int[] memo = new int[n+1];
        result = memoizedFactorial(n, memo );
        System.out.println ("Memoized Factorial Result: " + result );

        }

        public static int recursiveFactorial( int n ) {
            if ( ( n == 0  || n == 1  ) ) {
                return 1;
            }
            int result = n * recursiveFactorial(n-1);
            return result;
    }

    public static int memoizedFactorial( int n, int[] memo ){
        int result = 0;
        if ( ( n == 0  || n == 1  ) ) {
            return 1;
        }
        if ( memo[n] != 0 ) {
            return memo[n];
        } else {
            result = n * memoizedFactorial(n - 1, memo);
            memo[n] = result;
        }
        return result;



    }

}
