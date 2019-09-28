package asd.adpp.quicksort;

public class NewInteger implements Comparable<NewInteger> {

    private final Integer value;

    public NewInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int compareTo(NewInteger o) {
        return this.value.compareTo(o.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NewInteger)) {
            return false;
        }

        NewInteger obj = (NewInteger) o;

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
