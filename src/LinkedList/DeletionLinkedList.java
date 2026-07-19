package LinkedList;

// Given a linked list, delete the tail of the list and print the updated list.
public class DeletionLinkedList {
    static class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        int [] arr = {10, 20, 30};

        // convert into linkedlist.
        Node head = arrayToLinkedList(arr);
        System.out.println("Original: ");
        print(head);

        head = deleteHead(head);

        System.out.println("After deleting head.");
        print(head);
    }


    public static Node deleteHead(Node head) {
        if(head == null) {
            return null;
        }

        head = head.next;

        return head;
    }

    public static Node arrayToLinkedList(int[] arr) {
        // First node.
        Node head = new Node(arr[0]);

        // Pointer used to build the list.
        Node mover = head;

        // Create remaining nodes.
        for(int i=1;i<arr.length;i++) {
            Node temp = new Node(arr[i]);

            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    public static void print(Node head) {
        while(head!=null) {
            System.out.println(head.data+"->");
            head = head.next;
        }
    }
}
