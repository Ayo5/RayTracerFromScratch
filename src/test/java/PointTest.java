package test.java;


import main.java.math.Point;
import org.junit.Test;
import static org.junit.Assert.*;
import main.java.math.Vector;

public class PointTest {

    @Test
    public void testPointSubtraction() {
        Point point1 = new Point(1.0, 2.0, 3.0);
        Point point2 = new Point(4.0, 5.0, 6.0);
        Vector result = point1.subtract(point2);
        Vector expected = new Vector(-3.0, -3.0, -3.0);
        assertEquals(expected.getX(), result.getX(), 0.001);
        assertEquals(expected.getY(), result.getY(), 0.001);
        assertEquals(expected.getZ(), result.getZ(), 0.001);
    }

    @Test
    public void testPointScalarMultiplication() {
        Point point = new Point(1.0, 2.0, 3.0);
        double scalar = 2.0;
        Point result = point.multiply(scalar);
        Point expected = new Point(2.0, 4.0, 6.0);
        assertEquals(expected.getX(), result.getX(), 0.001);
        assertEquals(expected.getY(), result.getY(), 0.001);
        assertEquals(expected.getZ(), result.getZ(), 0.001);
    }

}
