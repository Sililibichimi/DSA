package DSA.Hw2_22000123_NguyenDucSi.ex4;

import java.util.Scanner;

public class Ex2 {

    /*
    Nhập và một số nguyên dương n,
    tiếp theo là n số nguyên lần lượt là các phần tử của một dãy số,
    hãy đếm tần số (số lần xuất hiện) của các số trong dãy và
    in nó ra màn hình dưới dạng sau: "a1 t1; a2 t2; ... an tn; ",
    trong đó t1 là số lần xuất hiện của số a1, t2
    là số lần xuất hiện của a2, ... a1, a2, .. an
    không trùng nhau và được sắp xếp tăng dần (xem ví dụ để rõ hơn).
     */

    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int pi = partition(arr, l, r);

        quickSort(arr, l, pi);
        quickSort(arr, pi + 1, r);
    }

    public static int partition(int[] arr, int l, int r) {
        int i = l;
        int j = r;
        int pivot = arr[(i + j) / 2];

        while (true) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i >= j) return j;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            ++i; --j;
        }
    }

    public static String frequency(int[] a) {
        quickSort(a, 0, a.length - 1);
        int n = a.length;
        int i = 0;
        StringBuilder res = new StringBuilder();
        while(i < n) {
            int count = 1;
            while(i < n - 1 && a[i] == a[i + 1]) {
                ++count;
                ++i;
            }
            res.append(a[i]).append(" ").append(count).append("; ");
            ++i;
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

        System.out.println(frequency(a));
    }
}
