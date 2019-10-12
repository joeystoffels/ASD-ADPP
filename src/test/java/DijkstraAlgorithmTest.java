import asd.adpp.kortste.paden.Dijkstra;
import asd.adpp.kortste.paden.Graph;
import asd.adpp.kortste.paden.Vertex;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class DijkstraAlgorithmTest {

        @Test
        public void whenSPPSolved_thenCorrect() {

            Vertex vertexA = new Vertex("A");
            Vertex vertexB = new Vertex("B");
            Vertex vertexC = new Vertex("C");
            Vertex vertexD = new Vertex("D");
            Vertex vertexE = new Vertex("E");
            Vertex vertexF = new Vertex("F");

            vertexA.addDestination(vertexB, 10);
            vertexA.addDestination(vertexC, 15);

            vertexB.addDestination(vertexD, 12);
            vertexB.addDestination(vertexF, 15);

            vertexC.addDestination(vertexE, 10);

            vertexD.addDestination(vertexE, 2);
            vertexD.addDestination(vertexF, 1);

            vertexF.addDestination(vertexE, 5);

            Graph graph = new Graph();

            graph.addNode(vertexA);
            graph.addNode(vertexB);
            graph.addNode(vertexC);
            graph.addNode(vertexD);
            graph.addNode(vertexE);
            graph.addNode(vertexF);

            Dijkstra.calculateShortestPathFromSource(vertexA);

            List<Vertex> shortestPathForVertexB = Collections.singletonList(vertexA);
            List<Vertex> shortestPathForVertexC = Collections.singletonList(vertexA);
            List<Vertex> shortestPathForVertexD = Arrays.asList(vertexA, vertexB);
            List<Vertex> shortestPathForVertexE = Arrays.asList(vertexA, vertexB, vertexD);
            List<Vertex> shortestPathForVertexF = Arrays.asList(vertexA, vertexB, vertexD);

            for (Vertex vertex : graph.getVertices()) {
                switch (vertex.getName()) {
                    case "B":
                        assertEquals(vertex
                                .getShortestPath(), shortestPathForVertexB);
                        break;
                    case "C":
                        assertEquals(vertex
                                .getShortestPath(), shortestPathForVertexC);
                        break;
                    case "D":
                        assertEquals(vertex
                                .getShortestPath(), shortestPathForVertexD);
                        break;
                    case "E":
                        assertEquals(vertex
                                .getShortestPath(), shortestPathForVertexE);
                        break;
                    case "F":
                        assertEquals(vertex
                                .getShortestPath(), shortestPathForVertexF);
                        break;
                }
            }
        }
    }
