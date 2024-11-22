package DSA.Hw4_22000123_NguyenDucSi.luyentap2;

public class MyArrayStack {
    private int[] arr;
    private int top;

    public MyArrayStack() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        arr[++top] = x;
    }

    public int pop() {
        if(top == -1) return -1;
        return arr[top--];
    }
}
