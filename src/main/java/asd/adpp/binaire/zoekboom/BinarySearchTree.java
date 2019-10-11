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

    public Node find(int value) {
        if (root != null) {
            return this.findNode(root, value);
        } else {
            return null;
        }
    }

    private Node findNode(Node root, int value) {
        if (value != root.getValue()) {
            if (value < root.getValue()) {
                root = root.getLeftNode();
            } else {
                root = root.getRightNode();
            }
            return findNode(root, value);
        } else {
            return root;
        }
    }

    public Node findMin() {
        if (root != null) {
            Node node = root;

            while (node != null && node.getLeftNode() != null) {
                node = node.getLeftNode();
            }

            return node;
        } else {
            return null;
        }
    }

    public Node findMax() {
        if (root != null) {
            Node node = root;

            while (node != null && node.getRightNode() != null) {
                node = node.getRightNode();
            }

            return node;
        } else {
            return null;
        }
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
