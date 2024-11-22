package DSA.Hw3_22000123_NguyenDucSi.bai_tap_them;

public class BaiTap14 {
    class Node
    {
        int data;
        Node next;
        Node prev;
        Node(int data)
        {
            this.data = data;
            next = prev = null;
        }
    }

    Node addNode (Node head, int p, int x) {
        Node res = head;
        Node newNode = new Node(x);
        if(p == 0) {
            newNode.next = head;
            head.prev = newNode;
            res = newNode;
        }
        for(int i = 0; i < p; ++i) {
            head = head.next;
        }
        Node next = head.next;

        if(next == null) {
            head.next = newNode;
            newNode.prev = head;
        } else {
            newNode.next = head.next;
            head.next = newNode;
            head.next.next.prev = newNode;
            newNode.prev = head;
        }
        return res;
    }

    public Node deleteNode(Node head, int x) {
        --x;
        Node res = head;
        if(x == 0) {
            head = head.next;
            return head;
        }
        for(int i = 0; i < x; ++i) {
            head = head.next;
        }
        if(head.next == null ) {
            head.prev.next = null;
        } else {
            Node temp = head.prev;
            head.prev.next = head.next;
            head.next.prev = temp;
        }
        return res;
    }

    public Node sortedInsert(Node head, int x) {
        Node res = head;
        Node newNode = new Node(x);
        if(head == null) {
            return newNode;
        }
        boolean last = false;
        while (x > head.data) {
            if(head.next == null) {
                last = true;
                break;
            }
            head = head.next;
        }
        if(head.prev == null && x <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            res = newNode;
        } else if(last) {
            head.next = newNode;
            newNode.prev = head;
        } else {
            head = head.prev;
            newNode.next = head.next;
            head.next = newNode;
            head.next.next.prev = newNode;
            newNode.prev = head;
        }

        return res;
    }
}
