
package DSA.Hw5_22000123_NguyenDucSi.baitap2;

import DSA.Hw5_22000123_NguyenDucSi.baitap1.PriorityQueueInterface;
import DSA.Hw5_22000123_NguyenDucSi.baitap1.UnsortedArrayPriorityQueue;
import DSA.Hw5_22000123_NguyenDucSi.baitap1.UnsortedLinkedPriorityQueue;

import java.util.Random;

public class Test {

    public static void main(String[] args) {

        long time;
        long startTime;
        long endTime;

        int[] n = {1000, 10000, 100000, 1000000, 10000000, 100000000};

        // PriorityQueue
        PriorityQueueInterface<Integer, String> unsortedArrayPriorityQueue = new UnsortedArrayPriorityQueue<>();
        PriorityQueueInterface<Integer, String> unsortedLinkedPriorityQueue = new UnsortedLinkedPriorityQueue<>();
        PriorityQueueInterface<Integer, String> sortedArrayPriorityQueue = new UnsortedArrayPriorityQueue<>();
        PriorityQueueInterface<Integer, String> sortedLinkedPriorityQueue = new UnsortedLinkedPriorityQueue<>();

        //Entry

        Integer[] keys;
        String[] values;
        for(int k = 0; k < 6; ++k) {

            keys = new Integer[n[k]];
            values = new String[n[k]];

            for(int i = 0; i < n[k]; ++i) {
                keys[i] = n[k] - i;
                values[i] = "Value";
            }
            System.out.println("______________________________________________________________________________________________");
            System.out.println("INSERTING " + n[k] + " ELEMENTS");
            System.out.println();

            // UnsortedArrayPriorityQueue
            System.out.println("UnsortedArrayPriorityQueue");
            startTime = System.currentTimeMillis();
            for(int i = 0; i < n[k]; ++i) {
                unsortedArrayPriorityQueue.insert(keys[i], values[i]);
            }
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println("Time: " + time + "ms");
            System.out.println();

            // UnsortedLinkedPriorityQueue
            System.out.println("UnsortedLinkedPriorityQueue");
            startTime = System.currentTimeMillis();
            for(int i = 0; i < n[k]; ++i) {
                unsortedLinkedPriorityQueue.insert(keys[i], values[i]);
            }
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println("Time: " + time + "ms");
            System.out.println();

            // SortedArrayPriorityQueue
            System.out.println("SortedArrayPriorityQueue");
            startTime = System.currentTimeMillis();
            for(int i = 0; i < n[k]; ++i) {
                sortedArrayPriorityQueue.insert(keys[i], values[i]);
            }
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println("Time: " + time + "ms");
            System.out.println();

            // SortedLinkedPriorityQueue
            System.out.println("SortedLinkedPriorityQueue");
            startTime = System.currentTimeMillis();
            for(int i = 0; i < n[k]; ++i) {
                sortedLinkedPriorityQueue.insert(keys[i], values[i]);
            }
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println("Time: " + time + "ms");
            System.out.println();

            System.out.println("REMOVE " + n[k] + " ELEMENTS");
            System.out.println();

            // UnsortedArrayPriorityQueue
            System.out.println("UnsortedArrayPriorityQueue");
            startTime = System.currentTimeMillis();
            unsortedArrayPriorityQueue.removeMin();
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println("Time: " + time + "ms");
            System.out.println();

            // UnsortedLinkedPriorityQueue
            System.out.println("UnsortedLinkedPriorityQueue");
            startTime = System.currentTimeMillis();
            unsortedLinkedPriorityQueue.removeMin();
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println("Time: " + time + "ms");
            System.out.println();

            // SortedArrayPriorityQueue
            System.out.println("SortedArrayPriorityQueue");
            startTime = System.currentTimeMillis();
            sortedArrayPriorityQueue.removeMin();
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println("Time: " + time + "ms");
            System.out.println();

            // SortedLinkedPriorityQueue
            System.out.println("SortedLinkedPriorityQueue");
            startTime = System.currentTimeMillis();
            sortedLinkedPriorityQueue.removeMin();
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println("Time: " + time + "ms");
            System.out.println();
        }


    }

}
