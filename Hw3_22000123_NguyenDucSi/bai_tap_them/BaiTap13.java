package DSA.Hw3_22000123_NguyenDucSi.bai_tap_them;

public class BaiTap13 {
    static class Node {
        int coeff;
        int pow;
        Node next;

        public Node(int a, int b) {
            coeff = a;
            pow = b;
            next = null;
        }
    }

    public static Node addPolynomial(Node head1, Node head2) {
        Node res;
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        if(head2.pow > head1.pow) {
            res = head2;
            head2 = head2.next;
        } else if(head1.pow > head2.pow){
            res = head1;
            head1 = head1.next;
        } else {
            res = head1;
            res.coeff += head2.coeff;
            head1 = head1.next;
            head2 = head2.next;
        }

        Node cur = res;
        while(head1 != null && head2 != null) {
            if(head2.pow > head1.pow) {
                cur.next = head2;
                head2 = head2.next;
            } else if(head1.pow > head2.pow){
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head1;
                cur.next.coeff += head2.coeff;
                head1 = head1.next;
                head2 = head2.next;
            }
            cur = cur.next;
        }

        while(head1 != null) {
            cur.next = head1;
            cur = cur.next;
            head1 = head1.next;
        }
        while(head2 != null) {
            cur.next = head2;
            cur = cur.next;
            head2 = head2.next;
        }
        return res;
    }

}
