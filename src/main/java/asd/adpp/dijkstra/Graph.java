package asd.adpp.dijkstra;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private final LinkedList<Vertex> vertices;
    private final LinkedList<Edge> edges;

    public Graph(LinkedList<Vertex> vertices, LinkedList<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    List<Vertex> getVertices() {
        return vertices;
    }

    List<Edge> getEdges() {
        return edges;
    }

}
