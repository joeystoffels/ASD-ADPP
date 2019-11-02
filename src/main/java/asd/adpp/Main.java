package asd.adpp;

import asd.adpp.binarysearchtree.BinarySearchTree;
import asd.adpp.dijkstra.Dijkstra;
import asd.adpp.dijkstra.Edge;
import asd.adpp.dijkstra.Graph;
import asd.adpp.dijkstra.Vertex;
import asd.adpp.quicksort.QuickSort;
import asd.adpp.quicksort.SortingAlgorithm;
import asd.adpp.quicksort.Weight;
import asd.adpp.util.SortingUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String... args) {
        Main main = new Main();
        main.demoGenericQuickSort();
        main.demoDijkstra();
        main.demoBinarySearchTree();
    }

    private void demoGenericQuickSort() {
        SortingAlgorithm<Weight> sortingAlgorithm = new QuickSort<>();
        Weight[] array = SortingUtil.createIntWrapperArray(1, 5, 4, 3);

        System.out.println("Before QuickSort: " + Arrays.toString(array));

        sortingAlgorithm.sort(array);

        System.out.println("After QuickSort : " + Arrays.toString(array));
    }

    private void demoDijkstra() {
        Vertex source = new Vertex("Source", "Source");
        Vertex vertexA = new Vertex("A", "Vertex A");
        Vertex vertexB = new Vertex("B", "Vertex B");
        Vertex vertexC = new Vertex("C", "Vertex C");
        Vertex vertexD = new Vertex("D", "Vertex D");

        LinkedList<Vertex> vertices = Stream.of(source, vertexA, vertexB, vertexC, vertexD)
                .collect(Collectors.toCollection(LinkedList::new));

        LinkedList<Edge> edges = new LinkedList<>();

        edges.add(new Edge(source, vertexA, 0));
        edges.add(new Edge(source, vertexC, 0));
        edges.add(new Edge(vertexA, vertexB, 15));
        edges.add(new Edge(vertexC, vertexB, 5));
        edges.add(new Edge(vertexD, vertexB, 20));
        edges.add(new Edge(vertexD, vertexA, 25));
        edges.add(new Edge(vertexA, vertexC, 0));
        edges.add(new Edge(vertexC, vertexD, 50));
        edges.add(new Edge(vertexA, vertexD, 30));

        Graph graph = new Graph(vertices, edges);
        Dijkstra dijkstra = new Dijkstra(graph);

        dijkstra.executeWeighted(source);

        List<Vertex> shortestWeightedPath = dijkstra.getShortestPath(vertexC);
        int shortestWeightedPathWeight = dijkstra.getShortestPathWeight(vertexC);

        System.out.println(shortestWeightedPath);
        System.out.println(shortestWeightedPathWeight);
    }

    private void demoBinarySearchTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(25);
        binarySearchTree.insert(24);
        binarySearchTree.insert(26);
        binarySearchTree.insert(35);
        binarySearchTree.insert(36);
        binarySearchTree.insert(34);
        binarySearchTree.insert(50);
        binarySearchTree.insert(49);
        binarySearchTree.insert(51);
        binarySearchTree.insert(1);

        System.out.println("Found: " + binarySearchTree.find(50));
        System.out.println("Found min: " + binarySearchTree.findMin());
        System.out.println("Found max: " + binarySearchTree.findMax());

        binarySearchTree.remove(25);
        binarySearchTree.remove(26);

        System.out.println("After delete: " + binarySearchTree);
    }

}
