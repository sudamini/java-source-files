package com.practice.datastructures.graphs;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

class Graph {
    private final int MAX_VERTICES = 9;
    private Vertex[] vertexArray;
    private int[][] adjMat;
    private int current_vertex_num;
    private Stack<Integer> stack;
    private Queue<Integer> queue;

    Graph( String searchType ) {
        this(); // call default constructor
        if ( searchType.equals("BFS")) {
            queue = new ArrayBlockingQueue<>(MAX_VERTICES);
        } else {
            stack = new Stack<>();
        }
    } // end constructor

    private Graph() {
        vertexArray = new Vertex[MAX_VERTICES];
        adjMat = new int[MAX_VERTICES][MAX_VERTICES];
        current_vertex_num = 0;
        for( int i = 0; i < MAX_VERTICES; i++ ) {
            for (int j = 0; j < MAX_VERTICES; j++) {
                adjMat[i][j] = 0;
            }
        }
    } // end default constructor

    void addVertex( String  label ) {
        if ( !isFull() ) {
            Vertex vertex = new Vertex( label );
            vertexArray[current_vertex_num] = vertex;
            ++current_vertex_num;
        } else {
            System.out.println ("Vertex array full. Cannot add a new vertex");
        }

    }

    private boolean isFull() {
        return (  current_vertex_num == MAX_VERTICES );
    }

    void addEdge( int from_vertex, int to_vertex ) {
        if ( checkSize( from_vertex, to_vertex ) ) {
            adjMat[from_vertex][to_vertex] = 1;
        } else {
           System.out.println ("Cannot add edge from "+from_vertex+ " to "+to_vertex );
        }
    }

    private int getEdge( int from_vertex, int to_vertex ) {
        int ret = -1;
        if ( checkSize( from_vertex, to_vertex ) ) {
            ret =  adjMat[from_vertex][to_vertex];
        } else {
            System.out.println ("Cannot get edge from "+from_vertex+ " to "+to_vertex );
        }
        return ret;
    }

    private boolean checkSize( int from, int to ){
        return ( from <= MAX_VERTICES -1 && to <= MAX_VERTICES - 1 );
    }


    void breadthFirstSearch( int startingVertex ) {
        queue.add(startingVertex);
        vertexArray[startingVertex].isVisited = true;
        System.out.println ( "Visited " +startingVertex );
        int currentVertex;
        while (!queue.isEmpty()) {
            currentVertex  = queue.remove();
            List<Integer> adjacentVertices = getAdjacentUnvisitedVertices(currentVertex);
            for (int v : adjacentVertices) {
                vertexArray[v].isVisited = true;
                queue.add(v);
                System.out.println ( "Visited " +v );
            }
        }
    }

    void depthFirstSearch( int startingVertex ) {
        int currentVertex = startingVertex;
        process( currentVertex );
        int adjacentUnvisited;
        while ( !stack.isEmpty() ) {
            adjacentUnvisited = getAdjacentUnvisitedVertex(stack.peek() );
            if ( adjacentUnvisited == -1 ) {
                stack.pop();
            } else if ( adjacentUnvisited != -1 ) {
                process(adjacentUnvisited);
            }
        }

    }

    private void process ( int current ) {
        while ( current != -1 && !vertexArray[current].isVisited ) {
            stack.push(current);
            vertexArray[current].isVisited = true;
            System.out.println ("Visited " + current );
            current = getAdjacentUnvisitedVertex(current);
        }
    }


    private List<Integer> getAdjacentUnvisitedVertices ( int vertex ) {
        List<Integer> returnList = new ArrayList<>();
        for (int k = 0; k < MAX_VERTICES; k++) {
            if (adjMat[vertex][k] == 1 && !vertexArray[k].isVisited) {
                returnList.add(k);
            }
        } // end for
        return returnList;
    } // end method

    /*
    public void breadthFirstSearchRecursive( int startingVertex ) {

    } */

    private int getAdjacentUnvisitedVertex ( int i) {
        int ret = -1;
        for ( int k = 0; k < MAX_VERTICES; k++ ) {
            if ( adjMat[i][k] == 1 && !vertexArray[k].isVisited)  {
               ret = k;
               break;
            }
        }
        return ret;
    }


    void printAdjacencyMatrix() {

        System.out.println("The adjacency matrix for the given graph is: ");
        System.out.print("  ");
        for (int i = 0; i < MAX_VERTICES; i++)
            System.out.print(i + " ");
        System.out.println();

        for (int i = 0; i < MAX_VERTICES; i++)
        {
            System.out.print(i + " ");
            for (int j = 0; j < MAX_VERTICES; j++)
                System.out.print(this.getEdge(i, j) + " ");
            System.out.println();
        }

    }
    }



