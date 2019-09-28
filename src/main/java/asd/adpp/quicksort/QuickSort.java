package asd.adpp.quicksort;

public class QuickSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

    private T[] array;

    @Override
    public void sort(T[] input) {
        if (input == null || input.length == 0) {
            return;
        }

        this.array = input;
        quickSort(0, input.length - 1);
    }

    private void quickSort(int startIndex, int endIndex) {
        final T pivot = array[startIndex + (endIndex - startIndex) / 2];

        int leftIndex = startIndex;
        int rightIndex = endIndex;

        while (leftIndex <= rightIndex) {
            while (array[leftIndex].compareTo(pivot) < 0) {
                leftIndex++;
            }

            while (array[rightIndex].compareTo(pivot) > 0) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                T temp = array[leftIndex];
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
