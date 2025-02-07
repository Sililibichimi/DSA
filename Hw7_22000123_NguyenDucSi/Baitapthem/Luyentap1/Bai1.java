package DSA.Hw7_22000123_NguyenDucSi.Baitapthem.Luyentap1;
/*
Cho một dãy n số nguyên.
Hãy cài đặt các số trong dãy đó vào kiểu dữ liệu cây.
In cây theo cách duyệt trung thứ tự (xem lý thuyết).
Sau mỗi phần tử có đúng một khoảng trắng.
 */

import java.util.Scanner;

public class Bai1 {

    static class Node {
        int value;
        Node left, right;

        public Node(int item) {
            value = item;
            left = right = null;
        }
    }


    static class Tree {
        Node root;

        public Tree() {
            root = null;
        }

        void insert(int value) {
            root = insert(root, value);
        }

        private Node insert(Node root, int value) {
            if (root == null) {
                root = new Node(value);
                return root;
            }

            if (value <= root.value) {
                root.left = insert(root.left, value);
            } else if (value > root.value) {
                root.right = insert(root.right, value);
            }

            return root;
        }

        void inorder() {
            print(root);
        }

        private void print(Node root) {
            if (root != null) {
                print(root.left);
                System.out.print(root.value + " ");
                print(root.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Tree tree = new Tree();

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            tree.insert(value);
        }

        tree.inorder();
        sc.close();
    }
}