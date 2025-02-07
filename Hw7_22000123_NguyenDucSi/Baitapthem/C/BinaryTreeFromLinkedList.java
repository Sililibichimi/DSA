package DSA.Hw7_22000123_NguyenDucSi.Baitapthem.C;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeFromLinkedList {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int x) {
            data = x;
            left = null;
            right = null;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static class Tree {
        int data;
        Tree left;
        Tree right;

        Tree(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    public Tree linkedListToBinaryTree(Node head) {
        Queue<Tree> myQueue = new LinkedList<>();
        Tree node = new Tree(head.data);
        Node temp = head.next;
        Tree temp2 = node;
        int y = 1;
        while(temp != null){
            if((y&1) == 1){
                temp2.left = new Tree(temp.data);
                myQueue.add(temp2.left);
            }else{
                temp2.right = new Tree(temp.data);
                myQueue.add(temp2.right);
                temp2 = myQueue.poll();
            }
            temp = temp.next;
            y++;
        }
        return node;
    }
}
