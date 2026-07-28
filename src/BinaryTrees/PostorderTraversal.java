package BinaryTrees;

// Visit the node after both children. left->right->node.
public class PostorderTraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
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

        postorderTraversal(node);
    }

    public static void postorderTraversal(Node root) {
        //Base case.
        if(root == null) {
            return;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data+" ");
    }
}
