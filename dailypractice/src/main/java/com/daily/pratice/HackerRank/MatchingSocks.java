package com.daily.pratice.hackerrank;

import java.util.HashSet;
import java.util.Set;

public class MatchingSocks {

   static int[] arr = new int[]{1,2,1,2,1,3,2};
   public static void main ( String[] args ) {
       Set<Integer> socks = new HashSet<>();
       int pair = 0;
       boolean result;
       for (int i : arr ) {
           result = socks.add(i);
           if ( !result ) {
              ++pair;
              socks.remove(i);
           }
       }

       System.out.println (" Pairs " + pair );
   }


}
