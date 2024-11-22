package DSA.Hw4_22000123_NguyenDucSi.baitap2;

import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E> {
    private E[] stack;
    private int top;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;

    public ArrayStack() {
        this.capacity = DEFAULT_CAPACITY;
        stack = (E[]) new Object[capacity];
        top = -1;
    }

    @Override
    public void push(E element) {
        if (top == capacity - 1) {
            enlarge();
        }
        stack[++top] = element;
    }

    @Override
    public E pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        }
        return stack[top--];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public E top() {
        if (top == -1) {
            return null;
        }
        return stack[top];
    }

    private void enlarge() {
        E[] newStack = (E[]) new Object[capacity * 2];
        if (capacity >= 0) System.arraycopy(stack, 0, newStack, 0, capacity);
        stack = newStack;
        capacity *= 2;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    class StackIterator implements Iterator<E> {
        int current = top;
        @Override
        public boolean hasNext() {
            return current != -1;
        }

        @Override
        public E next() {
            return stack[current--];
        }
    }

}
