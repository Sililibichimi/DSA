package DSA.Hw2_22000123_NguyenDucSi.ex5;

import java.util.Arrays;
import java.util.Scanner;

public class Bt7 {
    /*
    Bài toán yêu cầu đếm số cặp i < j mà ai + aj = x.
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

    public static int countPairs(int[] a, int x) {
        quickSort(a, 0, a.length - 1);
        int n = a.length;
        int res = 0;
        System.out.println(Arrays.toString(a));
        for(int i = 0; i < n - 1; ++i) {
            int l = i + 1;
            int r = n - 1;
            // find lowerbound
            while(l < r) {
                int mid = l + (r - l) / 2;
                if(a[mid] + a[i] < x) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if(a[l] + a[i] != x) continue;
            int lowerbound = l;
            // find upperbound
            l = i + 1;
            r = n - 1;
            while(l < r) {
                int mid = l + (r - l) / 2;
                if(a[mid] + a[i] <= x) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if(a[l] + a[i] != x) --l;
            res += l - lowerbound + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
        }

        System.out.println(countPairs(a, x));
    }
}
