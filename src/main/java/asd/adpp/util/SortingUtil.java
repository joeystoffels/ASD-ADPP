package asd.adpp.util;

import asd.adpp.quicksort.IntWrapper;

public class SortingUtil {

    private SortingUtil() {
    }

    public static IntWrapper[] createIntWrapperArray(int... ints) {
        IntWrapper[] array = new IntWrapper[ints.length];

        for (int x = 0; x < ints.length; x++) {
            array[x] = new IntWrapper(ints[x]);
        }

        return array;
    }

}
