import asd.adpp.binaire.zoekboom.BinarySearchTree;
import asd.adpp.binaire.zoekboom.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class BinarySearchTreeTest {

    @Test
    public void insertRootInNewTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(1);
        Node expectedNode = new Node(1);

        assertEquals(expectedNode, binarySearchTree.getRoot());
    }

    @Test
    public void insertInPopulatedTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node5 = new Node(5);
        Node node4 = new Node(4);

        List<Node> expectedNodes = new ArrayList<>();
        expectedNodes.add(node1);
        expectedNodes.add(node3);
        expectedNodes.add(node2);
        expectedNodes.add(node5);
        expectedNodes.add(node4);
        expectedNodes.sort(Comparator.comparingInt(Node::getValue));

        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);

        assertEquals(node1, binarySearchTree.getRoot());
        assertEquals(expectedNodes, binarySearchTree.getAllNodes(binarySearchTree.getRoot()));
    }

    @Test
    public void find() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);

        Node expectedNode = new Node(3);
        Node foundNode = binarySearchTree.find(3);

        assertEquals(expectedNode, foundNode);
    }

    @Test
    public void findMin() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);

        Node expectedNode = new Node(1);
        Node foundNode = binarySearchTree.findMin();

        assertEquals(expectedNode, foundNode);
    }

    @Test
    public void findMax() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);

        Node expectedNode = new Node(5);
        Node foundNode = binarySearchTree.findMax();

        assertEquals(expectedNode, foundNode);
    }

    @Test
    public void removeChildNode() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);

        Node expectedNode = new Node(5);
        Node foundNode = binarySearchTree.find(5);
        assertEquals(expectedNode, foundNode);

        binarySearchTree.remove(5);

        foundNode = binarySearchTree.find(5);
        assertNull(foundNode);
    }

    // TODO fails with 1 as root
    @Test
    public void removeRootNode_todo() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);

        Node expectedRootNode = new Node(1);
        Node actualRootNode = binarySearchTree.getRoot();
        assertEquals(expectedRootNode, actualRootNode);
        System.out.println(binarySearchTree);

        binarySearchTree.remove(1);

        System.out.println(binarySearchTree);

        Node expectedNewRootNode = new Node(2);
        Node actualNewRootNode = binarySearchTree.getRoot();
        assertEquals(expectedNewRootNode, actualNewRootNode);
    }

    @Test
    public void removeRootNode() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(3);
        binarySearchTree.insert(1);
        binarySearchTree.insert(2);
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);

        Node expectedRootNode = new Node(3);
        Node actualRootNode = binarySearchTree.getRoot();
        assertEquals(expectedRootNode, actualRootNode);
        System.out.println(binarySearchTree);

        binarySearchTree.remove(3);

        System.out.println(binarySearchTree);

        Node expectedNewRootNode = new Node(4);
        Node actualNewRootNode = binarySearchTree.getRoot();
        assertEquals(expectedNewRootNode, actualNewRootNode);
    }

}
