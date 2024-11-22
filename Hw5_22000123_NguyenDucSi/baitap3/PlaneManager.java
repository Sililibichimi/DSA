package DSA.Hw5_22000123_NguyenDucSi.baitap3;

import DSA.Hw5_22000123_NguyenDucSi.baitap1.SortedArrayPriorityQueue;

public class PlaneManager {
    SortedArrayPriorityQueue<Plane, String> queue;

    public PlaneManager() {
        queue = new SortedArrayPriorityQueue<>();
    }

    public void addPlane(Plane plane, String name) {
        queue.insert(plane, name);
    }

    public Plane nextPlane() {
        String time = queue.min().getKey().getTime();
        String isLanding = queue.min().getValue();
        return new Plane(time, isLanding.equals("true"));
    }

    public void removePlane() {
        queue.removeMin();
    }
}
