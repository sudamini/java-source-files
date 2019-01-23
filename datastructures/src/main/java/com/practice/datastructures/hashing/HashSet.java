package com.practice.datastructures.hashing;

import java.util.Objects;

class HashSet {

    private HashNode[] hashNodes;
    private int current_size;

    private static final int DEFAULT_SIZE = 10;

    private class HashNode {
        HashNode next;
        int value;

        HashNode( int in_val ) {
            this.value = in_val;
        }

        @Override
        public String toString() {

            return  "" + value;
        }
    }

    private HashSet() {
        hashNodes = new HashNode[DEFAULT_SIZE];
        current_size = 0;
    }

    private void print() {
        HashNode current;
        boolean addNewLine = false;
        int num_linked_node;
        for ( int i = 0; i < DEFAULT_SIZE; ++i ) {
            current = hashNodes[i];
            num_linked_node = 0;
            if( addNewLine )
                System.out.println("");
            if( Objects.nonNull(current))
                System.out.print(i + "");
            else
                System.out.println(i + "->" );

            while( current != null ) {
                System.out.print( "->"+current.toString());
                ++num_linked_node;
                current = current.next;
            }
            if(num_linked_node > 0 ){
                addNewLine = true;
            } else {
                addNewLine = false;

            }

        }
    }

    private void add( int value ) {
        if ( contains( value )) {
            return;
        }
        int hash = hashCode( value );
        HashNode newNode = new HashNode( value );
        newNode.next = hashNodes[hash];
        hashNodes[hash] = newNode;
        ++current_size;
    }

    private int hashCode( int val ) {
        return Math.abs(val) % DEFAULT_SIZE;
    }

    private void clear() {
        hashNodes = new HashNode[DEFAULT_SIZE];

    }
    private boolean contains( int value ) {
        int hash = hashCode( value );
        HashNode current = hashNodes[hash];
        while( current != null ) {
            if( current.value == value ) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private boolean remove( int value ) {
        if( !contains( value )) {
            System.out.println( "Does not contain " + value );
            return false;
        }
        int hash = hashCode( value );
        HashNode current = hashNodes[hash];

        while( current != null ) {

            if( current.value == value ) {
                hashNodes[hash] = current.next;
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    public static void main ( String[] args ) {
        HashSet test = new HashSet();
        test.add(10);
        test.add(10);
        test.add(15);
        test.add(25);
        test.add(49);
        test.add(50);
        test.add(1);
        test.add(33);
        test.add(-22);
        test.add(88);
        test.add(98);
        test.add(44);
        test.add(66);
        test.add(77);
        test.add(59);

        test.remove(59);


        test.print();
    }


}
