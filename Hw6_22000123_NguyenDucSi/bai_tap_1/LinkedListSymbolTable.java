package DSA.Hw6_22000123_NguyenDucSi.bai_tap_1;

public class LinkedListSymbolTable<Key extends Comparable<Key>, Value> extends AbstractSymbolTable<Key, Value>{

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node bottom;
    private int size;

    @Override
    public boolean contains(Key key) {
        Node cur = head;

        while(cur != null) {
            if(cur.key.equals(key)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void delete(Key key) {
        if(head == null) {
            return;
        }
        if(head.key.equals(key)) {
            head = head.next;
            --size;
            return;
        }
        Node cur = head;
        while(cur.next != null) {
            if(cur.next.key.equals(key)) {
                cur.next = cur.next.next;
                --size;
                return;
            }
            cur = cur.next;
        }
    }

    @Override
    public void put(Key key, Value value) {
        if(head == null) {
            head = new Node(key, value, null);
            bottom = head;
            ++size;
            return;
        }
        Node cur = head;
        while(cur != null) {
            if(cur.key.equals(key)) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }

        bottom.next = new Node(key, value, null);
        bottom = bottom.next;
        ++size;
    }

    @Override
    public Value get(Key key) {
        Node cur = head;
        while(cur != null) {
            if(cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        return new Iterable<Key>() {
            @Override
            public java.util.Iterator<Key> iterator() {
                return new java.util.Iterator<Key>() {
                    Node cur = head;

                    @Override
                    public boolean hasNext() {
                        return cur != null;
                    }

                    @Override
                    public Key next() {
                        Key key = cur.key;
                        cur = cur.next;
                        return key;
                    }
                };
            }
        };
    }

}
