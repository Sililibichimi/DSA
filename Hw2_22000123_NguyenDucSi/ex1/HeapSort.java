package DSA.Hw2_22000123_NguyenDucSi.ex1;

public class HeapSort implements Sort {
    private boolean isPrint;
    private int numberOfCompair;
    private int numberOfSwap;
    private long startTime;
    private long endTime;

    public HeapSort() {
        isPrint = false;
        numberOfCompair = 0;
        numberOfSwap = 0;
        startTime = 0;
    }

    @Override
    public void sort(int[] arr) {
        startTime = System.nanoTime();
        int n = arr.length;
        for(int i = n / 2 - 1; i >= 0; --i) {
            heapify(arr, n, i);
        }

        for(int i = n - 1; i > 0; --i) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
        endTime = System.nanoTime();
    }

    public void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if(l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if(r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if(largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    void swap(int[] arr, int i, int j) {
        MySort.swap(arr, j, i);
    }

    @Override
    public void setPrint(boolean b) {
        isPrint = b;
    }

    @Override
    public long getDuration() {
        return endTime - startTime;
    }

    @Override
    public int getNumberOfCompair() {
        return numberOfCompair;
    }

    @Override
    public int getNumberOfSwap() {
        return numberOfSwap;
    }

    @Override
    public String toString() {
        return "HeapSort";
    }
}
