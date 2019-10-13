// https://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html#shortestpath_graphproblems
package asd.adpp.dijkstra;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private final LinkedList<Vertex> vertexes;
    private final LinkedList<Edge> edges;

    public Graph(LinkedList<Vertex> vertexes, LinkedList<Edge> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
    }

    List<Vertex> getVertexes() {
        return vertexes;
    }

    List<Edge> getEdges() {
        return edges;
    }

}
