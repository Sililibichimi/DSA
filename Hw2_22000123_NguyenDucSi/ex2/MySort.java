package DSA.Hw2_22000123_NguyenDucSi.ex2;

public abstract class MySort {

    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
    }
}
