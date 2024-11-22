package DSA.Hw3_22000123_NguyenDucSi.bai_tap_5;

import java.util.Scanner;

public class Ex2 {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;
    static Node tail = null;
    static int size = 0;

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node delete(Node head, int pos) {
        if (pos == 0) {
            return head.next;
        }

        Node temp = head;
        if(pos >= size) {
            pos = size - 1;
        }

        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        if (temp == null || temp.next == null) {
            return head;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            if (head == null) {
                head = new Node(data);
                tail = head;
            } else {
                tail.next = new Node(data);
                tail = tail.next;
            }
            size++;
        }

        int k = sc.nextInt();

        head = delete(head, k);
        printList(head);
    }
}
