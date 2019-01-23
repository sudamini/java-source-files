package com.practice.datastructures.linkedlists;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class UnsortedLinkedList implements ILinkedList{

    private Node<? extends Number> head;

    private static class Node<U extends Number> {
        U item; // data
        Node<U> next; // reference to next node. self referencing

        Node(U i_item) {
            this.item = i_item;
        }
    }

    public static void main (String[] args ) {
        UnsortedLinkedList ull = new UnsortedLinkedList();
        ull.create();
        //ull.print();
       // ull.insert(56.78);
        //ull.insert(60);
        //ull.print();
        //System.out.println ( "Size is: " + ull.size());
        //System.out.println ( "Node at index 3 = " +ull.get(3).item );
        //System.out.println ( ull.find( 60 ).item.intValue());
        //System.out.println ( ull.delete(30));
        //ull.print();
        //System.out.println ( ull.delete(60));
        //ull.print();
        //ull.insertAt(100,5);
        //ull.print();
        //System.out.println ( ull.delete(100));
       // ull.print();
        System.out.println ( "Is there a loop? " + ull.isLoop());

    }

    private boolean isLoop( ) {

        Node slow = head;
        Node fast = head.next.next;
        while (slow != null && fast != null && fast.next.next != null ) {
            if (slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    private void reverse( ){
        Node current = head;
        reverseRecursive( current );
    }
@Ignore
    private Node reverseRecursive( Node current ) {
        if ( current == null ) {
            return null;
        }
        if ( current.next == null ) {
            return current;
        }
        Node nextNode = current.next;
        current.next = null;
        Node rest = reverseRecursive( nextNode);
        return rest;
    }
    /*
    Add one node at a time, at the end of the list
     */
    @Override
    public boolean insert( Number data ) {
        Node<? extends Number> node = new Node<>( data );
        if ( isEmpty() ) {
            head = node;
            return true;
        }
        Node current = head;
        while ( current.next != null ) {
            current = current.next;
        }
        current.next = node;
        return true;
    }

    /*
        Add a given value just before the given 0-based index, shifting subsequent
        elements right as necessary to make room.
        Throws an integer exception if given index is not 0-size inclusive. If size is pased,
        appends to the end of the list.
        */
    @Override
    public boolean insertAt( Number value, int index ) {
        if ( index < 0 || index > ( size() + 1 ) ) {
            System.out.println ( "Index " + index + " out of range." );
            return false;
        }
        Node<? extends Number> newNode = new Node<>( value );
        Node current = head;
        for ( int i = 1; i < index-1; i++ ) {
            current = current.next;
        }
        // at this point, current is pointing at (index-1)st node.
        //insert just AFTER current.
        newNode.next = current.next;
        current.next = newNode;


        return true;
    }

    private boolean isIndexInvalid( int indx ) {
        return ( indx > size() || indx < 0 );
    }

    @Override
    public Node<? extends Number> get( int index ) {
        if ( isIndexInvalid( index ) ) {
            System.out.println ("Index " + index + " out of range." );
            return null;
        }
        Node<? extends Number> current = head;
        for ( int i = 1; i < index; i++ ){
            current = current.next;
        }
        return current;
    }

    @Override
    public Node<? extends Number> find( Number e ) {
        Node<? extends Number> current = head;
        while (current != null) {
            if (current.item.equals(e)) {
                return current;
            }
            current = current.next;
        }
        return current;
    }
    /*
    Delete a node with a given value from a linked list
     */
    @Override
    public boolean delete( Number e ) {
        boolean ret = false;
        Node current = head;
        while ( current!= null ) {
            if ( current.next.item.equals(e )) {
                Node new_next = current.next.next;
                current.next = new_next;
                return true;
            }
            current = current.next;
        }
        return ret;





    }

    @Override
    public int size() {
       int num_nodes = 0;
       Node current = head;
       while ( current != null ) {
           ++num_nodes;
           current = current.next;
       }
       return num_nodes;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /*
    Create a list with multiple nodes.
     */
    @Override
    public void create() {
        head = new Node<>(10);
        Node second = new Node(20);
        head.next = second;

        Node third = new Node(30);
        second.next = third;

        Node fourth = new Node(40);
        third.next = fourth;

        Node fifth = new Node(50);
        fourth.next = fifth;

        //loop
        fifth.next = third;

    }

    public void print() {
        System.out.println("Printing: ");
        Node<? extends Number> current = head;
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }
    }


}

