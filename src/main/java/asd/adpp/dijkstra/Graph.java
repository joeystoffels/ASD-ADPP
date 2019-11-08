package asd.adpp.dijkstra;

import java.util.LinkedList;

/**
 * Beargumentatie gebruik AdjacencyList:
 *
 * Omdat de meeste grafen niet supervol zitten met Vertices en Edges (ook de Graphs in deze applicatie niet)
 * heb ik gekozen voor de AdjacencyList.
 *
 * We werken met een 'directed Graph' wat inhoud dat iedere Edge maximaal één keer voorkomt tussen twee Vertices.
 * De big-O notatie hiervoor is O(V + E).
 *
 * Bij een matrix wordt er al ruimte gereserveerd voor het aantal Vertices keer het aantal Vertices.
 * De big-O notatie hiervoor is O(V ^ 2).
 *
 * Op basis van de big-O's is een AdjacencyList de voor de hand liggende keuze. Daarnaast is de
 * AdjacencyList ok gebruikt om een lijst van ordered elementen te kunnen bijhouden.
 */
public class Graph {

    private LinkedList<Vertex>[] adjacencyList;

    public Graph(LinkedList<Vertex> vertices) {
        adjacencyList = new LinkedList[vertices.size()];

        for (int i = 0; i < vertices.size(); i++) {
            adjacencyList[i] = new LinkedList<>();
            adjacencyList[i].add(vertices.get(i));
        }

    }

    public void addEdge(Vertex source, Vertex destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        source.addEdge(edge);

        for (LinkedList<Vertex> linkedList : adjacencyList) {
            if (linkedList.getFirst() == source) {
                linkedList.add(destination);
            }
        }
    }

    public LinkedList<Vertex>[] getAdjacencyList() {
        return adjacencyList;
    }

}
