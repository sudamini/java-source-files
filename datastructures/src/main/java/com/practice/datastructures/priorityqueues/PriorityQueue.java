package com.practice.datastructures.priorityqueues;

import java.util.*;

/*
Smaller number is more urgent. implementation based on heap.
 */
class PriorityQueue implements IPriorityQueue {

    private static final int DEFAULT_SIZE = 10;
    private static final int NULL_INDEX = 0;
    private static final int HEAD_INDEX = 1;

    private Node[] queue;
    private int current_size;

    private PriorityQueue() {
        queue = new Node[DEFAULT_SIZE];
        queue[NULL_INDEX] = null;
        current_size = 1;

    }

    private void printQueue() {
        for ( int i = 0; i < queue.length; i++ ) {
            if( Objects.nonNull ( queue[i] ))
                System.out.println( i + " = " + queue[i].toString() );
        }
    }

    class Node implements Comparator<Node> {
        String data;
        int priority;

        Node( String in_data, int in_priority ) {
            this.data = in_data;
            this.priority = in_priority;
        } // end constructor

        @Override
        public int compare( Node o1, Node o2) {
            int result = Integer.compare(o1.priority, o2.priority);
            if ( result < 0 ) {
                return -1;
            } else if ( result > 0 ) {
                return 1;
            } else {
                return 0;
            }
        } // end method.

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", priority=" + priority +
                    '}';
        }
    } // end class

    Node[] getQueue() {
        return queue;
    }

    void setQueue(Node[] queue) {
        this.queue = queue;
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        Node one = priorityQueue.new Node("z", 33);
        priorityQueue.add( one );
        Node two = priorityQueue.new Node( "a", 22);
        priorityQueue.add( two );
        Node three = priorityQueue.new Node( "b", 100);
        priorityQueue.add( three );
        Node four = priorityQueue.new Node( "c", 30);
        priorityQueue.add( four );
        Node five = priorityQueue.new Node( "f", 20);
        priorityQueue.add( five );
        Node six = priorityQueue.new Node( "g", 2);
        priorityQueue.add( six );
        Node seven = priorityQueue.new Node( "m", 1);
        priorityQueue.add(seven);
        System.out.println("Print before remove");
        priorityQueue.printQueue();
        priorityQueue.remove();
        System.out.println("Print after remove");
        priorityQueue.printQueue();
        priorityQueue.remove();
        System.out.println("Print after remove");
        priorityQueue.printQueue();
        priorityQueue.remove();
        priorityQueue.remove();
        System.out.println("Print after remove");
        priorityQueue.printQueue();
        priorityQueue.remove();
        System.out.println("Print after remove");
        priorityQueue.printQueue();
        priorityQueue.remove();
        System.out.println("Print after remove");
        priorityQueue.printQueue();
        priorityQueue.remove();
        System.out.println("Print after remove");
        priorityQueue.printQueue();


    } // end main

    private boolean checkSize() {
        int curr = current_size;
        return ++curr < DEFAULT_SIZE;
    }

    private void adjustPriorityAfterInsertion( Node e, int insert_indx ) {
       int parent_indx = insert_indx / 2;
       int compare_result;
       while ( parent_indx >=1 ) {
           compare_result = e.compare(queue[parent_indx],queue[insert_indx]);
           if ( compare_result > 0 ){
               swap( parent_indx, insert_indx );
               insert_indx = parent_indx;
           } else {
               break;
           }
           parent_indx = insert_indx / 2;
       }
    }

    private void swap( int parent_indx, int insert_indx ) {
        Node temp = queue[parent_indx];
        queue[parent_indx] = queue[insert_indx];
        queue[insert_indx] = temp;
    }
/*
1.Move the last element up to the start = index 1.
2.Swap it downward with its most urgent child
 */
    private void adjustPriorityAfterRemoval( Node[] queue ) {
            int last_node_indx = current_size;
            queue[HEAD_INDEX] = queue[last_node_indx]; // move last index to the head index.
            queue[last_node_indx] = null;
            int current_pointer = HEAD_INDEX;
            int compare_result,max_child_indx;
            int child1_indx, child2_indx;

            while ( current_pointer < current_size  && queue[current_pointer] != null ) {
                child1_indx = current_pointer*2;
                child2_indx = child1_indx + 1;
                max_child_indx = process( child1_indx, child2_indx );
                if ( max_child_indx == -1 ){
                    System.out.println("Queue finished.");
                    break;
                }
                compare_result = queue[current_pointer].compare(queue[current_pointer], queue[max_child_indx]);

                if ( compare_result == 1 ) {
                    swap(current_pointer, max_child_indx );
                    current_pointer = max_child_indx;
                } else {
                    break;
                    }
                }
            } // end method

    private int process( int child1, int child2 ){
        int ret = -1;
        if ( queue[child1] == null ){
            System.out.println("Queue finished.");
            return ret;
        } else if ( queue[child2] == null || queue[child1].priority < queue[child2].priority ) {
           ret = child1;
        } else if ( queue[child1].priority > queue[child2].priority ) {
            ret = child2;
        }
        return ret;
    }

    @Override
    public boolean add(PriorityQueue.Node e) {
        int insert_index;
        if ( current_size == 1 ) { // queue does not have meaningful data. add to head node.
            queue[HEAD_INDEX] = e; // we keep index 0 empty in heap.
            ++current_size;
            return true;
        } else {
            if ( checkSize() ) {
                insert_index = current_size;
                queue[insert_index] = e;
                adjustPriorityAfterInsertion( e, insert_index );
                ++current_size;
                return true;
            }
        }
        return false;
    }

    @Override
    public PriorityQueue.Node remove() {
        Node ret = queue[1];
        queue[1] = null;
        --current_size;
        adjustPriorityAfterRemoval( queue );
        return ret;
    }

    @Override
    public PriorityQueue.Node peek() {
        return queue[1];
    }
}
