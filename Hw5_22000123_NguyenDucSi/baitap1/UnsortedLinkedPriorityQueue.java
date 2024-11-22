package DSA.Hw5_22000123_NguyenDucSi.baitap1;

public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K , E> {

    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;
        public NodeEntry(K k, E e) {
            this.key = k;
            this.element = e;
            this.next = null;
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

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    int n = 0;

    public UnsortedLinkedPriorityQueue() {
        this.head = null;
        this.tail = null;
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
        if (head == null) {
            head = (NodeEntry<K, E>) entry;
            tail = head;
        } else {
            tail.next = (NodeEntry<K, E>) entry;
            tail = tail.next;
        }
        ++n;
    }

    @Override
    public void insert(K k, E e) {
        NodeEntry<K, E> newEntry = new NodeEntry<>(k, e);
        insert(newEntry);
    }

    @Override
    public Entry<K, E> removeMin() {
        if(isEmpty()) {
            return null;
        }
        NodeEntry<K, E> min = head;
        NodeEntry<K, E> prev = null;
        NodeEntry<K, E> cur = head;

        while (cur != null) {
            if (cur.getKey().compareTo(min.getKey()) < 0) {
                min = cur;
                prev = cur;
            }
            cur = cur.next;
        }

        if(min == head) {
            head = head.next;
        } else {
            prev.next = min.next;
        }
        --n;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if(isEmpty()) {
            return null;
        }
        NodeEntry<K, E> min = head;
        NodeEntry<K, E> cur = head;

        while (cur != null) {
            if (cur.getKey().compareTo(min.getKey()) < 0) {
                min = cur;
            }
            cur = cur.next;
        }
        --n;
        return min;
    }
}
