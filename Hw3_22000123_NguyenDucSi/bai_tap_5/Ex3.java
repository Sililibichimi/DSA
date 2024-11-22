package DSA.Hw3_22000123_NguyenDucSi.bai_tap_5;

import java.util.Scanner;
public class Ex3 {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }
    }

    static Node head = null;
    static Node tail = null;
    static int size = 0;

    public static Node valueOf(int index) {
        if(index >= size) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
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
        Node temp = valueOf(k);
        System.out.println(temp.getData());
    }
}
