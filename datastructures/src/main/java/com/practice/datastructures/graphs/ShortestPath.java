package com.practice.datastructures.graphs;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

class ShortestPath {

    private static final int MAX_VERTICES = 5;
    private static final int MAX_WEIGHT = Integer.MAX_VALUE;

    public static void main ( String[] args ){
        ShortestPath shortestPath = new ShortestPath();
        DirectedGraph directedGraph = shortestPath.new DirectedGraph();
        directedGraph.printAdjacencyMatrix();
        int startVertex = 0;
        path ( startVertex, directedGraph );
    }
    /*
    ShortestPath( Graph G, Starting node s, destination node t ) {
	known = {s} // add starting node into the list of known nodes.
	for i = 1 to n
		dist[i] = infinity // relax distance of each node from starting node.
	for each edge (s,v), dist[v] = w(s,v)
	parent = s
	while ( parent # t )
		select vnext - the unknown vertex minimizing dist[v]
		for each edge (vnext, x),dist[x] = min[dist[x],dist[vnext]+w(vnext,x)]
		parent = vnext
		known = add vnext to list of known nodes
} // this does not work in presence of cycles.


     */
    private static void path( int startVertex, DirectedGraph directedGraph ) {
        int destinationVertex = 4;
        Set<Integer> unknownVertices = new LinkedHashSet<>();
        for ( int i = 0; i < MAX_VERTICES; ++i ) {
            unknownVertices.add(i);
        }

        Set<Integer> knownVertices = new LinkedHashSet<>();
        unknownVertices.remove(startVertex);
        knownVertices.add(startVertex);

        int[] distance = new int[MAX_VERTICES];
        distance[startVertex] = Integer.MAX_VALUE;
        for ( int i = 1; i < MAX_VERTICES; ++i ) {
            distance[i] = Integer.MAX_VALUE;
        }
        Set<Integer> adjacentEdges = directedGraph.getEdges( startVertex );
        int weight;
        for ( int i: adjacentEdges ) {
            weight = directedGraph.getWeight( startVertex, i );
            distance[i] = weight;
        }
        int parent = startVertex;
        int next_vertex;

        while ( parent != destinationVertex ) {
            next_vertex = getMinimumDistance( distance, unknownVertices );
            adjacentEdges = directedGraph.getEdges( next_vertex );
            for ( int i: adjacentEdges ) {
                distance[i] = Integer.min(distance[i], ( distance[next_vertex] +  directedGraph.getWeight(next_vertex, i )));
            }
            knownVertices.add(next_vertex);
            unknownVertices.remove(next_vertex);
            parent = next_vertex;
        }
        System.out.println ("Distance " +Arrays.toString(distance));
    } // end method

    private static int getMinimumDistance( int [] distance, Set<Integer> unknownVertices ) {
        int min_vertex = 0;
        for  ( int i = 1; i < MAX_VERTICES; ++i ) {
            if ( distance[i] < distance[min_vertex] && unknownVertices.contains(i) ) {
                min_vertex = i;
            }
        }
        return min_vertex;
    }

    private class DirectedGraph {

        private int[][] adjMat;

        private DirectedGraph() {

            System.out.println ("Populating adjacency matrix");
            adjMat = new int[5][5];
            //row 0
            adjMat[0][0] = MAX_WEIGHT;
            adjMat[0][1] = 50;
            adjMat[0][2] = MAX_WEIGHT;
            adjMat[0][3] = 80;
            adjMat[0][4] = MAX_WEIGHT;
            //row 1
            adjMat[1][0] = MAX_WEIGHT;
            adjMat[1][1] = MAX_WEIGHT;
            adjMat[1][2] = 60;
            adjMat[1][3] = 90;
            adjMat[1][4] = MAX_WEIGHT;
            //row 2
            adjMat[2][0] = MAX_WEIGHT;
            adjMat[2][1] = MAX_WEIGHT;
            adjMat[2][2] = MAX_WEIGHT;
            adjMat[2][3] = MAX_WEIGHT;
            adjMat[2][4] = 40;
            //row 3
            adjMat[3][0] = MAX_WEIGHT;
            adjMat[3][1] = MAX_WEIGHT;
            adjMat[3][2] = 20;
            adjMat[3][3] = MAX_WEIGHT;
            adjMat[3][4] = 70;
            //row 4
            adjMat[4][0] = MAX_WEIGHT;
            adjMat[4][1] = 50;
            adjMat[4][2] = MAX_WEIGHT;
            adjMat[4][3] = MAX_WEIGHT;
            adjMat[4][4] = MAX_WEIGHT;
        } // end constructor

        private void printAdjacencyMatrix() {
            System.out.println("The adjacency matrix for the given graph is: ");
            System.out.print("  ");
            for (int i = 0; i < MAX_VERTICES; i++)
                System.out.print(i + " ");
            System.out.println();

            for (int i = 0; i < MAX_VERTICES; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < MAX_VERTICES; j++)
                    System.out.print(getWeight(i, j) + " ");
                System.out.println();
            }
        } // end method

        private int getWeight( int from, int to) {
            return adjMat[from][to];
        } // end method

        private Set<Integer> getEdges( int from  ) {
            Set<Integer> ret = new LinkedHashSet<>();
            for ( int i = 0; i < MAX_VERTICES; ++i ) {
                if ( adjMat[from][i] < Integer.MAX_VALUE ) {
                    ret.add(i);
                }
            }
            return ret;
        }// end method
    }
}// end class
