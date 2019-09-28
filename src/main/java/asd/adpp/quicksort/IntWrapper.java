package asd.adpp.quicksort;

public class IntWrapper implements Comparable<IntWrapper> {

    private final Integer value;

    public IntWrapper(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int compareTo(IntWrapper o) {
        return this.value.compareTo(o.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof IntWrapper)) {
            return false;
        }

        IntWrapper obj = (IntWrapper) o;

        return obj.value.equals(this.value);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + value;
        return result;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
