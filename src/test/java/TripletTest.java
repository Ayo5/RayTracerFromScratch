package test.java;

import main.java.coordinate.Triplet;
import org.junit.Test;
import static org.junit.Assert.*;

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
        Triplet t1 = new Triplet(1, 2, 3);
        Triplet t2 = new Triplet(4, 5, 6);
        Triplet result = t1.subtraction(t2);
        assertEquals(new Triplet(-3, -3, -3), result);
    }
    @Test
    public void testMultiplicationScalar() {
        Triplet t1 = new Triplet(1, 2, 3);
        double scalar = 2;
        Triplet result = t1.mulplicationScalar(scalar);
        assertEquals(new Triplet(2, 4, 6), result);
    }

    @Test
    public void testDotScalar() {
        Triplet t1 = new Triplet(1, 2, 3);
        Triplet t2 = new Triplet(4, 5, 6);
        double result = t1.dotScalar(t2);
        assertEquals(32.0, result, 0.001);
    }

    @Test
    public void testDotVectorial() {
        Triplet t1 = new Triplet(1, 2, 3);
        Triplet t2 = new Triplet(4, 5, 6);
        Triplet result = t1.dotVectorial(t2);
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
        Triplet t = new Triplet(1, 2, 2);
        double result = t.lenght();
        assertEquals(3.0, result, 0.001);
    }

    @Test
    public void testNormalization() {
        Triplet t = new Triplet(1, 2, 2);
        Triplet normalized = t.normalisation();
        assertEquals(new Triplet(1.0 / 3, 2.0 / 3, 2.0 / 3), normalized);
    }
}
