package DSA.Hw5_22000123_NguyenDucSi.baitap3;

public class Plane implements Comparable<Plane> {

    private String time;
    private boolean isLanding;

    public Plane() {
        this.time = "--:--";
        this.isLanding = false;
    }

    public Plane(String time, boolean isLanding) {
        this.time = time;
        this.isLanding = isLanding;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isLanding() {
        return isLanding;
    }

    public void setLanding(boolean landing) {
        isLanding = landing;
    }

    @Override
    public int compareTo(Plane o) {
        return this.time.compareTo(o.time);
    }
}
