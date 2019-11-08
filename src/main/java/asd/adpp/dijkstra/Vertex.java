package asd.adpp.dijkstra;

import java.util.LinkedList;

public class Vertex {
    private final String id;
    private final String name;

    private LinkedList<Edge> edges = new LinkedList<>();

    public Vertex(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public LinkedList<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Vertex other = (Vertex) obj;

        if (id == null) {
            return other.id == null;
        } else {
            return id.equals(other.id);
        }
    }

    @Override
    public String toString() {
        return name;
    }

}
