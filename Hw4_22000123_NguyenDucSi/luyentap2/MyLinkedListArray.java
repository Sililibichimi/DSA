package DSA.Hw4_22000123_NguyenDucSi.luyentap2;

public class MyLinkedListArray {
     class StackNode {
         int data;
         StackNode next;
         StackNode(int a) {
             data = a;
             next = null;
         }
     }
    StackNode top;

    void push(int a) {
        StackNode node = new StackNode(a);
        node.next = top;
        top = node;
    }

    int pop() {
        if(top == null) return -1;
        int data = top.data;
        top = top.next;
        return data;
    }
}
