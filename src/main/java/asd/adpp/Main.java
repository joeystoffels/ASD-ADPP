package asd.adpp;

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
        main.demoGenericQuickSort();
        main.demoDijkstra();
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

}
