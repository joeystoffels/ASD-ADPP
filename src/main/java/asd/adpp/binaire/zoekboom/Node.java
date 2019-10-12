package asd.adpp.binaire.zoekboom;

public class Node {

    private int value;

    private Node leftNode;
    private Node rightNode;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }

    Node getLeftNode() {
        return leftNode;
    }

    void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    Node getRightNode() {
        return rightNode;
    }

    void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "" + this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Node)) {
            return false;
        }

        Node obj = (Node) o;

        return obj.value == this.value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + value;
        return result;
    }

}
