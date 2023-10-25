package test.java;

import main.java.coordinate.Vector;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This class contains unit tests for the methods of the Vector class.
 */
public class VectorTest {

    /**
     * Test the addition of two vectors.
     */
    @Test
    public void testVectorAddition() {
        Vector vector1 = new Vector(1.0, 2.0, 3.0);
        Vector vector2 = new Vector(4.0, 5.0, 6.0);
        Vector result = vector1.addition(vector2);
        Vector expected = new Vector(5.0, 7.0, 9.0);
        assertEquals(expected.getX(), result.getX(), 0.001);
        assertEquals(expected.getY(), result.getY(), 0.001);
        assertEquals(expected.getZ(), result.getZ(), 0.001);
    }

    /**
     * Test the subtraction of two vectors.
     */
    @Test
    public void testVectorSubtraction() {
        Vector vector1 = new Vector(1.0, 2.0, 3.0);
        Vector vector2 = new Vector(4.0, 5.0, 6.0);
        Vector result = vector1.subtraction(vector2);
        Vector expected = new Vector(-3.0, -3.0, -3.0);
        assertEquals(expected.getX(), result.getX(), 0.001);
        assertEquals(expected.getY(), result.getY(), 0.001);
        assertEquals(expected.getZ(), result.getZ(), 0.001);
    }

    /**
     * Test the scalar multiplication of a vector.
     */
    @Test
    public void testVectorScalarMultiplication() {
        Vector vector = new Vector(1.0, 2.0, 3.0);
        double scalar = 2.0;
        Vector result = vector.multiplicationScalar(scalar);
        Vector expected = new Vector(2.0, 4.0, 6.0);
        assertEquals(expected.getX(), result.getX(), 0.001);
        assertEquals(expected.getY(), result.getY(), 0.001);
        assertEquals(expected.getZ(), result.getZ(), 0.001);
    }

    /**
     * Test the dot product of two vectors.
     */
    @Test
    public void testVectorDotProduct() {
        Vector vector1 = new Vector(1.0, 2.0, 3.0);
        Vector vector2 = new Vector(4.0, 5.0, 6.0);
        double result = vector1.dotScalar(vector2);
        double expected = 32.0;
        assertEquals(expected, result, 0.001);
    }

    /**
     * Test the cross product of two vectors.
     */
    @Test
    public void testVectorCrossProduct() {
        Vector vector1 = new Vector(1.0, 2.0, 3.0);
        Vector vector2 = new Vector(4.0, 5.0, 6.0);
        Vector result = vector1.dotVectorial(vector2);
        Vector expected = new Vector(-3.0, 6.0, -3.0);
        assertEquals(expected.getX(), result.getX(), 0.001);
        assertEquals(expected.getY(), result.getY(), 0.001);
        assertEquals(expected.getZ(), result.getZ(), 0.001);
    }
}
