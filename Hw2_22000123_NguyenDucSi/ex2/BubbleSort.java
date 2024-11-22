package DSA.Hw2_22000123_NguyenDucSi.ex2;

public class BubbleSort {

    public  BubbleSort() {}

    public static <T extends Comparable<T>> void sort(T[] arr) {
        int n = arr.length;
        boolean flag;
        for(int i = 0; i < n - 1; ++i) {
            flag = false;
            for(int j = 0; j < n - 1 - i; ++j ) {
                if(arr[j].compareTo(arr[j + 1]) > 0) {
                    MySort.swap(arr, j, j + 1);
                    flag = true;
                }
            }

            if(!flag) {
                break;
            }
        }
    }


    @Override
    public String toString() {
        return "Bubble Sort";
    }

}
