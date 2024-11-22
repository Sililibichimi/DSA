package DSA.Hw3_22000123_NguyenDucSi.bai2;

import java.util.Iterator;

public class SimpleLinkedList<T> implements ListInterface<T> {

    class Node{
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node top;
    private Node bot;
    private int n = 0;

    @Override
    public void add(T add) {
        Node newNode = new Node(add);
        if(top == null) {
            top = newNode;
            bot = newNode;
        } else {
            bot.next = newNode;
            bot = newNode;
        }
        ++n;
    }

    public Node getNode(int i) {
        if(i < 0 || i >= n) {
            return null;
        }
        Node cur = top;
        for(int j = 0; j < i; ++j) {
            cur = cur.next;
        }
        return cur;
    }

    @Override
    public T get(int i) {
        return this.getNode(i).data;
    }


    @Override
    public void set(int i, T data) {
        Node cur = this.getNode(i);
        if(cur != null) {
            cur.data = data;
        }
    }

    @Override
    public void remove(T data) {
        Node cur = top;
        Node prev = null;
        while(cur != null && !cur.data.equals(data)) {
            prev = cur;
            cur = cur.next;
        }
        if(cur == null) {
            return;
        }
        if(prev == null) {
            top = top.next;
        } else {
            prev.next = cur.next;
        }
        --n;
    }

    public int indexOf(T data) {
        Node cur = top;
        int i = 0;
        while(cur != null && !cur.data.equals(data)) {
            cur = cur.next;
            ++i;
        }
        return i;
    }

    @Override
    public boolean isContain(T data) {
        Node cur = top;
        while(cur != null && !cur.data.equals(data)) {
            cur = cur.next;
        }
        return cur != null;
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
    public boolean checkBoundaries(int k) {
        return k >= 0 && k < n;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleLinkedListIterator(top);
    }

    class SimpleLinkedListIterator implements Iterator<T> {
        private Node cur;

        SimpleLinkedListIterator(Node top) {
            cur = top;
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public T next() {
            T data = cur.data;
            cur = cur.next;
            return data;
        }
    }

}
