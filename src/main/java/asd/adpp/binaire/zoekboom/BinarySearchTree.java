package asd.adpp.binaire.zoekboom;

public class BinarySearchTree {

    private Node root;

    public void insert(int value) {
        root = insertValue(root, value);
    }

    private Node insertValue(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.getValue()) {
            root.setLeftNode(insertValue(root.getLeftNode(), value));
        } else if (value > root.getValue()) {
            root.setRightNode(insertValue(root.getRightNode(), value));
        }

        return root;
    }

    public int findMin() {
        return 0;
    }

    public int findMax() {
        return 1;
    }

    public int find(int value) {
        return value;
    }

    public void remove(int value) {

    }

    @Override
    public String toString() {
        return this.toString(root);
    }

    private String toString(Node root) {
        StringBuilder sb = new StringBuilder();

        if (root != null) {
            sb.append(toString(root.getLeftNode()));
            sb.append(" ").append(root);
            sb.append(toString(root.getRightNode()));
        }
        return sb.toString();
    }

}
