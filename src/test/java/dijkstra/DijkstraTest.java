package dijkstra;// https://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html#shortestpath_graphproblems

import asd.adpp.dijkstra.Dijkstra;
import asd.adpp.dijkstra.Edge;
import asd.adpp.dijkstra.Graph;
import asd.adpp.dijkstra.Vertex;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DijkstraTest {

    @Test
    public void shortestWeighted() {
        Vertex source = new Vertex("Source", "Source");
        Vertex vertexA = new Vertex("A", "Vertex A");
        Vertex vertexB = new Vertex("B", "Vertex B");

        LinkedList<Vertex> vertices = Stream.of(source, vertexA, vertexB)
                .collect(Collectors.toCollection(LinkedList::new));

        LinkedList<Edge> edges = new LinkedList<>();

        edges.add(new Edge(source, vertexA, 15));
        edges.add(new Edge(source, vertexB, 17));
        edges.add(new Edge(vertexA, vertexB, 1));

        Graph graph = new Graph(vertices, edges);
        Dijkstra dijkstra = new Dijkstra(graph);

        dijkstra.executeWeighted(source);

        List<Vertex> shortestWeightedPath = dijkstra.getShortestPath(vertexB);
        int shortestWeightedPathWeight = dijkstra.getShortestPathWeight(vertexB);

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

        LinkedList<Edge> edges = new LinkedList<>();

        edges.add(new Edge(source, vertexA, 15));
        edges.add(new Edge(source, vertexB, -17));
        edges.add(new Edge(vertexA, vertexB, -1));

        Graph graph = new Graph(vertices, edges);
        Dijkstra dijkstra = new Dijkstra(graph);

        dijkstra.executeWeighted(source);

        List<Vertex> shortestWeightedPath = dijkstra.getShortestPath(vertexB);
        int shortestWeightedPathWeight = dijkstra.getShortestPathWeight(vertexB);

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

        LinkedList<Edge> edges = new LinkedList<>();

        edges.add(new Edge(source, vertexA, 15));
        edges.add(new Edge(source, vertexB, 17));
        edges.add(new Edge(vertexA, vertexB, 1));

        Graph graph = new Graph(vertices, edges);
        Dijkstra dijkstra = new Dijkstra(graph);

        dijkstra.executeUnweighted(source);

        List<Vertex> shortestWeightedPath = dijkstra.getShortestPath(vertexB);
        int shortestWeightedPathWeight = dijkstra.getShortestPathWeight(vertexB);

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

        LinkedList<Edge> edges = new LinkedList<>();

        Graph graph = new Graph(vertices, edges);
        Dijkstra dijkstra = new Dijkstra(graph);

        dijkstra.executeWeighted(source);

        List<Vertex> shortestWeightedPath = dijkstra.getShortestPath(vertexB);
        int shortestWeightedPathWeight = dijkstra.getShortestPathWeight(vertexB);

        assertTrue(shortestWeightedPath.isEmpty());
        assertEquals(Integer.MAX_VALUE, shortestWeightedPathWeight);
    }


}
