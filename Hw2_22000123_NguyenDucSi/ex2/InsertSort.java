package DSA.Hw2_22000123_NguyenDucSi.ex2;

public class InsertSort {

    public InsertSort() {
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        int n = arr.length;
        for(int i = 1; i < n; ++i) {
            int j = i;
            T key = arr[j];
            while(j > 0 && (arr[j - 1].compareTo(key) > 0)) {
                arr[j] = arr[j - 1];
                --j;
            }

            arr[j] = key;

        }
    }


}
