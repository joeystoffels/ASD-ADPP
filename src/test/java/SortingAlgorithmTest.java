import asd.adpp.quicksort.SortingAlgorithm;
import asd.adpp.quicksort.QuickSort;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;

@Slf4j
public class SortingAlgorithmTest {

    @Test
    public void sort_emptyArray() {
        int[] array = {};
        int[] expected = {};

        test(new QuickSort(), array, expected);
    }

    @Test
    public void sort_smallArray() {
        int[] array = {5, 4};
        int[] expected = {4, 5};

        test(new QuickSort(), array, expected);
    }


    @Test
    public void sort_mediumArray() {
        int[] array = createIntArray(50);
        int[] expected = createExpectedArray(array);

        test(new QuickSort(), array, expected);
    }

    @Test
    public void sort_largeArray() {
        int[] array = createIntArray(10000);
        int[] expected = createExpectedArray(array);

        test(new QuickSort(), array, expected);
    }

    @Test
    public void sort_sameValues() {
        int[] array = {5, 5, 5, 5, 5, 5, 5};
        int[] expected = {5, 5, 5, 5, 5, 5, 5};

        test(new QuickSort(), array, expected);
    }

    private void test(SortingAlgorithm algorithm, int[] array, int[] expected) {
        algorithm.sort(array);

        log.info(Arrays.toString(array));
        log.info(Arrays.toString(expected));

        assertArrayEquals(array, expected);
    }

    private int[] createIntArray(int arraySize) {
        Random random = new Random();
        return IntStream.generate(random::nextInt).limit(arraySize).toArray();
    }

    private int[] createExpectedArray(int[] array) {
        int[] expected = array.clone();
        Arrays.sort(expected);
        return expected;
    }
}
