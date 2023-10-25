package test.java;

import main.java.coordinate.Point;
import org.junit.Test;
import static org.junit.Assert.*;
import main.java.coordinate.Vector;

/**
 * This class contains tests for the Point class, which represents a point in 3D space.
 */
public class PointTest {

    /**
     * Test the subtraction of two points, resulting in a vector.
     */
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

    /**
     * Test the scalar multiplication of a point.
     */
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
