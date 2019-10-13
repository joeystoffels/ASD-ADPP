package asd.adpp.kortste.paden;

import java.util.HashSet;
import java.util.Set;

public class Graph {

    private Set<Vertex> vertices = new HashSet<>();

    public void addVertex(Vertex vertexA) {
        vertices.add(vertexA);
    }

    public Set<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(Set<Vertex> vertices) {
        this.vertices = vertices;
    }
}
