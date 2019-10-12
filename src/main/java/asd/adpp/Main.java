package asd.adpp;

import asd.adpp.binaire.zoekboom.BinarySearchTree;
import asd.adpp.kortste.paden.Dijkstra;
import asd.adpp.kortste.paden.Graph;
import asd.adpp.kortste.paden.Vertex;
import asd.adpp.quicksort.Weight;
import asd.adpp.quicksort.QuickSort;
import asd.adpp.quicksort.SortingAlgorithm;
import asd.adpp.util.SortingUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Main {

    public static void main(String... args) {
        Main main = new Main();
//        main.demoGenericQuickSort();
//        main.demoDijkstra();
        main.demoBinarySearchTree();
    }

    private void demoGenericQuickSort() {
        SortingAlgorithm<Weight> sortingAlgorithm = new QuickSort<>();
        Weight[] array = SortingUtil.createIntWrapperArray(1, 5, 4, 3);

        log.info("Before QuickSort: " + Arrays.toString(array));

        sortingAlgorithm.sort(array);

        log.info("After QuickSort : " + Arrays.toString(array));
    }

    private void demoDijkstra() {
        Dijkstra dijkstra = new Dijkstra();

        Graph graph = new Graph();

        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");

        vertexA.addDestination(vertexB, 50);
        vertexA.addDestination(vertexC, 25);
        vertexA.addDestination(vertexD, 10);

        vertexB.addDestination(vertexD, 30);
        vertexB.addDestination(vertexA, 15);

        vertexC.addDestination(vertexD, 25);

        vertexD.addDestination(vertexA, 5);

        Dijkstra.calculateShortestPathFromSource(vertexA);

//        log.info();
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

        log.info(binarySearchTree.toString());

        log.info("Found: " + binarySearchTree.find(50));
        log.info("Found min: " + binarySearchTree.findMin());
        log.info("Found max: " + binarySearchTree.findMax());

        binarySearchTree.remove(25);
        binarySearchTree.remove(26);

        log.info("After delete: " + binarySearchTree.toString());
    }

}
