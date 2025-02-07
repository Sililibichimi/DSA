package DSA.Hw7_22000123_NguyenDucSi.Baitap3;

import DSA.Hw7_22000123_NguyenDucSi.Baitap2.ExpressionTree;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public static String[] expressionToArray(String expression) {
        List<String> list = new ArrayList<>();
        int index = 0;
        int number = 0;

        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (isNumber(c)) {
                number = number * 10 + (c - '0');
            } else {
                if (number != 0) {
                    list.add(String.valueOf(number));
                    number = 0;
                }
                list.add(String.valueOf(c));
            }
        }

        if (number != 0) {
            list.add(String.valueOf(number));
        }

        return list.toArray(new String[0]);
    }
    public static void main(String[] args) {
        ExpressionTree<String> tree = new ExpressionTree<>();

        String expression = "(( 3+ 4 ) * 5)";
        String[] arr = expressionToArray(expression);

        tree.buildExpressionTree(arr);

        System.out.print("Expession: ");
        tree.postorderPrint(tree.getRoot());
        System.out.println();

        System.out.println(tree.evaluate(tree.getRoot()));

    }
}
