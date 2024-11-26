package DSA.Hw7_22000123_NguyenDucSi.Baitap1;

public class ArrayBinaryTree<E,T> implements BinaryTreeInterface<T> {
    private E [] array;
    private int n = 0;
    private int default_size = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[default_size];
    }

    public void setRoot(E element) {
        array[1] = element;
        ++n;
    }

    public void setLeft(int p, E element) {
        array[2*p] = element;
        n = Math.max(n, 2*p);
    }

    public void setRight(int p, E element) {
        array[2*p+1] = element;
        n = Math.max(n, 2*p+1);
    }

    @Override
    public T root() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int numChildren(T p) {
        return 0;
    }

    @Override
    public T parent(T p) {
        return null;
    }

    @Override
    public T left(T p) {
        return null;
    }

    @Override
    public T right(T p) {
        return null;
    }

    @Override
    public T sibling(T p) {
        return null;
    }
}
