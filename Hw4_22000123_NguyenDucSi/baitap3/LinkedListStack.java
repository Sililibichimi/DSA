package DSA.Hw4_22000123_NguyenDucSi.baitap3;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {

    class Node {
        E element;
        Node next;
        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

    private Node stack = null;

    @Override
    public void push(Object element) {
        Node newNode = new Node((E) element);
        newNode.next = stack;
        stack = newNode;
    }

    @Override
    public E pop() {
        if (stack == null) {
            return null;
        }
        E element = stack.element;
        stack = stack.next;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return stack == null;
    }

    @Override
    public E top() {
        if(stack != null) {
            return stack.element;
        }
        return null;
    }

    @Override
    public String print() {
        Node cur = stack;
        StringBuilder sb = new StringBuilder();
        while(cur != null) {
            sb.append(cur.element).append(" ");
            cur = cur.next;
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    class StackIterator implements Iterator<E> {
        Node current = stack;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E element = current.element;
            current = current.next;
            return element;
        }
    }
}
