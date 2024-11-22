package DSA.Hw3_22000123_NguyenDucSi.bai_tap_them;

public class BaiTap12 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode res = head;
        while (next != null) {
            if(head.val == next.val) {
                head.next = next.next;
                next = next.next;
            } else {
                head = head.next;
                next = next.next;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int data = 10;
        ListNode node1 = new ListNode(10);
        System.out.println(node1.val);
        ListNode node2 = node1;
        node2.val = 15;
        System.out.println(node1.val);
        System.out.println(node2.val);
    }
}

