package PRIM;

import java.util.*;
import PRIM.MST;
import PRIM.Graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(20);
        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 3, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 4, 4);
        graph.addEdge(2, 5, 6);
        graph.addEdge(3, 4, 7);
        graph.addEdge(3, 6, 3);
        graph.addEdge(4, 5, 8);
        graph.addEdge(4, 7, 9);
        graph.addEdge(5, 8, 2);
        graph.addEdge(6, 7, 4);
        graph.addEdge(6, 8, 5);
        graph.addEdge(6, 9, 1);
        graph.addEdge(7, 8, 7);
        graph.addEdge(7, 9, 6);
        graph.addEdge(8, 9, 9);
        graph.addEdge(9, 10, 2);
        graph.addEdge(9, 11, 4);
        graph.addEdge(9, 12, 6);
        graph.addEdge(10, 11, 3);
        graph.addEdge(10, 13, 7);
        graph.addEdge(11, 12, 5);
        graph.addEdge(11, 14, 8);
        graph.addEdge(12, 13, 9);
        graph.addEdge(12, 15, 2);
        graph.addEdge(13, 14, 4);
        graph.addEdge(13, 16, 3);
        graph.addEdge(14, 15, 6);
        graph.addEdge(14, 17, 7);
        graph.addEdge(15, 16, 8);
        graph.addEdge(15, 18, 9);
        graph.addEdge(16, 17, 2);
        graph.addEdge(16, 19, 4);
        graph.addEdge(17, 18, 5);
        graph.addEdge(17, 19, 6);
        graph.addEdge(18, 19, 7);

        Graph mst = MST.primMST(graph, 0);
        System.out.println("Minimal spanning tree: ");
        for (int i = 0; i < mst.numVertices; i++) {
            for (Graph.Edge edge :mst.adjacencyList[i]) {
                System.out.println(edge.source + " - " + edge.dest + " : " + edge.weight);
            }
        }

        Graph updatedMST = MST.updateMST(mst, 0, 2, 7);
        /*System.out.println("\nUpdated minimal spanning tree: ");
        for (int i = 0; i < updatedMST.numVertices; i++) {
            for (Graph.Edge edge : updatedMST.adjacencyList[i]) {
                System.out.println(edge.source + " - " + edge.dest + " : " + edge.weight);
            }
        }*/

        updatedMST = MST.updateMST(updatedMST, 0, 4, 6);
        System.out.println("\nUpdated minimal spanning tree: ");
        for (int i = 0; i < updatedMST.numVertices; i++) {
            for (Graph.Edge edge : updatedMST.adjacencyList[i]) {
                System.out.println(edge.source + " - " + edge.dest + " : " + edge.weight);
            }
        }
    }
}