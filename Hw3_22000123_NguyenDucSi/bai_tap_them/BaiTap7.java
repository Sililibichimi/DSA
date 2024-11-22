package DSA.Hw3_22000123_NguyenDucSi.bai_tap_them;

public class BaiTap7 {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    public int get(int index) {
        if(index < 0 || index >= size) {
            return -1;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public Node getNode(int index) {
        if(index >= size) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        if(tail == null) {
            tail = head;
        }
        size++;
    }

    public void addAtTail(int val) {
        if(head == null) {
            addAtHead(val);
            return;
        }
        tail.next = new Node(val);
        tail = tail.next;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) {
            return;
        }

        if(index == 0) {
            addAtHead(val);
            return;
        }

        if(index == size) {
            addAtTail(val);
            return;
        }

        Node temp = getNode(index - 1);
        Node newNode = new Node(val);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) {
            return;
        }

        if(size == 0) {
            head = null;
            tail = null;
            return;
        }

        if(index == 0) {
            head = head.next;
            size--;
            return;
        }

        if(index == size - 1) {
            Node prev = getNode(index - 1);
            prev.next = null;
            --size;
            tail = prev;
            return;
        }

        Node temp = getNode(index - 1);
        temp.next = temp.next.next;
        size--;
    }
}
