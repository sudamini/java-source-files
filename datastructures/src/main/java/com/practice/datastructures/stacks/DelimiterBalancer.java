package main.com.practice.datastructures.stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.HashSet;

public class DelimiterBalancer {

    private static String inputString;

    private static Set<Character> opening_delimiters = new HashSet<Character>();
    private static Set<Character> closing_delimiters = new HashSet<Character>();

    static {
        opening_delimiters.add('{');
        closing_delimiters.add('}');
        opening_delimiters.add('[');
        closing_delimiters.add(']');
        opening_delimiters.add('(');
        closing_delimiters.add(')');
    }

    private class CharStack {
        char charArray[];
        int top = -1; // maximum occupied index in a stack
        int default_size; // maximum size of a stack

        /* constructor to create an array given input string */
        private CharStack ( String inputString, int def_size ) {
            charArray = new char[def_size];
            populate(inputString.toCharArray());
        }
        /* constructor to create an array given an array of characters */
        private CharStack ( char[] array, int def_size ) {
            charArray = new char[def_size];
            populate(array);
        }

        private CharStack ( int def_size ) {
            charArray  = new char[def_size];
        }
        // remaining elements of charArray will contain a '0' these will be replaced as client calls push() method
        private void populate(char arr[]) {
            for (int i = 0; i < arr.length; i++) {
                charArray[i] = arr[i];
            }
            top = ( arr.length - 1 );
        }

        /* will return false if a new character cannot be pushed on the stack. */
        private boolean push( char c) {
            boolean ret = false;
            if ( !isFull() ){
                charArray[++top] = c;
                ret = true;
            }
            return ret;
        }
        /* caller will deal with a special return value of '!' if stack is empty */
        private char pop() {
            char ret = '!';
            if (!isEmpty()) {
                ret = charArray[top--];
            }
            return ret;
        }
        private boolean isFull() {
            boolean ret = false;
            if ( charArray.length == ( default_size - 1 ) ) {
                ret = true;
            }
            return ret;
        }
        private boolean isEmpty() {
            boolean ret = false;
            if ( top == -1 ){
                ret = true;
            }
            return ret;
        }
        /* client will handle return value */
        private char peek() {
            char ret = 'a';
            if(!isEmpty()) {
                ret = charArray[top];
            }
            return ret;
        }

    }

    public static void main ( String args[] ) {

        while (true) {
            System.out.println("Enter a string: ");
            System.out.flush();
            inputString = getString();
            if (inputString.equals("")) {
                break;
            }
            //OuterClass.InnerClass innerObject = outerObject.new InnerClass();
            DelimiterBalancer balancer = new DelimiterBalancer();
            balancer.balance_new();

        } // end while
    }// end main

    private static String getString() {
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

    private void balance_new( ) {
        DelimiterBalancer.CharStack stack = this.new CharStack (  inputString.length() + 20 );
        char[] charArr = inputString.toCharArray();
        char temp;
        for ( char c:charArr ) {
            if ( opening_delimiters.contains(c)){
                stack.push(c);
            }
            if ( closing_delimiters.contains(c)) {
                temp = stack.pop();
                if ( matches ( temp, c)){
                    System.out.println ( "Balanced " + temp + " : " + c );
                } else {
                    System.out.println ( "Not Balanced " + temp + " : " + c );
                }
            }
        }
    }

    private boolean matches ( char opening_delimiter, char closing_delimiter ) {
        boolean ret = false;
        if ( opening_delimiter == '{' && closing_delimiter == '}') {
            ret = true;
        } else if( opening_delimiter == '(' && closing_delimiter == ')' ){
            ret = true;
        } else if ( opening_delimiter == '[' && closing_delimiter == ']') {
            ret = true;
        }
        return ret;
    }
}
