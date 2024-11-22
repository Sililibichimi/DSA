package DSA.Hw3_22000123_NguyenDucSi.bai_tap_them;

import java.util.Scanner;

public class BaiTap10 {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node reverse(Node head) {
        Node cur = head;
        Node prev = null;

        while(cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;
        Node tail = null;

        for(int i = 0; i < n; i++) {
            int data = sc.nextInt();
            if(head == null) {
                head = new Node(data);
                tail = head;
            } else {
                tail.next = new Node(data);
                tail = tail.next;
            }
        }

        System.out.print("Before reverse: ");
        printList(head);
        System.out.println();
        System.out.print("After reverse: ");
        tail = head;
        head = reverse(head);
        printList(head);
    }

}
