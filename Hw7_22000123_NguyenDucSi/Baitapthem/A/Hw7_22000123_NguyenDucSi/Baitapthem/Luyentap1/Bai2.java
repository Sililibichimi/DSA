package DSA.Hw7_22000123_NguyenDucSi.Baitapthem.A.Hw7_22000123_NguyenDucSi.Baitapthem.Luyentap1;

import java.util.Scanner;

public class Bai2 {


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

        int countLeafNodes() {
            return count(root);
        }

        private int count(Node root) {
            if (root == null) {
                return 0;
            }

            if (root.left == null && root.right == null) {
                return 1;
            }
            return count(root.left) + count(root.right);
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

        System.out.println(tree.countLeafNodes());

        sc.close();
    }

}
