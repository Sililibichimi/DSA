package DSA.Hw5_22000123_NguyenDucSi.baitap3;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        PlaneManager planeManager = new PlaneManager();

        Random random = new Random();
        String[] names = {"MH370", "VNAIRLINE696", "BAMBOO8386", "VIETJET369", "DUCKSHYSUPERVIP6969"};
        for(int i = 0; i < 48; ++i) {
            String time = String.format("%02d:%02d", i / 2, (i % 2) * 30);
            String name = names[random.nextInt(5)] + i;
            boolean isLanding = random.nextBoolean();
            Plane plane = new Plane(time, isLanding);
            planeManager.addPlane(plane, name);
        }

        for(int i = 0; i < 48; ++i) {
            Plane plane = planeManager.nextPlane();
            String name = planeManager.queue.min().getValue();
            System.out.println((i+1) + "TH FLIGHT:");
            System.out.println("        Name: " + name);
            System.out.println("        Time: " + plane.getTime());
            System.out.println("        Status: " + (plane.isLanding() ? "Landing" : "Taking off"));
            System.out.println("____________________________________________________");
            planeManager.removePlane();
        }

    }
}
