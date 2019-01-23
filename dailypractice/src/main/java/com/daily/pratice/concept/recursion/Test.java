package com.daily.pratice.concept.recursion;

public class Test {

    public static void main ( String[] args ) {
       System.out.println( mystery(348) );
    }
    static int mystery( int n ) {
        System.out.println ( "Input: " + n );
        if( n < 10 ) {
            return ( 10 * n ) + n;
        } else {
            System.out.println ( "value of n in else block: " + n );
            int a = mystery( n / 10 );
            int b = mystery(n % 10 );
            return ( 100 * a ) + b;
        }
    }


}
