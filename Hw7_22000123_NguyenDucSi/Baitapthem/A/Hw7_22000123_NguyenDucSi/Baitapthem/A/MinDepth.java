package DSA.Hw7_22000123_NguyenDucSi.Baitapthem.A.Hw7_22000123_NguyenDucSi.Baitapthem.A;

public class MinDepth {
    static class Node {
        int value;
        Node left, right;

        public Node(int item) {
            value = item;
            left = right = null;
        }
    }
    Node root;
    public class Tree {
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

        int minDepth(Node root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            if (root.left == null) {
                return minDepth(root.right) + 1;
            }
            if (root.right == null) {
                return minDepth(root.left) + 1;
            }
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
