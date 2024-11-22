package DSA.Hw2_22000123_NguyenDucSi.ex2;

public class QuickSort {

    public QuickSort() {}

    public <T extends Comparable<T>> void sort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private <T extends Comparable<T>> void quickSort(T[] arr, int l, int r) {
        if (l >= r) return;

        int pi = partition(arr, l, r);

        quickSort(arr, l, pi);
        quickSort(arr, pi + 1, r);
    }

    private <T extends Comparable<T>> int partition(T[] arr, int l, int r) {
        int i = l;
        int j = r;
        T pivot = arr[(i + j) / 2];

        while (true) {
            while (arr[i].compareTo(pivot) < 0) {
                ++i;
            }
            while (arr[j].compareTo(pivot) > 0) {
                --j;
            }
            if (i >= j) return j;

            MySort.swap(arr, i, j);
            ++i; --j;
        }
    }
}
