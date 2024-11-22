package DSA.Hw4_22000123_NguyenDucSi.baitap1;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        String hoten = "0123456789abc";
        for(int i = 0; i < hoten.length(); ++i) {
            if(i % 2 == 0) {
                s.push(hoten.charAt(i));
                System.out.println(i +": push " + hoten.charAt(i));
            }
            if(i % 3 == 0) {
                System.out.println(i + ": Pop " + s.pop());
            }
        }

        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }

        /*
        Đặt n = hoten.length(),
        Khi i = 0 thì cả 2 if đều được thực hiện => độ dài stack là 0
        Tiếp đó, ta có thể thấy được số lần push là n / 2, số lần pop là n / 3
        => độ dài của stack sau cùng sẽ là n / 6 + (((n % 3 != 0 && n % 2 == 0) || n % 6 == 4 || n % 6 == 5) ? 1 : 0)
        Và các phần tử còn lại trong stack là phần tử tại vị trí i mà i % 6 == 4;
         */
    }
}
