package com.daily.pratice.concept.recursion;

public class PrintStars {

    public static void main ( String[] args ) {
        printStars( 10 );
    }

    static void printStars( int n ) {
        if ( n == 0 ) {
            return;
        } else {
            System.out.print("*" );
            printStars(--n);
        }
    }
}
