package asd.adpp.util;

import asd.adpp.quicksort.Weight;

public class SortingUtil {

    private SortingUtil() {
    }

    public static Weight[] createIntWrapperArray(int... ints) {
        Weight[] array = new Weight[ints.length];

        for (int x = 0; x < ints.length; x++) {
            array[x] = new Weight(ints[x]);
        }

        return array;
    }

}
