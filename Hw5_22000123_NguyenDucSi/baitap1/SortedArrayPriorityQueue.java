package DSA.Hw5_22000123_NguyenDucSi.baitap1;

public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E>{
    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry(K k, E e) {
            this.key = k;
            this.element = e;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public E getValue() {
            return this.element;

        }
    }

    ArrEntry<K, E>[] array;
    int n = 0;
    final int DEFAULT_SIZE = 1000;

    public SortedArrayPriorityQueue() {
        this.array = new ArrEntry[DEFAULT_SIZE];
    }

    public SortedArrayPriorityQueue(int size) {
        this.array = new ArrEntry[size];
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
    public void insert(Entry<K, E> entry) {
        if(n == array.length) {
            enlarge();
        }

        int idx = n;
        while(idx > 0 && entry.getKey().compareTo(array[idx-1].getKey()) > 0) {
            array[idx] = array[idx-1];
            --idx;
        }
        ++n;
        array[idx] = (ArrEntry<K, E>) entry;
    }

    @Override
    public void insert(K k, E e) {
        ArrEntry entry = new ArrEntry(k, e);
        insert(entry);
    }

    @Override
    public Entry<K, E> removeMin() {
        if(n == 0) return null;
        return array[--n];
    }

    @Override
    public Entry<K, E> min() {
        if(n == 0) return null;
        return array[n - 1];
    }

    public void enlarge() {
        ArrEntry<K, E>[] newArray = new ArrEntry[array.length * 2];
        for(int i = 0; i < n; ++i) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
