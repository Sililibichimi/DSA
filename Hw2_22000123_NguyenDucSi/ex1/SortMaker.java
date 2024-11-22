package DSA.Hw2_22000123_NguyenDucSi.ex1;

import java.util.Arrays;

public class SortMaker {
    int[] arr;
    int[] sortedArr;
    int size;

    Sort sort;

    public SortMaker(){}

    public SortMaker(int size) {
        this.size = size;
        arr = new int[size];
    }
    public SortMaker(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
    }
    public SortMaker(int[] arr, Sort sort) {
        this.arr= arr;
        this.sort = sort;
        this.size = arr.length;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
        size = arr.length;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public int[] getArr() {
        return arr;
    }

    public void sorting() {
        sortedArr = Arrays.copyOf(this.arr, size);
        sort.sort(sortedArr);
    }




}
