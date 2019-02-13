package com.daily.pratice.hackerrank;

public class JumpingOnClouds {

    public static void main( String args[] ) {
        jumpingOnClouds(new int[]{0, 0, 0, 0, 1, 0});
    }
    static int jumpingOnClouds( int[] c ) {
        int jumps = 0;
        int n = 0;
        while( n < c.length )  {
            if( ((n+2) <= c.length-1 ) && c[n+2] != 1 ) {
                n = n + 2;
                jumps = jumps + 1;
                continue;
            } else if ( ((n+1) <= c.length-1 )&&  c[n+1] != 1 ){
                n = n + 1;
                jumps = jumps + 1;
                continue;
            }
            else {
                ++n;
            }
        }
        System.out.println("Total jumps " + jumps );
        return jumps;
    }
}
