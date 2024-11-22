package DSA.Hw3_22000123_NguyenDucSi.bai_tap_them;

public class BaiTap17 {
    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    class Pair<F, S> {
        public final F first;
        public final S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }

    public Pair<Node, Node> splitList(Node head) {
        if (head == null || head.next == head) {
            return new Pair<>(head, head);
        }
        Node first = head;
        Node second = head;

        while (second.next != head && second.next.next != head) {
            first = first.next;
            second = second.next.next;
        }

        Node head1 = head;
        Node head2 = first.next;

        first.next = head1;
        second = head2;

        while (second.next != head) {
            second = second.next;
        }
        second.next = head2;

        return new Pair<>(head1, head2);
    }
}
