package DSA.Hw3_22000123_NguyenDucSi.bai_tap_them;

import java.util.Scanner;

public class BaiTap6 {
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

    public static int getSize(Node head) {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
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
        }

        int k = sc.nextInt();

        int size = getSize(head);
        System.out.println(size);
    }
}
