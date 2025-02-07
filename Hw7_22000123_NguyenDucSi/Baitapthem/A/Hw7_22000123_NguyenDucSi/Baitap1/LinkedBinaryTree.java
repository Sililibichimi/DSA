package DSA.Hw7_22000123_NguyenDucSi.Baitapthem.A.Hw7_22000123_NguyenDucSi.Baitap1;

import java.io.FileWriter;

public class LinkedBinaryTree<E, T> implements BinaryTreeInterface<T> {
    protected static class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E e, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
            this.element = e;
            this.parent = parent;
            this.left = leftChild;
            this.right = rightChild;
        }

    }

    private Node<E> root = null;
    private int size = 0;

    public LinkedBinaryTree() {
    }

    public Node<E> addRoot(E element) {
        if (root != null) throw new IllegalStateException("Tree is not empty");
        root = new Node<>(element, null, null, null);
        size++;
        return root;
    }

    public Node<E> addRoot(Node<E> node) {
        if (root != null) throw new IllegalStateException("Tree is not empty");
        root = node;
        size++;
        return root;
    }

    public Node<E> addLeft(Node<E> p, E element) {
        if (p.left != null) throw new IllegalStateException("Left child exists");
        p.left = new Node<>(element, p, null, null);
        size++;
        return p.left;
    }

    public Node<E> addRight(Node<E> p, E element) {
        if (p.right != null) throw new IllegalStateException("Right child exists");
        p.right = new Node<>(element, p, null, null);
        size++;
        return p.right;
    }

    public Node<E> getRoot() {
        return root;
    }

    public Node<E> getLeft(Node<E> p) {
        return p.left;
    }

    public Node<E> getRight(Node<E> p) {
        return p.right;
    }

    public Node<E> getParent(Node<E> p) {
        return p.parent;
    }

    public void setParent(Node<E> p, Node<E> parent) {
        p.parent = parent;
    }

    public void setLeft(Node<E> p, Node<E> left) {
        p.left = left;
    }

    public void setRight(Node<E> p, Node<E> right) {
        p.right = right;
    }

    public E getElement(Node<E> p) {
        return p.element;
    }

    public void set(Node<E> p, E element) {
        p.element = element;
    }

    @Override
    public T root() {
        return (T) root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int numChildren(T p) {
        Node<E> node = (Node<E>) p;
        int count = 0;
        if (node.left != null) count++;
        if (node.right != null) count++;
        return count;
    }

    @Override
    public T parent(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.parent;
    }

    @Override
    public T left(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.left;
    }

    @Override
    public T right(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.right;
    }

    @Override
    public T sibling(T p) {
        Node<E> node = (Node<E>) p;
        if (node.parent == null) return null;
        if (node.parent.left == node) return (T) node.parent.right;
        return (T) node.parent.left;
    }

    public void print(FileWriter writer) {
        try {
            writer.write("Using LinkedBinaryTree\n");
            printH(root, 0, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printH(Node<E> root, int level, FileWriter writer) {

        try {
            if (root == null) return;
            printH(root.right, level + 1, writer);
            for (int i = 0; i < level; i++) {
                writer.write("      ");
            }
            writer.write(root.element + "\n");
            printH(root.left, level + 1, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
