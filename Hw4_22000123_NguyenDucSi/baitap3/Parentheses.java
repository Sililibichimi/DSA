package DSA.Hw4_22000123_NguyenDucSi.baitap3;

import java.io.BufferedReader;
import java.io.FileReader;

public class Parentheses {
    public boolean checkParentheses(String s) {
        LinkedListStack<Character> st = new LinkedListStack<>();

        for(int i = 0; i < s.length(); ++i) {
            if(isBracket(s.charAt(i))) {
                if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                    st.push(s.charAt(i));
                } else {
                    if(st.isEmpty()) {
                        return false;
                    }
                    char c = st.pop();
                    if(s.charAt(i) == ')' && c != '(') {
                        return false;
                    }
                    if(s.charAt(i) == ']' && c != '[') {
                        return false;
                    }
                    if(s.charAt(i) == '}' && c != '{') {
                        return false;
                    }
                }
            }
        }
        return st.isEmpty();
    }

    public boolean isBracket(char c) {
        return c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}';
    }

    public float calculate(String s) {
        LinkedListStack<Float> number = new LinkedListStack<>();
        LinkedListStack<Character> operator = new LinkedListStack<>();

        int num = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == ' ') {
                continue;
            }

            if(isNumber(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
                continue;
            }
            if(num != 0) {
                number.push((float) num);
            }
            num = 0;

            if(s.charAt(i) == '(') {
                operator.push('(');
            } else if (s.charAt(i) == ')') {
                while(operator.top() != '(') {
                    float b = number.pop();
                    float a = number.pop();
                    number.push(evaluate(a, b, operator.pop()));
                }
                operator.pop();
            } else if(isOperator(s.charAt(i))) {
                while(!operator.isEmpty() && level(operator.top()) >= level(s.charAt(i))) {
                    float b = number.pop();
                    float a = number.pop();
                    number.push(evaluate(a, b, operator.pop()));
                }
                operator.push(s.charAt(i));
            }
        }

        if(num != 0) {
            number.push((float) num);
        }

        while (!operator.isEmpty()) {
            float b = number.pop();
            float a = number.pop();
            number.push(evaluate(a, b, operator.pop()));
        }

        return number.pop();
    }

    public float evaluate(float a, float b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }

    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public int level(char op) {
        if(op == '+' || op == '-') {
            return 1;
        }
        if(op == '*' || op == '/') {
            return 2;
        }
        return -1;
    }

    public void check(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Input: " + line);
                if(checkParentheses(line)) {
                    System.out.println("True");
                    System.out.println("Result: " + calculate(line));
                } else {
                    System.out.println("False");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        Parentheses p = new Parentheses();
        p.check("DSA/Hw4_22000123_NguyenDucSi/baitap3/TestCase");

    }
}
