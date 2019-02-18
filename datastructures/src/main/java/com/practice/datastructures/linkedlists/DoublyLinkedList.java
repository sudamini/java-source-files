package com.practice.datastructures.linkedlists;

final class DoublyLinkedList {
    private Node head;

    @Override
    public String toString() {
        Node temp = head;
        StringBuilder list = new StringBuilder();
        while(temp != null ) {
            list = list.append( temp.value + "->");
            temp = temp.next;
        }

        return list.toString();
    }

    private static class Node {
        int value;
        Node next;
        Node previous;

        private Node( int value ) {
            this.value = value;
        }
    }

    private void addFirst( int value ){
        head = new Node(value);
    }
    private void addLast(Node n){
        Node temp = head;
        while( temp.next != null ){
            temp = temp.next;
        }
        temp.next = n;
        n.previous = temp;
        n.next = null;

    }
    private void removeFirst(){
        head = head.next;
        head.previous = null;
    }

    private void removeLast(){
        Node temp = head;
        while( temp.next != null ){
            temp = temp.next;
        }
        temp.previous.next = null;
        temp.previous = null;
    }
    private boolean contains(int val){
        if( head.value == val ){
            return true;
        } else {
            Node temp = head;
            while (temp != null) {
                if( temp.value == val ){
                    return true;
                } else {
                    temp = temp.next;
                }
            }
        }
        return false;
    }

    private void remove(int n) {
        if (!contains(n)) {
            System.out.println("List does not contain given node " + n);
        } else {
            if ( head.value == n ) {
                removeFirst();
            } else {
                Node temp = head;
                while (temp.value != n ){
                    temp = temp.next;
                }
                temp.previous.next = temp.next;
                temp.next.previous = temp.previous;
            }
        }
    }

    public static void main( final String[] args ){
        int value = 11;
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(value);
        Node n = new Node(18);
        list.addLast(n);
        n = new Node(22);
        list.addLast(n);
        n = new Node(0);
        list.addLast(n);
        n = new Node(1);
        list.addLast(n);
        n = new Node(100);
        list.addLast(n);
        n = new Node(81);
        list.addLast(n);
        n = new Node(17);
        list.addLast(n);
        n = new Node(27);
        list.addLast(n);
        System.out.println(list.toString());
        list.remove(1);
        System.out.println(list.toString());
        list.remove(18);
        System.out.println(list.toString());
        list.removeLast();
        System.out.println(list.toString());
        list.remove(21);



    }

}
