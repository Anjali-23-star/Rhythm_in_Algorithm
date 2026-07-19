package LinkedList;

public class InsertInLinkedList {

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

        int[] arr = {0,1,2};
        // Convert to linked list.
        Node head = arrayToLinkedList(arr);
        System.out.println("Original: ");
        print(head);

        head = insertNode(head, 5);
        print(head);
    }

    public static Node arrayToLinkedList(int[] arr) {
        // Head will always point toward the first node.
        Node head = new Node(arr[0]);
        Node mover = head;

        for(int i=1;i<arr.length;i++) {
           Node temp = new Node(arr[i]);
           mover.next = temp;

           mover = temp;

        }
        return head;
    }

    public static Node insertNode(Node head, int num) {
        Node temp = head;
        head = new Node(num);
        head.next = temp;

        return head;
    }

    // Printing the ll.
    public static void print(Node head) {
        while(head!= null) {
            System.out.print(head.data+"-> ");

            head = head.next;
        }
    }
}
