package asd.adpp.quicksort;

public class Weight implements Comparable<Weight> {

    private final Integer value;

    public Weight(int value) {
        this.value = value;
    }

    private int getValue() {
        return this.value;
    }

    @Override
    public int compareTo(Weight o) {
        return this.value.compareTo(o.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Weight)) {
            return false;
        }

        Weight obj = (Weight) o;

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
