package DSA.Hw3_22000123_NguyenDucSi.bai_tap_them;

public class BaiTap9 {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static int count(Node head, int key) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                count++;
            }
            temp = temp.next;
        }
        return count;
    }
}
