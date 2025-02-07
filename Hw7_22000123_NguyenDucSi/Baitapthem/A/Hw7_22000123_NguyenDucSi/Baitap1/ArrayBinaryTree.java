package DSA.Hw7_22000123_NguyenDucSi.Baitapthem.A.Hw7_22000123_NguyenDucSi.Baitap1;

import java.io.FileWriter;

public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<T> {
    private E[] array;
    private int n = 0;
    private int defaultSize = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultSize];
    }

    public void setRoot(E element) {
        array[1] = element;
        n = Math.max(n, 1);
    }

    public void setLeft(int p, E element) {
        if (2 * p < array.length) {
            array[2 * p] = element;
            n = Math.max(n, 2 * p);
        }
    }

    public void setRight(int p, E element) {
        if (2 * p + 1 < array.length) {
            array[2 * p + 1] = element;
            n = Math.max(n, 2 * p + 1);
        }
    }

    @Override
    public T root() {
        return (T) Integer.valueOf(1);
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int numChildren(T p) {
        int index = (int) p;
        int count = 0;
        if (2 * index <= n && array[2 * index] != null) count++;
        if (2 * index + 1 <= n && array[2 * index + 1] != null) count++;
        return count;
    }

    @Override
    public T parent(T p) {
        int index = (int) p;
        if (index > 1) {
            return (T) Integer.valueOf(index / 2);
        }
        return null;
    }

    @Override
    public T left(T p) {
        int index = (int) p;
        if (2 * index <= n && array[2 * index] != null) {
            return (T) Integer.valueOf(2 * index);
        }
        return null;
    }

    @Override
    public T right(T p) {
        int index = (int) p;
        if (2 * index + 1 <= n && array[2 * index + 1] != null) {
            return (T) Integer.valueOf(2 * index + 1);
        }
        return null;
    }

    @Override
    public T sibling(T p) {
        int index = (int) p;
        if (index % 2 == 0 && index + 1 <= n) {
            return (T) Integer.valueOf(index + 1);
        } else if (index % 2 == 1 && index - 1 > 0) {
            return (T) Integer.valueOf(index - 1);
        }
        return null;
    }

    public void printH(int index, int level, FileWriter writer) {
        try {
            if (index > n || array[index] == null) return;
            printH(2 * index + 1, level + 1, writer);
            for (int i = 0; i < level; i++) {
                System.out.print("     ");
                writer.write("     ");
            }
            writer.write(array[index] + "\n");
            printH(2 * index, level + 1, writer);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void print(FileWriter writer) {
        try {
            writer.write("Using ArrayBinaryTree\n");
            printH(1, 0, writer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
