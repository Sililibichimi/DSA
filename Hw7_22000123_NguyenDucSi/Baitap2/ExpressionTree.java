package DSA.Hw7_22000123_NguyenDucSi.Baitap2;

import DSA.Hw7_22000123_NguyenDucSi.Baitap1.LinkedBinaryTree;

import java.util.Stack;

public class ExpressionTree<E>  extends LinkedBinaryTree {

    public ExpressionTree() {
        super();
    }

    public void preoderPrint(Node<E> p) {
        if (p == null) return;
        System.out.print(getElement(p) + " ");
        preoderPrint(getLeft(p));
        preoderPrint(getRight(p));
    }

    public void postorderPrint(Node<E> p) {
        if (p == null) return;
        postorderPrint(getLeft(p));
        postorderPrint(getRight(p));
        System.out.print(getElement(p) + " ");
    }

    public void inorderPrint(Node<E> p) {
        if (p == null) return;
        if (getLeft(p) != null) System.out.print("(");
        inorderPrint(getLeft(p));
        System.out.print(getElement(p));
        inorderPrint(getRight(p));
        if (getRight(p) != null) System.out.print(")");
    }

    public double evaluate(Node<E> p) {
        if (p == null) {
            return 0;
        }

        String element = (String) getElement(p);
        if (isOperator(element)) {
            double leftValue = evaluate(getLeft(p));
            double rightValue = evaluate(getRight(p));
            return applyOperator(element, leftValue, rightValue);
        } else {
            return Double.parseDouble(element);
        }
    }

    private boolean isOperator(String element) {
        return element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/");
    }

    private double applyOperator(String operator, double leftValue, double rightValue) {
        switch (operator) {
            case "+":
                return leftValue + rightValue;
            case "-":
                return leftValue - rightValue;
            case "*":
                return leftValue * rightValue;
            case "/":
                return leftValue / rightValue;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    public int level(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }

    public void buildExpressionTree(String[] tokens) {
        Stack<Node<E>> numbers = new Stack<>();
        Stack<String> operators = new Stack<>();

        for (String token : tokens) {
            if (token.equals("(")) {
                operators.push(token);
                continue;
            }

            if (token.equals(")") && !operators.isEmpty()) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    String operator = operators.pop();
                    Node<E> right = numbers.pop();
                    Node<E> left = numbers.pop();
                    Node<E> newNode = new Node<>((E) operator, null, left, right);
                    setParent(left, newNode);
                    setParent(right, newNode);
                    setLeft(newNode, left);
                    setRight(newNode, right);
                    numbers.push(newNode);

                }
                operators.pop();
            } else if (isOperator(token)) {
                while (!operators.isEmpty() && level(operators.peek()) >= level(token)) {
                    String operator = operators.pop();
                    Node<E> right = numbers.pop();
                    Node<E> left = numbers.pop();
                    Node<E> newNode = new Node<>((E) operator, null, left, right);
                    setParent(left, newNode);
                    setParent(right, newNode);
                    setLeft(newNode, left);
                    setRight(newNode, right);
                    numbers.push(newNode);

                }
                operators.push(token);
            } else {
                Node<E> newNode = new Node<>((E) token, null, null, null);

                numbers.push(newNode);
            }
        }

        while (!operators.isEmpty()) {
            String operator = operators.pop();
            Node<E> right = numbers.pop();
            Node<E> left = numbers.pop();
            Node<E> newNode = new Node<>((E) operator, null, left, right);
            setParent(left, newNode);
            setParent(right, newNode);
            setLeft(newNode, left);
            setRight(newNode, right);
            numbers.push(newNode);
        }

        this.addRoot(numbers.pop());
    }

}
