package DSA.Hw3_22000123_NguyenDucSi.bai2;

import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {

    private T [] array ;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public void add(T add) {
        if(n + 1 == array.length) {
            extendSize();
        }
        array[n] = add;
        ++n;
    }
    public T get(int i) {
        if(checkBoundaries(i)) {
            return array[i];
        }
        System.out.println("Invalid parameter");
        return null;
    }
    public void set (int i , T data ) {
        if(checkBoundaries(i)) {
            array[i].equals(data);
            return;
        }
        System.out.println("Invalid index");
    }

    public void remove ( T data ) {
        int i = 0;
        while (i < n && !array[i].equals(data)) {
            ++i;
        }
        for(int j = i; j < n - 1; ++j) {
            array[j] = array[j + 1];
        }
    }

    public int indexOf(T data) {
        int i = 0;
        while (i < n && !array[i].equals(data)) {
            ++i;
        }
        return i;
    }

    public boolean isContain ( T data ) {
        int i = 0;
        while (i < n && !array[i].equals(data)) {
            ++i;
        }
        return i < n;
    }
    public int size () {
        return n;
    }
    public boolean isEmpty () {
        return n == 0;
    }

    public void extendSize() {
        T[] newArr = (T[]) new Object[n * 2];
        if (n >= 0) System.arraycopy(array, 0, newArr, 0, n);

        array = newArr;
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < n;
            }

            @Override
            public T next() {
                return array[currentIndex++];
            }
        };
    }

    public boolean checkBoundaries(int k) {
        return k <= n;
    }
}
