package DSA.Hw2_22000123_NguyenDucSi.ex1;

import java.util.Arrays;

public class MergeSort extends MySort {

    public MergeSort() {
        isPrint = false;
        numberOfCompair = 0;
        numberOfSwap = 0;
        startTime = 0;
    }
    @Override
    public void sort(int[] arr) {
        startTime = System.nanoTime();
        mergeSort(arr, 0 , arr.length - 1);
        endTime = System.nanoTime();
    }

    private void mergeSort(int[] arr, int l, int r) {
        if(l >= r) return;

        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);

        merge(arr, l, m, r);
        if(isPrint) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            ++numberOfCompair;
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                ++numberOfSwap;
                i++;
            }
            else {
                arr[k] = R[j];
                ++numberOfSwap;
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            ++numberOfSwap;
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            ++numberOfSwap;
            j++;
            k++;
        }
    }

    @Override
    public String toString() {
        return "Merge Sort";
    }
}
