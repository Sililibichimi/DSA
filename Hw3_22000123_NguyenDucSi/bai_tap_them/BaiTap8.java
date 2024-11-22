package DSA.Hw3_22000123_NguyenDucSi.bai_tap_them;

public class BaiTap8 {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    int getKthFromLast(Node head, int k) {
        Node cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        if (k > size) {
            return -1;
        }
        for(int i = 0; i < size - k; i++) {
            head = head.next;
        }
        return head.data;
    }

}
