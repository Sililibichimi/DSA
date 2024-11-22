package DSA.Hw2_22000123_NguyenDucSi.ex5;

import java.util.Scanner;

public class Bt9 {

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void quickSort(Pair[] arr, int l, int r) {
        if (l >= r) return;

        int pi = partition(arr, l, r);

        quickSort(arr, l, pi);
        quickSort(arr, pi + 1, r);
    }

    public static int partition(Pair[] arr, int l, int r) {
        int i = l;
        int j = r;
        int pivot = arr[(i + j) / 2].first;

        while (true) {
            while (arr[i].first < pivot) {
                ++i;
            }
            while (arr[j].first > pivot) {
                --j;
            }
            if (i >= j) return j;

            Pair temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            ++i; --j;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Pair[] a = new Pair[n];

        for(int i = 0; i < n; ++i) {
            a[i] = new Pair(sc.nextInt(), i);
        }

        quickSort(a, 0, a.length - 1);
        for(int i = 0; i < n; ++i) {
            if(a[i].second == k - 1) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
