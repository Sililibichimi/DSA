package DSA.Hw5_22000123_NguyenDucSi.baitap1;

public class SortedLinkedPriorityQueue <K extends Comparable, E> implements PriorityQueueInterface<K, E> {

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

    public SortedLinkedPriorityQueue() {
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
        if(head == null) {
            head = (NodeEntry<K, E>) entry;
            tail = head;
        } else {
            NodeEntry<K, E> cur = head;
            NodeEntry<K, E> prev = null;

            while (cur != null && cur.getKey().compareTo(entry.getKey()) < 0) {
                prev = cur;
                cur = cur.next;
            }

            if(prev == null) {
                NodeEntry newNode = (NodeEntry<K, E>) entry;
                newNode.next = head;
                head = newNode;
            } else {
                prev.next = (NodeEntry<K, E>) entry;
                prev.next.next = cur;
            }
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
        head = head.next;
        if(head == null) {
            tail = null;
        }
        --n;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if(isEmpty()) {
            return null;
        }
        return head;
    }
}
