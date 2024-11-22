package DSA.Hw2_22000123_NguyenDucSi.ex1;

import java.util.Arrays;

public class BubbleSort extends MySort {

    public BubbleSort() {
        isPrint = false;
        numberOfCompair = 0;
        numberOfSwap = 0;
        startTime = 0;
    }


    @Override
    public void sort(int[] arr) {
        startTime =  System.nanoTime();

        int n = arr.length;
        boolean flag;
        for(int i = 0; i < n - 1; ++i) {
            flag = false;
            for(int j = 0; j < n - 1 - i; ++j ) {
                ++numberOfCompair;
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    ++numberOfSwap;
                    flag = true;
                }
            }
            if(isPrint) {
                System.out.println(Arrays.toString(arr));
            }
            if(!flag) {
                break;
            }
        }
        endTime = System.nanoTime();
    }

    public long getDuration() {
        if(startTime != 0) {
            return endTime - startTime;
        }
        System.out.println("Hãy sắp xếp dãy trước!!!");
        return -1;
    }

    @Override
    public String toString() {
        return "Bubble Sort";
    }

}
