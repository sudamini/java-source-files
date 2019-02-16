package com.daily.pratice.concept.basic_concepts;

final class ShiftOperators {

    public static void main(final String[] args) {
        int a = 60;
        int b = -60;

        System.out.println(a + " in binary format:  " + Integer.toBinaryString(a));
        System.out.println(b + " in binary format:  " + Integer.toBinaryString(b));

        //signed right shift of a positive number
        int c = a >> 1;
        System.out.println("signed right shift = divide by a power of 2 " + c );
        System.out.println("60 >> 1 = " +Integer.toBinaryString(c)); //60

        //signed right shift of a negative number
        c = b >> 1;
        System.out.println("signed right shift = divide by a power of 2 " + c );
        System.out.println("-60 >> 1 = " +Integer.toBinaryString(c)); //-60

        //unsigned right shift of a negative number
        c = b >>> 1;
        System.out.println("unsigned right shift = divide by a power of 2 " + c );
        System.out.println("-60 >>> 1 = " +Integer.toBinaryString(c)); //-60

        //signed left shift of a positive number
        c = a << 1;
        System.out.println("signed left shift = multiply by a power of 2 " + c );
        System.out.println("60 << 1 = " +Integer.toBinaryString(c)); //60

        //signed left shift of a negative number
        c = b << 1;
        System.out.println("signed left shift = multiply by a power of 2 " + c );
        System.out.println("-60 << 1 = " +Integer.toBinaryString(c)); //-60



    }
}
