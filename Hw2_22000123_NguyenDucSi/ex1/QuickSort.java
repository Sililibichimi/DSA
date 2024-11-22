package DSA.Hw2_22000123_NguyenDucSi.ex1;

import java.util.Arrays;

public class QuickSort extends MySort {

    public QuickSort() {
        isPrint = false;
        numberOfCompair = 0;
        numberOfSwap = 0;
        startTime = 0;
    }
    @Override
    public void sort(int[] arr) {
        startTime = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        endTime = System.nanoTime();
    }

    public void  quickSort(int[] arr, int l, int r) {
        if(l >= r) return;

        int pi = partition(arr, l, r);

        quickSort(arr, l, pi);
        if(isPrint) {
            System.out.println(Arrays.toString(arr));
        }
        quickSort(arr, pi + 1, r);
        if(isPrint) {
            System.out.println(Arrays.toString(arr));
        }

    }

    public int partition(int[] arr, int l, int r) {
        int i = l;
        int j = r;
        int privot = arr[(i + j) / 2];

        while(true) {

            while(arr[i] < privot) {
                ++numberOfCompair;
                ++i;
            }
            while (arr[j] > privot) {
                ++numberOfCompair;
                --j;
            }
            if(i >= j) return j;

            ++numberOfSwap;
            swap(arr, i , j);
            ++i; --j;
        }
    }
    @Override
    public String toString() {

        return "Quick Sort";
    }
}
