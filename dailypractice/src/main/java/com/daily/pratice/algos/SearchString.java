package com.daily.pratice.algos;
/*

KMP Pattern matching algorithm
Given text string t and pattern string p - does p exist in t and if yes, give indices.
 */

import java.util.*;

public class SearchString {
    private static final String INPUTSTRING = "INPUT";
    private static final String MATCHSTRING = "MATCH";
    private static final List<Integer> inputIdx = new LinkedList<>();
    private static final List<Integer> matchIdx = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString, searchString;
        while (true) {
            inputString = sc.next();
            searchString = sc.next();
            //System.out.println("Matching indices " + searchForSubstring(inputString, searchString));
            System.out.println("Matching indices " + patternMatching(inputString, searchString));
            if (sc.next().equalsIgnoreCase("end")) {
                break;
            }
        }
    }

    private static boolean patternMatching ( String text, String pattern ) {
        Map<String, Integer> result = new HashMap<String,Integer>();
        int textIndex = 0, patternIndx = 0;
        boolean restart = false;
        boolean matchFound = false;

        while ( textIndex >= 0 && textIndex < text.length() && patternIndx >= 0 && patternIndx < pattern.length() ) {
            if ( restart ) {
                patternIndx = 0;
                restart = false;
            }
            if ( text.charAt(textIndex ) == pattern.charAt(patternIndx ))  {
                ++textIndex;
                ++patternIndx;
                matchFound = true;
            } else {
                ++textIndex;
                restart = true;
                matchFound = false;
            }
        }
        return matchFound;

    }

    private static Map<String, List<Integer>> searchForSubstring(String in, String search) {
        System.out.println ("Input to method " + in + ", " + search );
        boolean matchFound;
        boolean restart;
        char[] inputCharArr = in.toCharArray();
        char[] searchCharArr = search.toCharArray();
        int j = 0;
        Map<String, List<Integer>> results = new HashMap<>();

        // if match is found, increment j and continue loop
        for (int i = 0; i < inputCharArr.length-1; i++) {
            if ( inputCharArr[i] == searchCharArr[j]) {

                inputIdx.add(i);
                results.put(INPUTSTRING, inputIdx );
                matchIdx.add(j);
                results.put(MATCHSTRING,  matchIdx );
                if ( j < searchCharArr.length-1 ) {
                    ++j;
                }
                matchFound = true;
                continue;
            } else {
                matchFound = false;
            }
            if ( !matchFound && j != 0 ) {
                j = 0;
                restart = true;
                if( inputCharArr[i] == searchCharArr[j] ) {
                    if ( restart ) {
                        inputIdx.clear();
                        matchIdx.clear();
                        restart = false;
                    }
                    inputIdx.add(i);
                    results.put(INPUTSTRING, inputIdx );
                    matchIdx.add(j);
                    results.put(MATCHSTRING,  matchIdx );
                    if ( j < searchCharArr.length-1 ) {
                        ++j;
                    }
                }
            }
        }
        return results;
    }
}
