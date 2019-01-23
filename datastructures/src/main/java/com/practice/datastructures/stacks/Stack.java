package main.com.practice.datastructures.stacks;

import java.util.Random;
import java.util.Arrays;

public class Stack {

    /* Default maximum size of array based stack implementation */
    private static final int MAX_SIZE = 20;
    /* Default size that will be populated */
    private static final int POPULATE_SIZE = 10;
    /* Default value of top */
    private static int top = -1;
    /* Only one instance will get created */

    private static Stack uniqueInstance = new Stack();

    private int stack_arr[];

    // private constructor to prevent object creation from outside of this class.
    private Stack() {
        stack_arr = new int[MAX_SIZE];
        System.out.println ( "Created array-based stack of size " + MAX_SIZE );
    }

    /* Returns a reference to a Stack object.
       This uses singleton-style double checked locking to create a single stack implementation. */
    public static Stack getInstance() {
        if ( uniqueInstance == null ) {
            synchronized (Stack.class) {
                if ( uniqueInstance == null ) { // double checked locking
                    uniqueInstance = new Stack();
                }
            }
        }
        return uniqueInstance;
    }

    /* pushes a new item onto the top of stack, updates top_of_stack value */
    public void push ( int newItem ) {
           if ( isFull() ) {
            System.out.println( "Stack is full. Cannot push another item" );
            return;
        }
        ++top;
        stack_arr[top] =  newItem; //top now points to the new item.
    }

    /* If the stack does not contain any data, it will populate POPULATE_SIZE number of items on stack. */
    public  void populate() {
        if ( isFull() ) {
            System.out.println ( " Stack contains data. Use push() method to push more items");
        }
        else if (top == -1 ) { //populate
            Random rand = new Random(100);
            for( int i = 0; i < POPULATE_SIZE; i++ ) {
                stack_arr[i] = rand.nextInt(100);
                ++top;
            }
            System.out.println ("Stack populated " + Arrays.toString(stack_arr));
        }
    }
    /* return value pointed by top_of_stack */
    public  int pop () {
        if ( isEmpty() ) {
            System.out.println("Stack is empty, no items to pop");
            return top;
        }
        return stack_arr[top--];
    }

    /* prints stack */
    public  void printStack() {
        System.out.println ( Arrays.toString(stack_arr) );
    }

    /* create new stack */
    public  void newStack () {
        Stack.getInstance();
    }

    public  int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty, no items to peek.");
            return top;
        }
        return stack_arr[top];
    }

    public boolean isEmpty() {
        return ( top == -1);
    }

    public boolean isFull(){
        return ( top == MAX_SIZE - 1 );
    }
}
