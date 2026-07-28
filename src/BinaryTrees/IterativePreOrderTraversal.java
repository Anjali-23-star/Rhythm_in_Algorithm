package BinaryTrees;

import LinkedList.LinkedList;

import java.util.Stack;

// Pre order: Node->Left->Right.
// Iterative: Instead of recursive call, we use stack.
// We use stack because it operates on LIFO. So, as we add on children, first they will be printed and
// then we will further go to the rigth side and do the same.
public class IterativePreOrderTraversal {
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

        iterativePreOrderTraversal(node);
    }

    public static void iterativePreOrderTraversal(Node root) {
        /**
         * TIME COMPLEXITY: O(N)
         * SPACE COMPLEXITY: O(N)
         */
        // Empty tree.
        if(root==null) {
            return;
        }

        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()) {
            var currentNode = stack.pop();

            System.out.println(currentNode.data);

            // Fill up with right node first, because stack is LIFO so, we want the left node to pop first, so we will put right first
            // and then left second.
            if(currentNode.right != null) {
                stack.push(currentNode.right);
            }

            if(currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
    }
}
