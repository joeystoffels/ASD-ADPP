// https://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html#shortestpath_graphproblems
package asd.adpp.dijkstra;

public class Vertex {
    private final String id;
    private final String name;

    public Vertex(String id, String name) {
        this.id = id;
        this.name = name;
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
