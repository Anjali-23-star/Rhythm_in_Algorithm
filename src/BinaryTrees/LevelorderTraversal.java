package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelorderTraversal {
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

        levelOrderTraversal(node);
    }

    public static void levelOrderTraversal(Node root) {
        /**
         * For level order traversal, we print node at each level.
         *
         * We use the concept of queue since its FIFO. So, once the node is popped, the children are always pushed back to
         * queue.
         *
         * TIME COMPLEXITY: O(N)
         * SPACE COMPLEXITY: O(N)
         */
        Queue<Node> queue = new LinkedList();

        queue.offer(root);

        while(!queue.isEmpty()) {
            Node current = queue.poll();

            System.out.println(current.data+" ");

            if(current.left !=null) {
                queue.offer(current.left);
            }

            if(current.right != null) {
                queue.offer(current.right);
            }
        }


    }
}
