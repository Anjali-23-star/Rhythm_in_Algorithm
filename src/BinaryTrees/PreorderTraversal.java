package BinaryTrees;

// Preorder: Visit the node before its children.  Node->left->right.
public class PreorderTraversal {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        /**
         * We are creating a tree structure first.
         */
        Node root = new Node(4);

        root.left = new Node(2);
        root.right = new Node(5);

        root.left.left = new Node(3);
        root.right.left = new Node(7);
        root.right.right = new Node(6);

        root.left.left.right = new Node(9);
        root.right.right.left = new Node(8);

        root.left.left.right.left = new Node(1);

        preorder(root);
    }

    public static void preorder(Node root) {
        /**
         * IDEA:
         *      Preorder visits the root first. It then visit the left node and then the right node.
         *
         *      TIME COMPLEXITY: O(N)
         *      SPACE COMPLEXITY: O(N),
         */

        //Base case.
        if(root == null) {
            return;
        }

        // Visit the node.
        System.out.print(root.data+" ");

        preorder(root.left);
        preorder(root.right);
    }
}
