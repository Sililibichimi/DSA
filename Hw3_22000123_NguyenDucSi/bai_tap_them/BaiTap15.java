package DSA.Hw3_22000123_NguyenDucSi.bai_tap_them;

public class BaiTap15 {
    class Node{
        int data;
        Node next, prev;
        Node(int data){
            this.data = data;
            next = null;
            prev = null;
        }
    }

    public Node rotateDLL(Node start, int p) {

        Node curr=start;
        Node temp=start;
        Node x;
        int count=1;

        while(count<p){
            curr=curr.next;
            count++;
        }

        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=start;
        start.prev=temp;
        x=curr.next;
        curr.next.prev=null;
        curr.next=null;
        return  x;
    }
}
