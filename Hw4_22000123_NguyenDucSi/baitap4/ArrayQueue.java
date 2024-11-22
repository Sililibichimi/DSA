package DSA.Hw4_22000123_NguyenDucSi.baitap4;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {

    private E[] queue;
    private int n;
    private int top = 0;
    private int count = 0;
    private final int default_size = 100;
    public ArrayQueue() {
        queue = (E[]) new Object[default_size];
        n = default_size;
    }
    public ArrayQueue(int capacity) {
        queue = (E[]) new Object[capacity];
        n = capacity;
    }
    public void enlarge() {
        E[] newQueue = (E[]) new Object[queue.length * 2];
        System.arraycopy(queue, 0, newQueue, 0, queue.length);
        n = n * 2;
        queue = newQueue;
    }

    @Override
    public void enqueue(E element) {
        if(count == n) {
            enlarge();
        }
        queue[count] = element;
        count++;
    }

    @Override
    public E dequeue() {
        if(top == count) {
            return null;
        }
        E element = queue[top];
        top++;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return top == count;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    class ArrayQueueIterator implements Iterator<E> {
        private int i = top;
        @Override
        public boolean hasNext() {
            return i < count;
        }

        @Override
        public E next() {
            return queue[i++];
        }
    }
}
