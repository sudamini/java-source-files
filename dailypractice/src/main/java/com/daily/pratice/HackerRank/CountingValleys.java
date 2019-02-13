package com.daily.pratice.hackerrank;

import java.util.Scanner;

public class CountingValleys {

    public static void main( String[] args){
        //countingValleys(8,"UDDDUDUU");
        countingValleys(12,"DDUUDDUDUUUD");
    }

    static int countingValleys(int n, String s) {
        int up=0,down = 0;
        boolean seaLevel = true;
        boolean valley = false;
        boolean mountain = false;
        int no_of_valleys = 0;
        for( int j = 0; j < n; j++ ){
            if(String.valueOf(s.charAt(j)).equals("U")){
                ++up;
            } if(String.valueOf(s.charAt(j)).equals("D")){
                ++down;
            }
            if( up==down ){
                seaLevel = true;
                valley = false;
                mountain = false;
            } else if( down > up && seaLevel ){
                ++no_of_valleys;
                valley = true;
                seaLevel=false;
                mountain=false;
            } else {
                mountain = true;
                valley = false;
                seaLevel = false;
            }
        }
        System.out.println( "No of valleys " + no_of_valleys );

        return no_of_valleys;
    }
}
