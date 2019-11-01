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
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class Main {

    public static void main(String... args) {
        Main main = new Main();
//        main.demoGenericQuickSort();
        main.demoDijkstra();
//        main.demoBinarySearchTree();
    }

    private void demoGenericQuickSort() {
        SortingAlgorithm<Weight> sortingAlgorithm = new QuickSort<>();
        Weight[] array = SortingUtil.createIntWrapperArray(1, 5, 4, 3);

        log.info("Before QuickSort: " + Arrays.toString(array));

        sortingAlgorithm.sort(array);

        log.info("After QuickSort : " + Arrays.toString(array));
    }

    private void demoDijkstra() {
        Vertex source = new Vertex("source", "source");
        Vertex vertexA = new Vertex("A", "Vertex A");
        Vertex vertexB = new Vertex("B", "Vertex B");
        Vertex vertexC = new Vertex("C", "Vertex C");
        Vertex vertexD = new Vertex("D", "Vertex D");

        Edge edgeS = new Edge(source, vertexA, 15);
        Edge edgeT = new Edge(vertexA, vertexB, 15);
        Edge edgeU = new Edge(vertexC, vertexB, 5);
        Edge edgeV = new Edge(vertexD, vertexB, 20);
        Edge edgeW = new Edge(vertexD, vertexA, 25);
        Edge edgeX = new Edge(vertexA, vertexC, 1);
        Edge edgeY = new Edge(vertexC, vertexD, 50);
        Edge edgeZ = new Edge(vertexA, vertexD, 30);

        LinkedList<Vertex> vertices = Stream.of(source, vertexA, vertexB, vertexC, vertexD)
                .collect(Collectors.toCollection(LinkedList::new));

        LinkedList<Edge> edges = Stream.of(edgeS, edgeT, edgeU, edgeV, edgeW, edgeX, edgeY, edgeZ)
                .collect(Collectors.toCollection(LinkedList::new));

        Graph graph = new Graph(vertices, edges);
        Dijkstra dijkstra = new Dijkstra(graph);

        dijkstra.execute(source);

        List<Vertex> unweightedPath = dijkstra.getShortestUnweightedPath(vertexD);
        int weightedPath = dijkstra.getShortestWeightedPath(vertexD);

        log.info(String.valueOf(unweightedPath));
        log.info(String.valueOf(weightedPath));
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

        log.info("Found: " + binarySearchTree.find(50));
        log.info("Found min: " + binarySearchTree.findMin());
        log.info("Found max: " + binarySearchTree.findMax());

        binarySearchTree.remove(25);
        binarySearchTree.remove(26);

        log.info("After delete: " + binarySearchTree);
    }

}
