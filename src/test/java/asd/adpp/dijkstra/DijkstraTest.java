package asd.adpp.dijkstra;

import asd.adpp.BaseUnitTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DijkstraTest extends BaseUnitTest {

    @Test
    public void shortestWeighted() {
        Vertex source = new Vertex("Source", "Source");
        Vertex vertexA = new Vertex("A", "Vertex A");
        Vertex vertexB = new Vertex("B", "Vertex B");

        LinkedList<Vertex> vertices = Stream.of(source, vertexA, vertexB)
                .collect(Collectors.toCollection(LinkedList::new));

        Graph graph = new Graph(vertices);

        graph.addEdge(source, vertexA, 15);
        graph.addEdge(source, vertexB, 17);
        graph.addEdge(vertexA, vertexB, 1);

        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.executeWeighted(source);

        List<Vertex> shortestWeightedPath = dijkstra.getShortestPath(vertexB);
        int shortestWeightedPathWeight = dijkstra.getShortestPathWeight(vertexB);

        System.out.println("Graph: " + dijkstra.getEdges());
        System.out.println("Shortest path: " + shortestWeightedPath + " (weight: " + shortestWeightedPathWeight + ")");

        assertTrue(shortestWeightedPath.contains(source));
        assertTrue(shortestWeightedPath.contains(vertexA));
        assertTrue(shortestWeightedPath.contains(vertexB));
        assertEquals(3, shortestWeightedPath.size());
        assertEquals(16, shortestWeightedPathWeight);
    }

    @Test
    public void shortestWeightedWithNegativeWeigths() {
        Vertex source = new Vertex("Source", "Source");
        Vertex vertexA = new Vertex("A", "Vertex A");
        Vertex vertexB = new Vertex("B", "Vertex B");

        LinkedList<Vertex> vertices = Stream.of(source, vertexA, vertexB)
                .collect(Collectors.toCollection(LinkedList::new));

        Graph graph = new Graph(vertices);

        graph.addEdge(source, vertexA, 15);
        graph.addEdge(source, vertexB, -17);
        graph.addEdge(vertexA, vertexB, -1);

        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.executeWeighted(source);

        List<Vertex> shortestWeightedPath = dijkstra.getShortestPath(vertexB);
        int shortestWeightedPathWeight = dijkstra.getShortestPathWeight(vertexB);

        System.out.println("Graph: " + dijkstra.getEdges());
        System.out.println("Shortest path: " + shortestWeightedPath + " (weight: " + shortestWeightedPathWeight + ")");

        assertTrue(shortestWeightedPath.contains(source));
        assertTrue(shortestWeightedPath.contains(vertexB));
        assertEquals(2, shortestWeightedPath.size());
        assertEquals(-17, shortestWeightedPathWeight);
    }

    @Test
    public void shortestUnweighted() {
        Vertex source = new Vertex("Source", "Source");
        Vertex vertexA = new Vertex("A", "Vertex A");
        Vertex vertexB = new Vertex("B", "Vertex B");

        LinkedList<Vertex> vertices = Stream.of(source, vertexA, vertexB)
                .collect(Collectors.toCollection(LinkedList::new));

        Graph graph = new Graph(vertices);

        graph.addEdge(source, vertexA, 15);
        graph.addEdge(source, vertexB, 17);
        graph.addEdge(vertexA, vertexB, 1);

        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.executeUnweighted(source);

        List<Vertex> shortestWeightedPath = dijkstra.getShortestPath(vertexB);
        int shortestWeightedPathWeight = dijkstra.getShortestPathWeight(vertexB);

        System.out.println("Graph: " + dijkstra.getEdges());
        System.out.println("Shortest path: " + shortestWeightedPath + " (weight: " + shortestWeightedPathWeight + ")");

        assertTrue(shortestWeightedPath.contains(source));
        assertTrue(shortestWeightedPath.contains(vertexB));
        assertEquals(2, shortestWeightedPath.size());
        assertEquals(0, shortestWeightedPathWeight);
    }

    @Test
    public void graphWithNoEdges() {
        Vertex source = new Vertex("Source", "Source");
        Vertex vertexA = new Vertex("A", "Vertex A");
        Vertex vertexB = new Vertex("B", "Vertex B");

        LinkedList<Vertex> vertices = Stream.of(source, vertexA, vertexB)
                .collect(Collectors.toCollection(LinkedList::new));

        Graph graph = new Graph(vertices);
        Dijkstra dijkstra = new Dijkstra(graph);

        dijkstra.executeWeighted(source);

        List<Vertex> shortestWeightedPath = dijkstra.getShortestPath(vertexB);
        int shortestWeightedPathWeight = dijkstra.getShortestPathWeight(vertexB);

        System.out.println("Graph: " + dijkstra.getEdges());
        System.out.println("Shortest path: " + shortestWeightedPath + " (weight: " + shortestWeightedPathWeight + ")");

        assertTrue(shortestWeightedPath.isEmpty());
        assertEquals(Integer.MAX_VALUE, shortestWeightedPathWeight);
    }

    @Test
    public void shortestWeightedWithNoEdgeToTargetVertex() {
        Vertex source = new Vertex("Source", "Source");
        Vertex vertexA = new Vertex("A", "Vertex A");
        Vertex vertexB = new Vertex("B", "Vertex B");
        Vertex vertexC = new Vertex("C", "Vertex C");

        LinkedList<Vertex> vertices = Stream.of(source, vertexA, vertexB)
                .collect(Collectors.toCollection(LinkedList::new));

        Graph graph = new Graph(vertices);

        graph.addEdge(source, vertexA, 15);
        graph.addEdge(source, vertexB, 17);
        graph.addEdge(vertexA, vertexB, 1);

        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.executeWeighted(source);

        List<Vertex> shortestWeightedPath = dijkstra.getShortestPath(vertexC);
        int shortestWeightedPathWeight = dijkstra.getShortestPathWeight(vertexC);

        System.out.println("Graph: " + dijkstra.getEdges());
        System.out.println("Shortest path: " + shortestWeightedPath + " (weight: " + shortestWeightedPathWeight + ")");

        // Should not be found
        assertTrue(shortestWeightedPath.isEmpty());
        assertEquals(Integer.MAX_VALUE, shortestWeightedPathWeight);
    }

    @Test
    public void shortestUnweightedWithNoEdgeToTargetVertex() {
        Vertex source = new Vertex("Source", "Source");
        Vertex vertexA = new Vertex("A", "Vertex A");
        Vertex vertexB = new Vertex("B", "Vertex B");
        Vertex vertexC = new Vertex("C", "Vertex C");

        LinkedList<Vertex> vertices = Stream.of(source, vertexA, vertexB)
                .collect(Collectors.toCollection(LinkedList::new));

        Graph graph = new Graph(vertices);

        graph.addEdge(source, vertexA, 15);
        graph.addEdge(source, vertexB, 17);
        graph.addEdge(vertexA, vertexB, 1);

        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.executeUnweighted(source);

        List<Vertex> shortestWeightedPath = dijkstra.getShortestPath(vertexC);
        int shortestWeightedPathWeight = dijkstra.getShortestPathWeight(vertexC);

        System.out.println("Graph: " + dijkstra.getEdges());
        System.out.println("Shortest path: " + shortestWeightedPath + " (weight: " + shortestWeightedPathWeight + ")");

        // Should not be found
        assertTrue(shortestWeightedPath.isEmpty());
        assertEquals(Integer.MAX_VALUE, shortestWeightedPathWeight);
    }

}
