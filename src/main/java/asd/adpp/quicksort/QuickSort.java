package asd.adpp.quicksort;

import java.util.Random;

/**
 * Generic QuickSort for all classes that implement the Comparable interface
 */
public class QuickSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

    private T[] array;

    private final Random random = new Random();

    @Override
    public void sort(T[] input) {
        if (input == null || input.length == 0) return;

        this.array = input;
        quickSort(0, input.length - 1);
    }

    private void quickSort(final int startIndex, final int endIndex) {
        // Random pivot selection
        final int randomIndex = random.nextInt(endIndex - startIndex) + startIndex;
        final T pivot = array[randomIndex];

        int leftIndex = startIndex;
        int rightIndex = endIndex;

        while (leftIndex <= rightIndex) {
            while (array[leftIndex].compareTo(pivot) < 0) leftIndex++;
            while (array[rightIndex].compareTo(pivot) > 0) rightIndex--;

            if (leftIndex <= rightIndex) {
                final T temp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = temp;

                leftIndex++;
                rightIndex--;
            }
        }

        if (startIndex < rightIndex) quickSort(startIndex, rightIndex);
        if (leftIndex < endIndex) quickSort(leftIndex, endIndex);
    }

}
