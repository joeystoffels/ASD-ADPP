package asd.adpp.dijkstra;

public class Edge  {
    private final Vertex source;
    private final Vertex destination;
    private int weight;

    public Edge(Vertex source, Vertex destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    Vertex getDestination() {
        return destination;
    }

    Vertex getSource() {
        return source;
    }

    int getWeight() {
        return weight;
    }

    void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return source + " -> " + destination + " (weight: " + weight + ")";
    }


}
