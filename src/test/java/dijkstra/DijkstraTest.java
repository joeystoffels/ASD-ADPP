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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DijkstraTest {

    @Test
    public void testShortestWeighted() {
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

        assertThat(shortestWeightedPath.contains(source), is(true));
        assertThat(shortestWeightedPath.contains(vertexA), is(true));
        assertThat(shortestWeightedPath.contains(vertexB), is(true));
        assertThat(shortestWeightedPath.size(), is(3));
        assertThat(shortestWeightedPathWeight, is(16));
    }

    @Test
    public void testShortestWeightedWithNegativeWeigths() {
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

        assertThat(shortestWeightedPath.contains(source), is(true));
        assertThat(shortestWeightedPath.contains(vertexB), is(true));
        assertThat(shortestWeightedPath.size(), is(2));
        assertThat(shortestWeightedPathWeight, is(-17));
    }

    @Test
    public void testShortestUnweighted() {
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

        assertThat(shortestWeightedPath.contains(source), is(true));
        assertThat(shortestWeightedPath.contains(vertexB), is(true));
        assertThat(shortestWeightedPath.size(), is(2));
        assertThat(shortestWeightedPathWeight, is(0));
    }

    @Test
    public void testWithNoEdges() {
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

        assertThat(shortestWeightedPath.isEmpty(), is(true));
        assertThat(shortestWeightedPathWeight, is(Integer.MAX_VALUE));
    }



}
