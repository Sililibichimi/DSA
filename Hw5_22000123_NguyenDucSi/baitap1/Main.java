package DSA.Hw5_22000123_NguyenDucSi.baitap1;

public class Main {
    public static void main(String[] args) {

        PriorityQueueInterface<Integer, String> pq = new UnsortedArrayPriorityQueue<>();
        pq.insert(1, "A");
        pq.insert(42, "B");
        pq.insert(32, "C");
        pq.insert(4, "D");
        pq.insert(5, "E");
        pq.insert(26, "F");
        pq.insert(17, "G");

        System.out.println("Size: " + pq.size());

        if(pq.min() != null) {
            System.out.println("Min: " + pq.min().getValue());
        }

        if(pq.min() != null) {
            System.out.println("Remove min: " + pq.removeMin().getValue());
        }
        System.out.println("Size: " + pq.size());
        if(pq.min() != null) {
            System.out.println("Min: " + pq.min().getValue());
        }

        pq.insert(13, "H");
        System.out.println("Size: " + pq.size());
        if(pq.min() != null) {
            System.out.println("Min: " + pq.min().getValue());
        }
    }
}
