package PRIM;

import java.util.*;


class Graph {
    int numVertices;
    LinkedList<Edge>[] adjacencyList;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int dest, int weight) {
        Edge edge = new Edge(source, dest, weight);
        adjacencyList[source].add(edge);
    }

    public static class Edge {
        int source;
        int dest;
        int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }
}