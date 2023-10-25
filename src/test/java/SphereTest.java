package test.java;

import main.java.coordinate.Point;
import main.java.object.Sphere;

/**
 * This class contains a test for the 'settingFromFile' method of the Sphere class.
 * It reads sphere data from a file and prints the sphere's center and radius.
 */
public class SphereTest {
    public static void main(String[] args) {
        String fileName = "sphere.txt";
        Sphere sphere = new Sphere();
        sphere.settingFromFile(fileName);

        Point centre = sphere.getCentre();
        double radius = sphere.getRadius();

        if (centre != null) {
            System.out.println("Center of the sphere: (" + centre.getX() + ", " +
                    centre.getY() + ", " + centre.getZ() + ")");
        } else {
            System.out.println("Center of the sphere is not defined.");
        }
        System.out.println("Radius of the sphere: " + radius);
    }
}
