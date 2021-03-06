package asd.adpp.quicksort;

import asd.adpp.BaseUnitTest;
import asd.adpp.util.SortingUtil;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Generic sorting algorithm test class, voor nu hebben we enkel het QuickSort algoritme om te testen.
 */
public class SortingAlgorithmTest extends BaseUnitTest {

    @Test
    public void emptyArray() {
        Weight[] array = {};
        Weight[] expected = {};

        testSortingAlgorithm(new QuickSort<>(), array, expected);
    }

    @Test
    public void smallArray() {
        Weight[] array = SortingUtil.createIntWrapperArray(5, 4);
        Weight[] expected = SortingUtil.createIntWrapperArray(4, 5);

        testSortingAlgorithm(new QuickSort<>(), array, expected);
    }

    @Test
    public void arrayWithDoubleValues() {
        Weight[] array = SortingUtil.createIntWrapperArray(3, 3, 2, 5, 3, 1, 5, 4, 3, 2, 1);
        Weight[] expected = SortingUtil.createIntWrapperArray(1, 1, 2, 2, 3, 3, 3, 3, 4, 5, 5);

        testSortingAlgorithm(new QuickSort<>(), array, expected);
    }

    @Test
    public void reversedSorted() {
        Weight[] array = SortingUtil.createIntWrapperArray(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
        Weight[] expected = SortingUtil.createIntWrapperArray(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        testSortingAlgorithm(new QuickSort<>(), array, expected);
    }

    @Test
    public void negativeValues() {
        Weight[] array = SortingUtil.createIntWrapperArray(-3, -5, -1, -9, -4);
        Weight[] expected = SortingUtil.createIntWrapperArray(-9, -5, -4, -3, -1);

        testSortingAlgorithm(new QuickSort<>(), array, expected);
    }

    @Test
    public void negativeAndPositiveValues() {
        Weight[] array = SortingUtil.createIntWrapperArray(-2, 5, -7, 3, 1, 0, -3);
        Weight[] expected = SortingUtil.createIntWrapperArray(-7, -3, -2, 0, 1, 3, 5);

        testSortingAlgorithm(new QuickSort<>(), array, expected);
    }

    @Test
    public void sameValues() {
        Weight[] array = SortingUtil.createIntWrapperArray(5, 5, 5, 5);
        Weight[] expected = SortingUtil.createIntWrapperArray(5, 5, 5, 5);

        testSortingAlgorithm(new QuickSort<>(), array, expected);
    }

    private <T> void testSortingAlgorithm(SortingAlgorithm<T> algorithm, T[] array, T[] expected) {
        System.out.println("Before sort: " + Arrays.toString(array));

        algorithm.sort(array);

        System.out.println("After sort : " + Arrays.toString(array));
        System.out.println("Expected   : " + Arrays.toString(expected));

        assertArrayEquals(array, expected);
    }

}
