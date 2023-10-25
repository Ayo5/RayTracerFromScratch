package test.java;


import main.java.coordinate.Point;
import main.java.object.Triangle;
import org.junit.jupiter.api.Test;

class TriangleTest {

    @Test
    void testSettingFromFile() {
        String fileName = "sphere.txt";
        Triangle triangle = new Triangle(null,null,null,null);
        triangle.settingFromFile(fileName);

        Point p1 = triangle.getP1();
        Point p2 = triangle.getP2();
        Point p3 = triangle.getP3();

        System.out.println("Point 1 : (" + p1.getX() + ", " + p1.getY() + ", " + p1.getZ() + ")");
        System.out.println("Point 2 : (" + p2.getX() + ", " + p2.getY() + ", " + p2.getZ() + ")");
        System.out.println("Point 3 : (" + p3.getX() + ", " + p3.getY() + ", " + p3.getZ() + ")");

    }
}
