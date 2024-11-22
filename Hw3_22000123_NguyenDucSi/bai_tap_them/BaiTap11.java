package DSA.Hw3_22000123_NguyenDucSi.bai_tap_them;

import java.util.List;

public class BaiTap11 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = null;
        ListNode next = null;

        while (head != null) {
            next = new ListNode(head.val);
            head = head.next;
            next.next = cur;
            cur = next;
        }
        return next;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode tail = reverse(head);
        while (head != null) {
            if(head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }
}
