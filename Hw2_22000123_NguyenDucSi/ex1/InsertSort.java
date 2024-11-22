package DSA.Hw2_22000123_NguyenDucSi.ex1;

import java.util.Arrays;

public class InsertSort extends MySort {

    public InsertSort() {
        isPrint = false;
        numberOfCompair = 0;
        numberOfSwap = 0;
        startTime = 0;
    }

    @Override
    public void sort(int[] arr) {
              startTime = System.nanoTime();
        int n = arr.length;

        for(int i = 1; i < n; ++i) {
            int j = i;
            int key = arr[j];
            while(j > 0 && key < arr[j - 1]) {
                ++numberOfCompair;
                ++numberOfSwap;
                arr[j] = arr[j - 1];
                --j;
            }
            if(isPrint) {
                System.out.println(Arrays.toString(arr));
            }
            arr[j] = key;
            ++numberOfSwap;
        }
        endTime = System.nanoTime();
    }

    @Override
    public String toString() {
        return "Insert Sort";
    }


}
