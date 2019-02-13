package com.daily.pratice.hackerrank;

import java.util.Arrays;

public class ArrayLeftRotation {

    public static void main(String args[]){
        rotLeft(new int[] {1,2,3,4,5}, 3);
    }

    static int[] rotLeft(int[] arr, int rotations) {
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            result[(i-rotations+arr.length) % arr.length ] = arr[i];
        }

        System.out.println(Arrays.toString(result));
        return result;
    }
}
