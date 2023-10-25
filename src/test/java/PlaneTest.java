package test.java;

<<<<<<< HEAD
import sae301.Plane;
import sae301.Point;
=======
import main.java.object.Plane;
import main.java.coordinate.Point;
>>>>>>> 4823f2e9ab7300190fceef1fbaf6b39831c73335
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

