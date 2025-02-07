package DSA.Hw7_22000123_NguyenDucSi.Baitapthem.A.Hw7_22000123_NguyenDucSi.Baitapthem.B;

import java.util.ArrayList;

public class Inoder {

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

        ArrayList<Integer> inOrder() {
            ArrayList<Integer> result = new ArrayList<>();
            inOrder(root, result);
            return result;
        }

        private void inOrder(Node root, ArrayList<Integer> result) {
            if (root != null) {
                inOrder(root.left, result);
                result.add(root.value);
                inOrder(root.right, result);
            }
        }
    }
}
