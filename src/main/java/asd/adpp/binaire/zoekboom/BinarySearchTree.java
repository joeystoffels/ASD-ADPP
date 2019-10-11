package asd.adpp.binaire.zoekboom;

public class BinarySearchTree {

    private Node root;

    public void insert(int value) {
        if (this.root == null) this.root = new Node(value);
        insertValue(root, value);
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
        return this.findNode(root, value);
    }

    private Node findNode(Node root, int value) {
        if (root == null) return null;

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
        if (root == null) return null;

        Node node = root;

        while (node != null && node.getLeftNode() != null) {
            node = node.getLeftNode();
        }

        return node;
    }

    public Node findMax() {
        if (root == null) return null;

        Node node = root;

        while (node != null && node.getRightNode() != null) {
            node = node.getRightNode();
        }

        return node;
    }

    public void remove(int value) {
        removeNode(root, value);
    }

    private Node removeNode(Node root, int key) {
        if (root == null) return null;

        if (key < root.getValue())
            root.setLeftNode(removeNode(root.getLeftNode(), key));
        else if (key > root.getValue())
            root.setRightNode(removeNode(root.getRightNode(), key));
        else {
            if (root.getLeftNode() == null)
                return root.getRightNode();
            else if (root.getRightNode() == null)
                return root.getLeftNode();

            root.setValue(minValue(root.getRightNode()));
            root.setRightNode(removeNode(root.getRightNode(), root.getValue()));
        }

        return root;
    }

    private int minValue(Node root) {
        int minv = root.getValue();
        while (root.getLeftNode() != null) {
            minv = root.getLeftNode().getValue();
            root = root.getLeftNode();
        }
        return minv;
    }

    @Override
    public String toString() {
        return "ROOT: " + root + " : " + this.toString(root);
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
