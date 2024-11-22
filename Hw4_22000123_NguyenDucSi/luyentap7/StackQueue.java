package DSA.Hw4_22000123_NguyenDucSi.luyentap7;
import java.util.Stack;
public class StackQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    void Push(int x)
    {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    int Pop()
    {
        if (s1.isEmpty()) {
            return -1;
        }
        int x = s1.peek();
        s1.pop();
        return x;
    }
}
