package com.daily.pratice.algos.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main (String[] args) {
        //5,2,4,6,1,3
        int[] array_to_be_sorted = new int[] { 9,8,0,6,1};
        System.out.println ( Arrays.toString( performInsertionSort( array_to_be_sorted ) ) );
    }

    static int[] performInsertionSort( int[] input ) {
        int inner, outer, temp;
        for ( int i = 1; i < input.length; i ++ ) {
            inner = i;
            outer = i;
            temp = input[outer];
            while ( ( inner - 1 ) >= 0 && input[inner-1] > temp )  {
                input[inner] = input[inner-1];
                --inner;
            }
            // this takes care of base case, when inner = 0;
            input[inner] = temp;

        }
        return input;
    }
}
