package asd.adpp.binaire.zoekboom;

public class Node {

    private int value;

    private Node leftNode;
    private Node rightNode;

    Node(int value) {
        this.value = value;
    }

    int getValue() {
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

}
