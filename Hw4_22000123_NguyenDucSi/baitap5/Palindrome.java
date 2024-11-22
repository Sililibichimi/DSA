package DSA.Hw4_22000123_NguyenDucSi.baitap5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {

    public boolean isPalindrome(String s) {
        Queue<Character> qe = new LinkedList<>();
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                qe.add(Character.toLowerCase(c));
                st.push(Character.toLowerCase(c));
            }
        }
        while (!qe.isEmpty()) {
            if (!qe.poll().equals(st.pop())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(p.isPalindrome(s));
    }
}
