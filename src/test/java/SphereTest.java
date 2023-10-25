package test.java;

import main.java.math.Point;
import main.java.object.Sphere;

public class SphereTest {
    public static void main(String[] args) {
        String fileName = "sphere.txt";
        Sphere sphere = new Sphere(null, 0.0, null);
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
        System.out.println("Couleur de la sphère :" + sphere.getColor().getG());
            }
}
