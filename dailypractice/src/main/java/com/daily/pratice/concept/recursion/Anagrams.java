package com.daily.pratice.concept.recursion;

import java.util.*;

/*
This is a backtracking algorithm where you make a choice and if it doesnt work, you discard it and make
another choice
 */
public class Anagrams {

    private static Set<List<Character>> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {
            input = sc.next();
            if (input.equals("")) {
                break;
            }
            List<Character> chosenStringChars = new ArrayList<>();
            List<Character> givenStringChars = new ArrayList<>();
            char[] charArray = input.toCharArray();
            for (char c:charArray) {
                givenStringChars.add(c);
            }
            answer = new HashSet<>();
            recursiveAnagramHelper(givenStringChars, chosenStringChars);
            System.out.println ("Total anagrams found " +answer.size());
        }
    }


    private static void recursiveAnagramHelper(List<Character> inputStrChar, List<Character> chosenStr) {

        if (inputStrChar.size() == 0) {

            if ( answer.contains(chosenStr )) {
                System.out.println ("Already contains " + chosenStr );
            } else {
                answer.add(chosenStr);
            }

        } else {
            //choose, explore, un-choose
            for (int i = 0; i < inputStrChar.size(); i++) {
                //choose
                char c = inputStrChar.get(i);
                chosenStr.add(c);
                inputStrChar.remove(i);

                //explore
                recursiveAnagramHelper(inputStrChar, chosenStr);
                //un-choose
                inputStrChar.add(i, c);
                chosenStr.remove(chosenStr.size() - 1);

            }
        }
    }
}





