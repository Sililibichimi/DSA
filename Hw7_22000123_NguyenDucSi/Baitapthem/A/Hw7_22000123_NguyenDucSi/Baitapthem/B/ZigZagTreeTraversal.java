package DSA.Hw7_22000123_NguyenDucSi.Baitapthem.A.Hw7_22000123_NguyenDucSi.Baitapthem.B;

public class ZigZagTreeTraversal {
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

        void zigZag() {
            zigZag(root);
        }

        private void zigZag(Node root) {
            if (root == null) {
                return;
            }

            boolean leftToRight = true;
            int height = height(root);
            for (int i = 1; i <= height; i++) {
                printLevel(root, i, leftToRight);
                leftToRight = !leftToRight;
            }
        }

        private void printLevel(Node root, int level, boolean leftToRight) {
            if (root == null) {
                return;
            }

            if (level == 1) {
                System.out.print(root.value + " ");
            } else if (level > 1) {
                if (leftToRight) {
                    printLevel(root.left, level - 1, leftToRight);
                    printLevel(root.right, level - 1, leftToRight);
                } else {
                    printLevel(root.right, level - 1, leftToRight);
                    printLevel(root.left, level - 1, leftToRight);
                }
            }
        }

        private int height(Node root) {
            if (root == null) {
                return 0;
            } else {
                int leftHeight = height(root.left);
                int rightHeight = height(root.right);

                if (leftHeight > rightHeight) {
                    return leftHeight + 1;
                } else {
                    return rightHeight + 1;
                }
            }
        }
    }
}
