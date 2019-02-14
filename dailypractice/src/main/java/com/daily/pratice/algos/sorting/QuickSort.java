package com.daily.pratice.algos.sorting;

import java.util.Arrays;
import java.util.Random;

final class QuickSort {
    private static final int MAX_SIZE = 6;

    public static void main( final String[] args) {
        int[] arr = new int[MAX_SIZE];
        populate(arr); // populate array with random numbers with upper bound of 100.
        System.out.println("Before sort " + Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println("After sort " + Arrays.toString(arr));
    }
    private static void populate( int[] arr ){
        int current_size = 0;
        Random rand = new Random();
        while( current_size < MAX_SIZE ){
            arr[current_size++] = rand.nextInt(100);
        }
    }
    private static void swap(int[] arr, int li, int ri){
        int temp = arr[li];
        arr[li] = arr[ri];
        arr[ri] = temp;
    }

    /**
     * Recursive method quickSort.
     * @param arr
     * @param left
     * @param right
     */
    private static void quickSort( int[] arr, int left, int right ){
        if( left > right ) { // base case. if array segment is invalid, return immediataely.
            return;           // alternatively, if array length is 1, it is already sorted, so you can use that condition as well.
        } else {
            int partition_indx = partitionForQ(arr, left, right);
            quickSort(arr, left, partition_indx - 1);
            quickSort(arr, partition_indx + 1, right);
        }
    }
    private static int partitionForQ( int[] arr, int start, int end ){
        int pivot = arr[end]; // pivot is at the end of the given array segment, rightmost element.
        int partition_indx = start;

        for( int j = start; j <= end-1; j++ ){
            if(arr[j] <= pivot ){
                swap(arr, j,partition_indx);
                ++partition_indx;
            }
        }
        swap(arr, partition_indx, end);
        return partition_indx;
    }
}
