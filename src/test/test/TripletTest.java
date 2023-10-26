package test;

import main.java.math.Triplet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TripletTest {

    @Test
    public void testAddition() {
        Triplet t1 = new Triplet(1, 2, 3);
        Triplet t2 = new Triplet(4, 5, 6);
        Triplet result = t1.addition(t2);
        assertEquals(new Triplet(5, 7, 9), result);
    }

    @Test
    public void testSubtraction() {
        Triplet t1 = new Triplet(4, 5, 6);
        Triplet t2 = new Triplet(1, 2, 3);
        Triplet result = t1.subtraction(t2);
        assertEquals(new Triplet(3, 3, 3), result);
    }

    @Test
    public void testDotScalar() {
        Triplet t1 = new Triplet(1, 2, 3);
        Triplet t2 = new Triplet(4, 5, 6);
        double result = t1.dotScalar(t2);
        assertEquals(32, result);
    }

    @Test
    public void testMultiplyScalar() {
        Triplet t1 = new Triplet(1, 2, 3);
        Triplet t2 = new Triplet(4, 5, 6);
        Triplet result = t1.multiplyScalar(t2);
        assertEquals(new Triplet(-3, 6, -3), result);
    }

    @Test
    public void testDotSchur() {
        Triplet t1 = new Triplet(1, 2, 3);
        Triplet t2 = new Triplet(4, 5, 6);
        Triplet result = t1.dotSchur(t2);
        assertEquals(new Triplet(4, 10, 18), result);
    }

    @Test
    public void testLength() {
        Triplet t = new Triplet(3, 4, 5);
        double length = t.length();
        assertEquals(7.0710678118654755, length, 0.0001);
    }

    @Test
    public void testNormalize() {
        Triplet t = new Triplet(3, 4, 5);
        Triplet normalized = t.normalize();
        assertEquals(new Triplet(0.4242640687119285, 0.565685424949238, 0.7071067811865475), normalized);
    }

    @Test
    public void testDistance() {
        Triplet a = new Triplet(1, 2, 3);
        Triplet b = new Triplet(4, 5, 6);
        float distance = Triplet.distance(a, b);
        assertEquals(5.196152, distance, 0.0001);
    }
}
