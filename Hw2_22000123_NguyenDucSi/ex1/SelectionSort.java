package DSA.Hw2_22000123_NguyenDucSi.ex1;

import java.util.Arrays;

public class SelectionSort extends MySort {

    public SelectionSort() {
        isPrint = false;
        numberOfCompair = 0;
        numberOfSwap = 0;
        startTime = 0;
    }

    @Override
    public void sort(int[] arr) {
        startTime = System.nanoTime();
        int n = arr.length;

        for(int i = 0; i < n; ++i) {
            int minIdex = i;
            for(int j = i + 1; j < n; ++j) {
                ++numberOfCompair;
                if(arr[j] < arr[minIdex]) {
                    minIdex = j;
                }
            }
            if(minIdex != i) {
                MySort.swap(arr, i, minIdex);
                ++numberOfSwap;
            }
            if(isPrint) {
                System.out.println(Arrays.toString(arr));
            }
        }
        endTime = System.nanoTime();
    }

    @Override
    public String toString() {
        return "Selection Sort";
    }
}
