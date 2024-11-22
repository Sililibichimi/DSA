package DSA.Hw3_22000123_NguyenDucSi.bai_tap_5;

/*
Nhập vào một số nguyên dương n,
 tiếp theo là n số nguyên của một dãy số,
 hãy cài đặt nó vào một danh sách liên kết đơn.
Tiếp theo nhập hai số nguyên k và x, (0 ≤ k ≤ n),
hãy chèn giá trị x vào danh sách liên kết tại chỉ số k và in ra màn hình danh sách đó,
sau một phần tử có một khoảng trắng.
 */

import java.util.Scanner;

public class Ex1 {

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

    public static Node insert(Node head, int data, int pos) {
        Node newNode = new Node(data);
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }

        if (pos == size) {
            tail.next = newNode;
            tail = tail.next;
            return head;
        }

        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
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
                head = insert(head, data, size);
            }
            size++;
        }

        int k = sc.nextInt();
        int x = sc.nextInt();
        head = insert(head, x, k);
        printList(head);
    }

}
