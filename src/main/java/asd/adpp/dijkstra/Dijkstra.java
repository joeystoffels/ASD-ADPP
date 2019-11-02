package asd.adpp.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Dijkstra algorithm based on the following source:
 * https://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html#shortestpath_graphproblems
 */
public class Dijkstra {

    private final List<Vertex> vertices;
    private final List<Edge> edges;
    private Set<Vertex> settledVertices;
    private Set<Vertex> unsettledVertices;
    private Map<Vertex, Vertex> predecessors;
    private Map<Vertex, Integer> verticesWeights;

    public Dijkstra(Graph graph) {
        // create a copy of the array so that we can operate on this array
        this.vertices = graph.getVertices();
        this.edges = graph.getEdges();
    }

    public void executeWeighted(Vertex source) {
        this.execute(source, false);
    }

    public void executeUnweighted(Vertex source) {
        this.execute(source, true);
    }

    public List<Vertex> getShortestPath(Vertex target) {
        LinkedList<Vertex> path = new LinkedList<>();
        Vertex step = target;

        // check if a path exists
        if (predecessors.get(step) == null) {
            return path;
        }

        path.add(step);

        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }

        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }

    public int getShortestPathWeight(Vertex destination) {
        Integer d = verticesWeights.get(destination);
        return Objects.requireNonNullElse(d, Integer.MAX_VALUE);
    }

    private void execute(Vertex source, boolean unweighted) {
        settledVertices = new HashSet<>();
        unsettledVertices = new HashSet<>();
        verticesWeights = new HashMap<>();
        predecessors = new HashMap<>();
        verticesWeights.put(source, 0);
        unsettledVertices.add(source);

        if (unweighted) {
            for (Edge edge : edges) {
                edge.setWeight(0);
            }
        }

        while (!unsettledVertices.isEmpty()) {
            Vertex vertex = getMinimum(unsettledVertices);
            settledVertices.add(vertex);
            unsettledVertices.remove(vertex);
            findMinimalDistances(vertex);
        }

    }

    private void findMinimalDistances(Vertex vertex) {
        List<Vertex> adjacentVertices = getNeighbors(vertex);

        for (Vertex target : adjacentVertices) {
            if (getShortestPathWeight(target) >
                    getShortestPathWeight(vertex) + getWeight(vertex, target)) {
                verticesWeights.put(target, getShortestPathWeight(vertex) + getWeight(vertex, target));
                predecessors.put(target, vertex);
                unsettledVertices.add(target);
            }
        }
    }

    private int getWeight(Vertex vertex, Vertex target) {
        for (Edge edge : edges) {
            if (edge.getSource().equals(vertex)
                    && edge.getDestination().equals(target)) {
                return edge.getWeight();
            }
        }

        throw new RuntimeException("Should not happen");
    }

    private List<Vertex> getNeighbors(Vertex vertex) {
        List<Vertex> neighbors = new ArrayList<>();

        for (Edge edge : edges) {
            if (edge.getSource().equals(vertex)
                    && !settledVertices.contains(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }

        return neighbors;
    }

    private Vertex getMinimum(Set<Vertex> vertexes) {
        Vertex minimum = null;

        for (Vertex vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestPathWeight(vertex) < getShortestPathWeight(minimum)) {
                    minimum = vertex;
                }
            }
        }

        return minimum;
    }



}
