package com.daily.pratice.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class CheckForDigitInRange {

    public static void main(String[] args){
        int digit = 1;
        int lower = 0;
        int upper = 20;
        System.out.println("Numbers with a " + digit + " present in the range " + lower + " - " + upper + checkForDigitsInRange( digit, lower, upper));

    }

    public static String checkForDigitsInRange( int digit, int lower, int upper ) {
        List<String> result = new ArrayList<>();
        String strNum;
        String strDigit = String.valueOf(digit);
        for( int i = lower; i <= upper; i++ ){
            strNum = String.valueOf(i);
            for( int j = 0; j < strNum.length(); j++ ) {
                if( String.valueOf(strNum.charAt(j)).equals(strDigit)) {
                    result.add(strNum);
                    break;
                }
            }
        }
        System.out.println(result.toString());
        return result.toString();
    }
}


