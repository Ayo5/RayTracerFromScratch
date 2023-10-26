package test.java;


import main.java.light.Colors;
import org.junit.Test;
import static org.junit.Assert.*;

public class ColorTest {

    @Test
    public void testColorAddition() {
        Colors color1 = new Colors(0.5, 0.6, 0.7);
        Colors color2 = new Colors(0.2, 0.3, 0.1);
        Colors result = color1.add(color2);
        Colors expected = new Colors(0.7, 0.9, 0.8);
        assertEquals(expected.getR(), result.getR(), 0.001);
        assertEquals(expected.getG(), result.getG(), 0.001);
        assertEquals(expected.getB(), result.getB(), 0.001);
    }

    @Test
    public void testColorScalarMultiplication() {
        Colors color = new Colors(0.5, 0.6, 0.7);
        double scalar = 2.0;
        Colors result = color.multiply(scalar);
        Colors expected = new Colors(1.0, 1.2, 1.4);
        assertEquals(expected.getR(), result.getR(), 0.001);
        assertEquals(expected.getG(), result.getG(), 0.001);
        assertEquals(expected.getB(), result.getB(), 0.001);
    }

    @Test
    public void testColorSchurProduct() {
        Colors color1 = new Colors(0.5, 0.6, 0.7);
        Colors color2 = new Colors(0.2, 0.3, 0.1);
        Colors result = color1.schurProduct(color2);
        Colors expected = new Colors(0.1, 0.18, 0.07);
        assertEquals(expected.getR(), result.getR(), 0.001);
        assertEquals(expected.getG(), result.getG(), 0.001);
        assertEquals(expected.getB(), result.getB(), 0.001);
    }

}
