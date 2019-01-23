package com.daily.pratice.algos.sorting;

/*
Bubble sort is slow but conceptually simplest sorting algorithm.
The biggest items bubble up towards highter end of the array
O(n^2)
 */

import java.util.Arrays;

public class BubbleSort {

    public static void main ( String[] args ) {
        int[] inputArray = new int[] {5,2,4,6,1,3};
        System.out.println ( Arrays.toString(performBubbleSort ( inputArray )));
    }
    private static int[] performBubbleSort ( int[] arrayToBeSorted ) {

        int outer = arrayToBeSorted.length - 1;
        int temp;
        while ( outer >= 0 ) { // n times

            for (int inner = 0; inner < outer; ++inner) {
                if (arrayToBeSorted[inner] > arrayToBeSorted[inner + 1]) {
                    temp = arrayToBeSorted[inner];
                    arrayToBeSorted[inner] = arrayToBeSorted[inner + 1];
                    arrayToBeSorted[inner + 1] = temp;
                }

            }
            --outer;
        }
        return arrayToBeSorted;
    }
}
