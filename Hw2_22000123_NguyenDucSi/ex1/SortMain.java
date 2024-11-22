package DSA.Hw2_22000123_NguyenDucSi.ex1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortMain {

    public static void main(String[] args) {

        SortMaker sortMaker = new SortMaker();

        int[] arr1 = new int[10];
        int[] arr2;
        Sort[] sorts = new Sort[5];

        sorts[0] = new BubbleSort();
        sorts[1] = new InsertSort();
        sorts[2] = new SelectionSort();
        sorts[3] = new MergeSort();
        sorts[4] = new QuickSort();

        int n = 14;
        arr1 = createArrayWithN(n);
        sortMaker.setSort(sorts[4]);
        sortMaker.setArr(arr1);
        sortMaker.sorting();
        System.out.println(Arrays.toString(sortMaker.arr));
        System.out.println(Arrays.toString(sortMaker.sortedArr));
    }

    public static int[] createArrayWithN(int n) {
        int[] arr = new int[n];
        Random rd = new Random();
        arr = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = rd.nextInt(0, 100);
        }

        return arr;
    }

}

