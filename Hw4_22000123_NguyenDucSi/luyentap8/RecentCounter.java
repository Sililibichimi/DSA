package DSA.Hw4_22000123_NguyenDucSi.luyentap8;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    Queue<Integer> q;
    public RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.add(t);
        while(q.peek() < t - 3000) {
            q.poll();
        }
        return q.size();
    }
}
