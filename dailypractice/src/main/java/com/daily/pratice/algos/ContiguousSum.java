package com.daily.pratice.algos;

/*
Given a list of integers and a number K, return which contiguous elements of the list sum to K.

For example, if the list is [1, 2, 3, 4, 5] and K is 9, then it should return [2, 3, 4].
 */

import java.util.ArrayList;
import java.util.List;

public class ContiguousSum {

    public static void main (String[] args ) {
        int[] array = new int[] {5,6,7,11,29};
        int sum = 30;
        contiguousSum( array, sum );
    }

    private static void contiguousSum( int[] inputArray, int sum ) {
        int result = 0;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            numbers.add(inputArray[i]);
            result = inputArray[i];
            for (int j = i + 1; j < inputArray.length; j++) {
                numbers.add(inputArray[j]);
                result = result + inputArray[j];
                if (result == sum) {
                    System.out.println("Result " + numbers);
                    break;
                }
                if (result > sum) {
                    numbers.clear();
                    break;
                }
            }

        }

    }
}
