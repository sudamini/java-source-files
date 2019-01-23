package com.daily.pratice.concept.recursion;

import java.util.Arrays;

public class Fibonacci {

    public static void main (String args[] ) {
        int n = 5;
        System.out.println ("Recursive Fibonacci of  " + n + " is " +recursiveFibonacci( n ) );
        Integer[] memo = new Integer[]{ 0, 0, 0, 0, 0, 0 };
        System.out.println (Arrays.toString(memo ) );
        System.out.println ("Memoized Fibonacci of " + n + " is " + fibonacciWithMemoization( n, memo ) );
        System.out.println (Arrays.toString(memo ) );
    }

    public static int recursiveFibonacci ( int n ) {
        if ( n == 1 || n == 2 ) {
            return 1;
        }
        int fib = recursiveFibonacci( n -1 ) + recursiveFibonacci ( n - 2 );
        return fib;
    }

    public static int fibonacciWithMemoization( int n, Integer[] memo ) {
        int result;
        if ( !memo[n].equals(0 )) {
            return memo[n];
        }
        if ( n == 1 || n == 2 ){
            memo[n] = new Integer(1);
            result = memo[n];
        } else {
            result = fibonacciWithMemoization(n-1, memo ) + fibonacciWithMemoization( n -2, memo );
            memo[n] = result;
        }
        return result;
    }
}
