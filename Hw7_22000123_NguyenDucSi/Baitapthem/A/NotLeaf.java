package DSA.Hw7_22000123_NguyenDucSi.Baitapthem.A;

public class NotLeaf {

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

        int countNonLeafNodes(Node root) {

            if (root == null || (root.left == null && root.right == null)) {
                return 0;
            }

            return 1 + countNonLeafNodes(root.left) + countNonLeafNodes(root.right);
        }


    }


}
