package BinaryTrees;

// Visit the node after the left child but before the right child. left->node->right
public class InorderTraversal {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);

        node.left = new Node(2);
        node.right = new Node(3);

        node.right.left = new Node(4);
        node.right.left.left = new Node(5);

        node.right.right = new Node(6);

        inorderTraversal(node);
    }

    public static void inorderTraversal(Node node) {
        // Base case.
        if(node == null) {
            return;
        }

        inorderTraversal(node.left);
        System.out.println(node.data+ " ");
        inorderTraversal(node.right);
    }
}
