package DSA.Hw4_22000123_NguyenDucSi.luyentap1;

/*
Cho một sâu s chỉ gồm các ký tự viết thường,
hãy viết hàm trả về chuỗi mã hóa của sâu này.
 */

import java.util.Scanner;
import java.util.Stack;

public class BaiTap1 {
    public static String encodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int cnt = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(st.isEmpty() || st.peek() == s.charAt(i)) {
                st.push(s.charAt(i));
                cnt++;
            } else {
                res.append(st.peek());
                res.append(cnt);
                cnt = 1;
                st.clear();
                st.push(s.charAt(i));
            }
        }
        if(!st.isEmpty()) {
            res.append(st.peek());
            res.append(cnt);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(encodeString(s));
    }
}
