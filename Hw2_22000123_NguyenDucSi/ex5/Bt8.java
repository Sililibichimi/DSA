package DSA.Hw2_22000123_NguyenDucSi.ex5;

import java.util.Scanner;

public class Bt8 {

    public static String countingSort(String s) {
        int[] count = new int[10];

        for(int i = 0; i < s.length(); ++i) {
            ++count[s.charAt(i) - '0'];
        }
        StringBuilder res = new StringBuilder();

        for(int i = 9; i >= 0; --i) {
            if(count[i] > 0) {
                for(int j = 0; j < count[i]; ++j) {
                    res.append(i);
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(countingSort(s));
    }
}
