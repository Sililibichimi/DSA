package DSA.Hw2_22000123_NguyenDucSi.ex1;

public abstract class MySort implements Sort {

    int numberOfCompair;
    int numberOfSwap;

    long startTime;
    long endTime;
    long duration;

    boolean isPrint;

    public void setPrint(boolean print) {
        isPrint = print;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public long getDuration() {
        if(startTime != 0) {
            return endTime - startTime;
        }
        System.out.println("Hãy sắp xếp dãy trước!!!");
        return -1;
    }

    public int getNumberOfCompair() {
        return numberOfCompair;
    }

    public int getNumberOfSwap() {
        return numberOfSwap;
    }

    @Override
    public String toString(){
        return "";
    }
}
