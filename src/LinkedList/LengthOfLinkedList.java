package LinkedList;

// Given the head of a linked list, print the length of the linked list.
public class LengthOfLinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2};
        Node head = arrayToLinkedList(arr);

        length(head);

    }

    public static Node arrayToLinkedList(int[] arr) {
        //Head will always point toward the first node.
        Node head = new Node(arr[0]);
        Node mover = head;

        for(int i=1;i<arr.length;i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;

            mover = temp;
        }

        return head;
    }

    public static void length(Node head) {
        Node temp = head;
        int count = 0;
        while(temp!=null) {
            count++;

            temp = temp.next;
        }

        System.out.println("Count: "+count);
    }
}
