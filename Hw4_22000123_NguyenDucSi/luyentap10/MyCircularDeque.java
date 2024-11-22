package DSA.Hw4_22000123_NguyenDucSi.luyentap10;

public class MyCircularDeque {

    int size;
    int[] queue;
    int front;
    int rear;
    int cnt;

    public MyCircularDeque(int k) {
        size = k;
        queue = new int[size];
        front = 0;
        rear = 0;
        cnt = 0;
    }

    public boolean insertFront(int value) {
        if(isFull()) {
            return false;
        }

        front = (front - 1 + size) % size;
        queue[front] = value;
        cnt++;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }

        queue[rear] = value;
        rear = (rear + 1) % size;
        cnt++;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }

        front = (front + 1) % size;
        cnt--;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }

        rear = (rear - 1 + size) % size;
        cnt--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return queue[front];
    }

    public int getRear() {
        if(isEmpty()) {
            return -1;
        }

        return queue[(rear - 1 + size) % size];
    }

    public boolean isEmpty() {
        return cnt == 0;
    }

    public boolean isFull() {
        return cnt == size;
    }
}
