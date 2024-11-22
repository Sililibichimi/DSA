package DSA.Hw4_22000123_NguyenDucSi.luyentap6;

public class ListNodeQueue {

    class QueueNode
    {
        int data;
        QueueNode next;
        QueueNode(int a)
        {
            data = a;
            next = null;
        }
    }

    QueueNode front, rear;

    void push(int a)
    {
        QueueNode temp = new QueueNode(a);
        if(rear == null)
        {
            front = rear = temp;
            return;
        }
        rear.next = temp;
        rear = temp;
    }

    int pop()
    {
        if(front == null)
            return -1;
        int a = front.data;
        front = front.next;
        if(front == null)
            rear = null;
        return a;
    }

}
