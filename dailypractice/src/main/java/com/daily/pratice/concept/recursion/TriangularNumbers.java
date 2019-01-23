package com.daily.pratice.concept.recursion;

/*
Calculates Nth number in a Pythagorean series -
1,3,6,10,15,21
Nth number is calculated by adding N to the previous number.
 */

import java.util.Scanner;

public class TriangularNumbers {


    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            n = sc.nextInt();
            if ( n == 0 ) {
                break;
            }
            System.out.println(" Iterative solution " + triangular(n));
            System.out.println(" Recursive solution " + recursiveTriangular(n));
        }
    }

    private static int triangular( int input ) {
        int result = 0;

        while ( input > 0 ) {
            result = result + input--;
        }
        return result;
    }

    private static int recursiveTriangular( int input ){
        int result;
        if ( input == 1 ) {
            return 1;
        } else {
            result = input + recursiveTriangular(input - 1 );
        }

        return result;
    }
}
