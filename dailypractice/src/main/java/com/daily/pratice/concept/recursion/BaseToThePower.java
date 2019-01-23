package com.daily.pratice.concept.recursion;

public class BaseToThePower {

    public static void main( String[] args ) {
        int base = 5;
        int power = 0;
        System.out.println ( "Answer " + baseToThePower( base, power ) );
    }

    static int baseToThePower ( int base, int power ) {
        int answer = 0;
        //base case
        if ( power == 0 ) {
            return 1;
        } else {
            answer = 2 * baseToThePower( base, --power );
        }
        return answer;
    }
}
