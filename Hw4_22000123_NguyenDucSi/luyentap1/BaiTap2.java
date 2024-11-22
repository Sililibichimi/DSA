package DSA.Hw4_22000123_NguyenDucSi.luyentap1;

import java.util.Scanner;
import java.util.Stack;

/*
Hãy chuyển n thành mã nhị phân và in chuỗi đó ra màn hình.
 */
public class BaiTap2 {

    public static void binary(int n) {
        Stack<Boolean> st = new Stack<>();
        while(n > 0) {
            st.push(n % 2 == 1);
            n /= 2;
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop() ? 1 : 0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        binary(n);
    }

}
