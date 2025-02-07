package DSA.Hw7_22000123_NguyenDucSi.Baitapthem.A.Hw7_22000123_NguyenDucSi.Baitapthem.Luyentap1;

import java.util.Scanner;

public class Bai3 {
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

            if (value < root.value) {
                root.left = insert(root.left, value);
            } else {
                root.right = insert(root.right, value);
            }

            return root;
        }

        int treeHeight() {
            return height(root);
        }

        private int height(Node node) {
            if (node == null) {
                return 0;
            }
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
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

        System.out.println(tree.treeHeight() - 1);

        sc.close();
    }
}



