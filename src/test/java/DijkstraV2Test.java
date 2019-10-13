// https://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html#shortestpath_graphproblems

import asd.adpp.dijkstra.DijkstraAlgorithm;
import asd.adpp.dijkstra.Edge;
import asd.adpp.dijkstra.Graph;
import asd.adpp.dijkstra.Vertex;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DijkstraV2Test {

    @Test
    public void testExcute() {
        LinkedList<Vertex> nodes = new LinkedList<>();
        LinkedList<Edge> edges = new LinkedList<>();

        for (int i = 0; i <= 5; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }

        edges.add(new Edge("Edge_0", nodes.get(0), nodes.get(1), 85));
        edges.add(new Edge("Edge_1", nodes.get(2), nodes.get(1), 60));
        edges.add(new Edge("Edge_2", nodes.get(2), nodes.get(4), 40));
        edges.add(new Edge("Edge_3", nodes.get(3), nodes.get(1), 25));
        edges.add(new Edge("Edge_4", nodes.get(5), nodes.get(2), 55));

        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);

        dijkstra.execute(nodes.get(5));
        List<Vertex> path = dijkstra.getPath(nodes.get(2));

        assertNotNull(path);
        assertTrue(path.size() > 0);

        for (Vertex vertex : path) {
            System.out.println(vertex);
        }

        System.out.println(dijkstra.getEdges());
        System.out.println(dijkstra.getNodes());
        System.out.println(dijkstra.getPredecessors());
        System.out.println(dijkstra.getSettledNodes());
        System.out.println(dijkstra.getUnSettledNodes());
    }

}
