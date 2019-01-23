package main.com.practice.datastructures.stacks;

public class CharStack {

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
