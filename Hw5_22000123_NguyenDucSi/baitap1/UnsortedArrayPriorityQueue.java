package DSA.Hw5_22000123_NguyenDucSi.baitap1;

public class UnsortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry (K k, E e) {
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

    ArrEntry<K, E> [] array;
    int n = 0;
    final int DEFAULT_SIZE = 1000;

    public UnsortedArrayPriorityQueue () {
        this.array = new ArrEntry[DEFAULT_SIZE];
    }

    public UnsortedArrayPriorityQueue (int size) {
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
    public void insert(Entry entry) {
        if(n == array.length) {
            enlargeArray();
        }
        array[n] = (ArrEntry<K, E>) entry;
        ++n;
    }

    @Override
    public void insert(K k, E e) {
        if(n == array.length) {
            enlargeArray();
        }
        ArrEntry entry = new ArrEntry(k, e);
        array[n] = entry;
        ++n;
    }

    @Override
    public Entry removeMin() {
        if(n == 0) return null;
        int minIndex = 0;
        for(int i = 1; i < n; ++i) {
            if(array[i].getKey().compareTo(array[minIndex].getKey()) < 0) {
                minIndex = i;
            }
        }

        ArrEntry<K, E> minEntry = array[minIndex];
        for (int i = minIndex; i < n - 1; ++i) {
            array[i] = array[i + 1];
        }
        --n;
        return minEntry;
    }

    @Override
    public Entry min() {
        if(n == 0) return null;
        int minIndex = 0;
        for(int i = 1; i < n; ++i) {
            if(array[i].getKey().compareTo(array[minIndex].getKey()) < 0) {
                minIndex = i;
            }
        }
        return array[minIndex];
    }

    void enlargeArray() {
        ArrEntry<K, E> [] newArray = new ArrEntry[array.length * 2];
        for(int i = 0; i < n; ++i) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
