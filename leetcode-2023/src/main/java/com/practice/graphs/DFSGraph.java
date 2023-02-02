package com.practice.graphs;

import java.util.*;

// This class represents a
// directed graph using adjacency
// list representation
public class DFSGraph {
    private int v; // No. of vertices

    // Array  of lists for
    // Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    DFSGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 1; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
    }

    // A function used by DFS
    void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this
        // vertex
        for (Integer n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal.
    // It uses recursive
    // DFSUtil()
    void DFS(int v) {
        // false by default in java)
        boolean visited[] = new boolean[this.v];
        // traversal
        DFSUtil(v, visited);
    }

    public static void main(String args[]) {
        DFSGraph g = new DFSGraph(6);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);

        System.out.println("Following is Depth First Traversal starting from vertex 1");
        g.DFS(1);
    }
}