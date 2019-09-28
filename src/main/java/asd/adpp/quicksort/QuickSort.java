package asd.adpp.quicksort;

public class QuickSort implements SortingAlgorithm {

    private int[] array;

    @Override
    public void sort(int[] input) {

        if (input == null || input.length == 0) {
            return;
        }

        this.array = input;
        quickSort(0, input.length - 1);
    }

    private void quickSort(int startIndex, int endIndex) {
        final int pivot = array[startIndex + (endIndex - startIndex) / 2];

        int leftNr = startIndex;
        int rightNr = endIndex;

        // Divide into two arrays
        while (leftNr <= rightNr) {

            // In each iteration, we will identify a number from left side which
            // is greater then the pivot value, and also we will identify a number
            // from right side which is less then the pivot value. Once the search
            // is done, then we exchange both numbers.

            while (array[leftNr] < pivot) {
                leftNr++;
            }

            while (array[rightNr] > pivot) {
                rightNr--;
            }

            if (leftNr <= rightNr) {
                swap(leftNr, rightNr);
                //move index to next position on both sides
                leftNr++;
                rightNr--;
            }
        }

        if (startIndex < rightNr) {
            quickSort(startIndex, rightNr);
        }

        if (leftNr < endIndex) {
            quickSort(leftNr, endIndex);
        }

    }

    private void swap(int first, int second) {
        final int firstValue = array[first];
        array[first] = array[second];
        array[second] = firstValue;
    }

}
