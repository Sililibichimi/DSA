package DSA.Hw2_22000123_NguyenDucSi.ex4;

import java.util.Scanner;

public class Ex4 {
    /*
    Trong diễn biến dịch Covid-19 đang diễn ra khá phức tạp,
    việc tuyền truyền cách phòng tránh dịch là rất quan trong,
    gọi a[i] là tọa độ của người thứ i, khoảng cách giữa hai người i và j là |a[i]-a[j]|.
    Một người có thể truyền được thông tin đến người khác nếu khoảng cách giữa họ không vượt quá k.

    Để tuyền truyền thông tin nhanh chóng thì người ta sẽ chỉ truyền thông tin cho 1 số người ban đầu,
    sau đó họ sẽ truyền thông tin cho người khác,
    Hãy đưa ra số lượng ít nhất là số người ban đầu cần truyền thông tin,
    để sao cho tất cả mọi người đều tiếp cận được thông tin
     */
    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int pi = partition(arr, l, r);

        quickSort(arr, l, pi);
        quickSort(arr, pi + 1, r);
    }

    public static int partition(int[] arr, int l, int r) {
        int i = l;
        int j = r;
        int pivot = arr[(i + j) / 2];

        while (true) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i >= j) return j;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            ++i; --j;
        }
    }

    public static int minPeople(int[] a, int k) {
        quickSort(a, 0, a.length - 1);
        int n = a.length;
        int res = 1;
        for(int i = 1; i < n; ++i) {
            if(a[i] - a[i - 1] > k) {
                ++res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(minPeople(a, k));
    }
}
