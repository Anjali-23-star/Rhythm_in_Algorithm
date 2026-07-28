package LinkedList;

// Search an element in linked list.
public class SearchElementInLinkedList {
    static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int [] arr = {0, 1, 2};

        Node head = arrayToLinkedList(arr);

        System.out.println(search(head, 3));
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

    public static boolean search(Node head, int target) {
        Node temp = head;

        while(temp!=null) {
            if(temp.data == target) {
                return true;
            }

            temp=temp.next;
        }

        return false;
    }
}
