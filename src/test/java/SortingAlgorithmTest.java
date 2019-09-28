import asd.adpp.quicksort.IntWrapper;
import asd.adpp.quicksort.QuickSort;
import asd.adpp.quicksort.SortingAlgorithm;
import asd.adpp.util.SortingUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

@Slf4j
public class SortingAlgorithmTest {

    @Test
    public void emptyArray() {
        IntWrapper[] array = {};
        IntWrapper[] expected = {};

        testSortingAlgorithm(new QuickSort<>(), array, expected);
    }

    @Test
    public void smallArray() {
        IntWrapper[] array = SortingUtil.createIntWrapperArray(5, 4);
        IntWrapper[] expected = SortingUtil.createIntWrapperArray(4, 5);

        testSortingAlgorithm(new QuickSort<>(), array, expected);
    }

    @Test
    public void arrayWithDoubles() {
        IntWrapper[] array = SortingUtil.createIntWrapperArray(3, 3, 2, 5, 3, 1, 5, 4, 3, 2, 1);
        IntWrapper[] expected = SortingUtil.createIntWrapperArray(1, 1, 2, 2, 3, 3, 3, 3, 4, 5, 5);

        testSortingAlgorithm(new QuickSort<>(), array, expected);
    }

    @Test
    public void sameValues() {
        IntWrapper[] array = SortingUtil.createIntWrapperArray(5, 5, 5, 5);
        IntWrapper[] expected = SortingUtil.createIntWrapperArray(5, 5, 5, 5);

        testSortingAlgorithm(new QuickSort<>(), array, expected);
    }

    private <T> void testSortingAlgorithm(SortingAlgorithm<T> algorithm, T[] array, T[] expected) {
        log.info("Before sort: " + Arrays.toString(array));

        algorithm.sort(array);

        log.info("After sort : " + Arrays.toString(array));
        log.info("Expected   : " + Arrays.toString(expected));

        assertArrayEquals(array, expected);
    }

}
