package test.java;

import main.java.coordinate.Point;
import main.java.object.Plane;
import org.junit.jupiter.api.Test;

/**
 * This class contains tests for the Plane class, which represents a flat plane in 3D space.
 */
class PlaneTest {

    /**
     * Test reading plane settings from a file and checking the coordinates of points on the plane.
     */
    @Test
    void testSettingFromFile() {
        String fileName = "sphere.txt"; // Replace with the appropriate file name
        Plane plane = new Plane();
        plane.settingFromFile(fileName);

        Point p1 = plane.getA();
        Point p2 = plane.getB();

        System.out.println("Point 1: (" + p1.getX() + ", " + p1.getY() + ", " + p1.getZ() + ")");
        System.out.println("Point 2: (" + p2.getX() + ", " + p2.getY() + ", " + p2.getZ() + ")");
    }
}
