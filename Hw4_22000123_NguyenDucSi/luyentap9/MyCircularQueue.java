package DSA.Hw4_22000123_NguyenDucSi.luyentap9;

public class MyCircularQueue {
    int size;
    int[] queue;
    int front;
    int rear;
    int cnt;

    public MyCircularQueue(int k) {
        size = k;
        queue = new int[size];
        front = -1;
        rear = -1;
        cnt = 0;
    }

    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        if(front == -1) {
            front = 0;
        }
        if(rear + 1 == size) {
            rear = -1;
        }
        queue[++rear] = value;
        ++cnt;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        if(front == size - 1) {
            front = -1;
        }
        --cnt;
        ++front;
        return true;
    }

    public int Front() {
        if(isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        return queue[rear];
    }

    public boolean isEmpty() {
        return cnt == 0;
    }

    public boolean isFull() {
        return cnt == size;
    }
}
