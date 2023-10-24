package test.java;

import main.java.Plane;
import main.java.Point;
import org.junit.jupiter.api.Test;

class PlaneTest {


    @Test
    void testSettingFromFile() {
        String fileName = "sphere.txt";
        Plane plan = new Plane();
        plan.settingFromFile(fileName);

        Point p1 = plan.getA();
        Point p2 = plan.getB();

        System.out.println("Point 1 : (" + p1.getX() + ", " + p1.getY() + ", " + p1.getZ() + ")");
        System.out.println("Point 2 : (" + p2.getX() + ", " + p2.getY() + ", " + p2.getZ() + ")");

    }
}

