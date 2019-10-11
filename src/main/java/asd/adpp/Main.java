package asd.adpp;

import asd.adpp.binaire.zoekboom.BinarySearchTree;
import asd.adpp.kortste.paden.Dijkstra;
import asd.adpp.kortste.paden.Graph;
import asd.adpp.kortste.paden.Node;
import asd.adpp.quicksort.IntWrapper;
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
        SortingAlgorithm<IntWrapper> sortingAlgorithm = new QuickSort<>();
        IntWrapper[] array = SortingUtil.createIntWrapperArray(1, 5, 4, 3);

        log.info("Before QuickSort: " + Arrays.toString(array));

        sortingAlgorithm.sort(array);

        log.info("After QuickSort : " + Arrays.toString(array));
    }

    private void demoDijkstra() {
        Dijkstra dijkstra = new Dijkstra();

        Graph graph = new Graph();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");

        nodeA.addDestination(nodeB, 50);
        nodeA.addDestination(nodeC, 25);
        nodeA.addDestination(nodeD, 10);

        nodeB.addDestination(nodeD, 30);
        nodeB.addDestination(nodeA, 15);

        nodeC.addDestination(nodeD, 25);

        nodeD.addDestination(nodeA, 5);

        Dijkstra.calculateShortestPathFromSource(nodeA);

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
