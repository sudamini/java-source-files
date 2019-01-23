package com.practice.datastructures.graphs;

import java.util.HashMap;
import java.util.Map;

public class Search {

    public static void main(String[] args) {

        Graph graph = new Graph("BFS");
        //BFS
        populate(graph);
        graph.printAdjacencyMatrix();
        graph.breadthFirstSearch(0);

        //DFS
        graph = new Graph("DFS");
        populate(graph);
        graph.printAdjacencyMatrix();
        graph.depthFirstSearch(0);


    }

    public static void populate( Graph graph ) {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");

        //A -> B,C,D,E
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);

        //B -> A, F
        graph.addEdge(1, 0);
        graph.addEdge(1, 5);

        //C -> A
        graph.addEdge(2, 0);

        //D -> A,G
        graph.addEdge(3, 0);
        graph.addEdge(3, 6);

        //E -> A
        graph.addEdge(4, 0);

        //F -> B,H
        graph.addEdge(5, 1);
        graph.addEdge(5, 7);

        //G -> D, I
        graph.addEdge(6, 3);
        graph.addEdge(6, 8);

        //H -> F
        graph.addEdge(7, 5);

        //I -> G
        graph.addEdge(8, 6);
    }

}
