package test.java;

import sae301.Point;
import sae301.Sphere;

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
        System.out.println("Rayon de la sphère : " + radius );
            }
}
