package DSA.Hw3_22000123_NguyenDucSi.bai_tap_them;

public class BaiTap16 {
    class Node{
        int data;
        Node next;

        Node(int x){
            data = x;
            next = null;
        }

    }


    void printList(Node head)
    {
        Node cur = head;
        System.out.print(cur.data + " ");
        cur = cur.next;
        while(cur != head) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    boolean isCircular(Node head) {
        // Your code here
        if(head == null) return true;
        Node cur = head;
        cur = cur.next;
        while(cur != null && cur != head) {
            cur = cur.next;
        }
        return cur != null;
    }
    public Node sortedInsert(Node head, int data) {

        Node newNode = new Node(data);
        if(head == null) {
            newNode.next = newNode;
            return newNode;
        }
        if(head.data >= data) {
            Node last = head;
            while(last.next != head) {
                last = last.next;
            }
            last.next = newNode;
            newNode.next = head;
            return newNode;
        }
        Node cur = head;
        while(cur.next != head && cur.next.data < data) {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;

        return head;
    }

    Node reverse(Node head) {
        if(head == null) return null;
        Node prev = head;
        Node next = head.next;

        while (next != head) {
            Node temp = next.next;
            next.next = prev;
            prev = next;
            next = temp;
        }
        next.next = prev;
        return prev;
    }

    // Function to delete a node from the circular linked list
    Node deleteNode(Node head, int key) {
        Node cur = head;
        Node prev = null;
        while (cur.data != key && cur.next != head) {
            prev = cur;
            cur = cur.next;
        }

        if(cur.data != key) return head;
        if(cur == head) {
            prev = head;
            while(prev.next != head) {
                prev = prev.next;
            }
            head = head.next;
            prev.next = head;
        } else {
            prev.next = cur.next;
        }

        return head;
    }

}
