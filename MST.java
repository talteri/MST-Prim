package PRIM;

import java.util.*;
import PRIM.Graph;

class MST {
    static class EdgeComparator implements Comparator<Graph.Edge> {
        @Override
        public int compare(Graph.Edge edge1, Graph.Edge edge2) {
            return edge1.weight - edge2.weight;
        }
    }

    public static Graph primMST(Graph graph, int startVertex) {
        Graph mst = new Graph(graph.numVertices);
        boolean[] visited = new boolean[graph.numVertices];
        PriorityQueue<Graph.Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());

        priorityQueue.add(new Graph.Edge(-1, startVertex, 0));

        while (!priorityQueue.isEmpty()) {
            Graph.Edge edge = priorityQueue.poll();
            int source = edge.source;
            int dest = edge.dest;
            if (visited[dest]) {
                continue;
            }

            visited[dest] = true;
            if (source != -1) {
                mst.addEdge(source, dest, edge.weight);
            }

            for (Graph.Edge e : graph.adjacencyList[dest]) {
                if (!visited[e.dest]) {
                    priorityQueue.add(new Graph.Edge(dest, e.dest, e.weight));
                }
            }
        }

        return mst;
    }

    public static Graph updateMST(Graph mst, int source, int dest, int weight) {
        boolean[] visited = new boolean[mst.numVertices];
        int maxWeight = 0;
        Graph.Edge maxWeightEdge = null;

        // Check if adding this edge creates a cycle
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (vertex == dest) {
                // Adding this edge creates a cycle, so we need to remove the edge with maximum weight
                // from the MST
                for (Graph.Edge edge : mst.adjacencyList[source]) {
                    if (edge.dest == dest) {
                        continue;
                    }
                    if (edge.weight > maxWeight) {
                        maxWeight = edge.weight;
                        maxWeightEdge = edge;
                    }
                }
                mst.adjacencyList[source].remove(maxWeightEdge);
                break;
            }
            for (Graph.Edge edge : mst.adjacencyList[vertex]) {
                if (!visited[edge.dest]) {
                    queue.add(edge.dest);
                    visited[edge.dest] = true;
                }
            }
        }

        if (maxWeightEdge == null) {
            // Adding this edge does not create a cycle, so we can simply add it to the MST
            mst.addEdge(source, dest, weight);
        }

        return mst;
    }
}
