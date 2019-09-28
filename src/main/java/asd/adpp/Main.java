package asd.adpp;

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
    }

    private void demoGenericQuickSort() {
        SortingAlgorithm<IntWrapper> sortingAlgorithm = new QuickSort<>();
        IntWrapper[] array = SortingUtil.createIntWrapperArray(1, 5, 4, 3);

        log.info("Before QuickSort: " + Arrays.toString(array));

        sortingAlgorithm.sort(array);

        log.info("After QuickSort : " + Arrays.toString(array));
    }

}
