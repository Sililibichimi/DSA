package DSA.Hw2_22000123_NguyenDucSi.ex2;

public class SelectionSort {

    public SelectionSort() {}

    public <T extends Comparable<T>> void sort(T[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < n; ++j) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                MySort.swap(arr, i, minIndex);
            }
        }
    }
}