package DSA.Hw4_22000123_NguyenDucSi.luyentap3;
import java.util.Stack;
public class DeleteMiddleStack {
    public void deleteMid(Stack<Integer> s, int sizeOfStack) {
        Stack<Integer> temp = new Stack<>();
        int mid = (sizeOfStack) / 2;

        while(mid-- > 0) {
            temp.push(s.pop());
        }
        s.pop();
        while(!temp.isEmpty()) {
            s.push(temp.pop());
        }
    }
}
