package com.daily.pratice.algos.sorting;

import java.util.Arrays;

/*
Take a pass at candidates to be sorted and select the smallest candidate, swap it with leftmost candidate.
Since you select the smallest candidate, its called SELECTION sort.
 */
public class SelectionSort {
    //5,2,4,6,1,3
    //
    static int[] arrayToBeSorted = new int[] { 10,8,4,11,3,12,1,0 };

    public static void main (String[] args ) {
        System.out.println ( Arrays.toString( selectionSort( arrayToBeSorted )));
    }

    static int[] selectionSort ( int[] inputArray ) {
        int length = inputArray.length;
        int min, minSoFar,temp;
        for ( int outer = 0; outer < length; ++outer  ) {
            min = outer;
            for ( int inner = outer + 1; inner < length; ++inner ) {
                minSoFar = inputArray[min];
                if ( minSoFar  > inputArray[inner] ) {
                    min = inner;
                }
            }
            if ( min != outer ) {
                temp = inputArray[outer];
                inputArray[outer] = inputArray[min];
                inputArray[min] = temp;
            }
        }
        return inputArray;
    }



}
