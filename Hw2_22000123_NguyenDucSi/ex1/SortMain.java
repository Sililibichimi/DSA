package DSA.Hw2_22000123_NguyenDucSi.ex1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortMain {

    public static void main(String[] args) {

        SortMaker sortMaker = new SortMaker();

        int[] arr1 = new int[10];
        int[] arr2;
        Sort[] sorts = new Sort[6];

        sorts[0] = new BubbleSort();
        sorts[1] = new InsertSort();
        sorts[2] = new SelectionSort();
        sorts[3] = new MergeSort();
        sorts[4] = new QuickSort();
        sorts[5] = new HeapSort();

        int[] ns = {10, 100, 1000, 10000, 100000};
        for(int n : ns ) {
            arr2 = createArrayWithN(n);
            System.out.println("N = " + n);
            System.out.println("Array : " + Arrays.toString(arr2));
            for(Sort sort : sorts) {
                sort.setPrint(false);
                arr1 = Arrays.copyOf(arr2, arr2.length);
                sort.sort(arr1);
                System.out.println(sort.toString() +": " + sort.getDuration());
            }
        }

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

