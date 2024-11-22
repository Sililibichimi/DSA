package DSA.Hw4_22000123_NguyenDucSi.baitap4;

import java.util.Iterator;
import java.util.Queue;

public class LinkedListQueue<E> implements QueueInterface {

    class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> front;
    private Node<E> rear;

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
    }

    @Override
    public void enqueue(Object element) {
        Node<E> newNode = new Node<>((E) element);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public Iterator iterator() {
        return new QueueIterator();
    }

    public class QueueIterator implements Iterator<E> {
        private Node<E> current = front;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E data = current.data;
            current = current.next;
            return data;
        }
    }

}
