package DSA.Hw2_22000123_NguyenDucSi.ex2;

import java.util.Arrays;

public class MergeSort{

    public MergeSort() {
    }

    public <T extends Comparable<T>> void sort(T[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private <T extends Comparable<T>> void mergeSort(T[] arr, int l, int r) {
        if (l >= r) return;

        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);

        merge(arr, l, m, r);
    }

    private <T extends Comparable<T>> void merge(T[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        T[] L = Arrays.copyOfRange(arr, l, m + 1);
        T[] R = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}