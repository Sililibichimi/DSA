package DSA.Hw7_22000123_NguyenDucSi.Baitapthem.A.Hw7_22000123_NguyenDucSi.Baitapthem.B;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

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

        ArrayList<Integer> levelOrder() {
            ArrayList<Integer> result = new ArrayList<>();
            levelOrder(root, result);
            return result;
        }

        private void levelOrder(Node root, ArrayList<Integer> result) {
            if (root != null) {
                Queue<Node> queue = new LinkedList<>();
                queue.add(root);
                while (!queue.isEmpty()) {
                    Node current = queue.poll();
                    result.add(current.value);
                    if (current.left != null) {
                        queue.add(current.left);
                    }
                    if (current.right != null) {
                        queue.add(current.right);
                    }
                }
            }
        }
    }

}
