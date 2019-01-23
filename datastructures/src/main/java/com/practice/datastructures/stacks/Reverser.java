package main.com.practice.datastructures.stacks;

/* This class makes use of a character array to reverse a string
*
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Reverser {

    static String inputStr;
    static String outputStr;

    // saves all characters of input string in character array. provides stack manipulation methods
    private class CharStack {
        char charArray[];
        int top;
        char ret;

        CharStack( char arr[] ){
            charArray = arr;
            top = ( charArray.length - 1 );
            ret = 'a';
        }

        char pop() {
            if (!isEmpty()) {
                ret =  charArray[top--];
            }
            return ret;
        }

        char peek() {
            if ( !isEmpty() ) {
                ret = charArray[top];
            }
            return ret;
        }

        void push( char in ) {
            if (!isFull() ) {
                charArray[++top] = in;
            }

        }
        boolean isFull() {
            return top == (charArray.length-1);
        }

        boolean isEmpty() {
            return top == -1;
        }
    }

    Reverser ( String input ) {
        inputStr = input;
    }


    public static void main ( String args[] ) {
        String input;
        while (true) {
            System.out.println("Enter a string: ");
            System.out.flush();
            input = getString();
            if (input.equals("")) {
                break;
            }
            Reverser reverser = new Reverser( input );
            System.out.println("Reversed " + reverser.reverse());
        } // end while
    }// end main

    public static String getString() {
        String s = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            s = br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public String reverse() {
        CharStack stack = new CharStack(inputStr.toLowerCase().toCharArray());
        System.out.println ( Arrays.toString( stack.charArray ));
        String retStr = "";

        while ( !stack.isEmpty() ) {
            retStr = retStr + stack.pop();
        }
        return retStr;
    }
} // end class
