package test.java;

import main.java.Point;
import main.java.Sphere;

public class SphereTest {
    public static void main(String[] args) {
        String fileName = "sphere.txt";
        Sphere sphere = new Sphere();
        sphere.settingFromFile(fileName);
        Point centre = sphere.getCentre();
        double radius = sphere.getRadius();
        if (centre != null) {
            System.out.println("Centre de la sphère : (" + centre.getX() + ", " +
                    centre.getY() + ", " + centre.getZ() + ")");
        } else {
            System.out.println("Centre de la sphère non défini.");
        }
        System.out.println("Rayon de la sphère : " + radius);
            }
}
