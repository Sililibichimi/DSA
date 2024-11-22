package DSA.Hw2_22000123_NguyenDucSi.ex4;

import java.util.Scanner;

public class Ex1 {
    // Cho một dãy a gồm n số tự nhiên. Hãy đưa ra số tự nhiên nhỏ nhất chưa xuất hiện trong dãy.

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

    public static int search(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        int n = arr.length;
        int i = 1;
        if(arr[0] != 0) return 0;
        while(i < n && arr[i] == arr[i - 1] + 1 || arr[i] == arr[i - 1]) {
            ++i;
            if(i == n) return arr[n - 1] + 1;
        }
        return arr[i - 1] + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }

        System.out.println(search(arr));
    }
}
