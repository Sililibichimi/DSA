package DSA.Hw2_22000123_NguyenDucSi.ex4;

import java.util.Scanner;

public class Ex3 {
    /*
    Cho dãy a gồm n số nguyên, và dãy b gồm m số nguyên, cả hai dãy đều được sắp xếp không giảm.
    Hãy gộp hai dãy thành một dãy c, sao cho dãy c cũng là dãy không giảm.
    In dãy c ra màn hình, sau mỗi phần tử có đúng một dấy cách.
     */

    static String concatArray(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        int i = 0;
        int j = 0;

        StringBuilder res = new StringBuilder();

        while(i < n && j < m) {
            if(a[i] <= b[j]) {
                res.append(a[i]).append(" ");
                ++i;
            } else {
                res.append(b[j]).append(" ");
                ++j;
            }
        }

        while(i < n) {
            res.append(a[i]).append(" ");
            ++i;
        }
        while (j < m) {
            res.append(b[j]).append(" ");
            ++j;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < m; ++i) {
            b[i] = sc.nextInt();
        }

        System.out.println(concatArray(a, b));
    }
}
