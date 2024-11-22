package DSA.Hw4_22000123_NguyenDucSi.luyentap4;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); ++i) {
            Character c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                if(st.isEmpty()) return false;
                if(c == ')' && st.peek() != '(') return false;
                if(c == ']' && st.peek() != '[') return false;
                if(c == '}' && st.peek() != '{') return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
