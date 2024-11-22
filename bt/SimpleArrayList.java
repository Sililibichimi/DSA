package DSA.bt;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayList <T> implements ListInterface <T > {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    private void resizeArray() {
        int newSize = array.length * 2;
        T[] newArray = (T[]) new Object[newSize];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public void add(T data) {
        if (n == array.length) {
            resizeArray();
        }
        array[n] = data;
        n++;
    }

    public T get(int i) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException(" i khong thoa man");
        }
        return array[i];
    }

    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException(" i khong thoa man");
        }
        array[i] = data;
    }

    public void remove(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                for (int j = i; j < n - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[--n] = null;
                return;
            }
        }
    }

    public boolean isContain(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < n;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Khong con phan tu nao");
                }
                return array[current++];
            }
        };
    }
}