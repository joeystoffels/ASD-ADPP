import asd.adpp.quicksort.NewInteger;
import asd.adpp.quicksort.QuickSort;
import asd.adpp.quicksort.SortingAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

@Slf4j
public class SortingAlgorithmTest {

    @Test
    public void sort_emptyArray() {
        NewInteger[] array = {};
        NewInteger[] expected = {};

        testSortingAlgorithm(new QuickSort<>(), array, expected);
    }

    @Test
    public void sort_smallArray() {
        NewInteger[] array = createNewIntegerArray(5, 4);
        NewInteger[] expected = createNewIntegerArray(4, 5);

        testSortingAlgorithm(new QuickSort<>(), array, expected);
    }

    @Test
    public void sort_arrayWithDoubles() {
        NewInteger[] array = createNewIntegerArray(3, 3, 2, 5, 3, 1, 5, 4, 3, 2, 1);
        NewInteger[] expected = createNewIntegerArray(1, 1, 2, 2, 3, 3, 3, 3, 4, 5, 5);

        testSortingAlgorithm(new QuickSort<>(), array, expected);
    }

    @Test
    public void sort_sameValues() {
        NewInteger[] array = createNewIntegerArray(5, 5, 5, 5);
        NewInteger[] expected = createNewIntegerArray(5, 5, 5, 5);

        testSortingAlgorithm(new QuickSort<>(), array, expected);
    }

    private <T> void testSortingAlgorithm(SortingAlgorithm<T> algorithm, T[] array, T[] expected) {
        log.info("Before sort: " + Arrays.toString(array));

        algorithm.sort(array);

        log.info("After sort : " + Arrays.toString(array));
        log.info("Expected   : " + Arrays.toString(expected));

        assertArrayEquals(array, expected);
    }

    private NewInteger[] createNewIntegerArray(int... ints) {
        NewInteger[] array = new NewInteger[ints.length];

        for (int x = 0; x < ints.length; x++) {
            array[x] = new NewInteger(ints[x]);
        }

        return array;
    }

}
