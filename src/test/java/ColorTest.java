package test.java;

import main.java.scene.Color;
import org.junit.Test;
import static org.junit.Assert.*;

public class ColorTest {

    @Test
    public void testColorAddition() {
        Color color1 = new Color(0.5, 0.6, 0.7);
        Color color2 = new Color(0.2, 0.3, 0.1);
        Color result = color1.add(color2);
        Color expected = new Color(0.7, 0.9, 0.8);
        assertEquals(expected.getR(), result.getR(), 0.001);
        assertEquals(expected.getG(), result.getG(), 0.001);
        assertEquals(expected.getB(), result.getB(), 0.001);
    }

    @Test
    public void testColorScalarMultiplication() {
        Color color = new Color(0.5, 0.6, 0.7);
        double scalar = 2.0;
        Color result = color.multiply(scalar);
        Color expected = new Color(1.0, 1.2, 1.4);
        assertEquals(expected.getR(), result.getR(), 0.001);
        assertEquals(expected.getG(), result.getG(), 0.001);
        assertEquals(expected.getB(), result.getB(), 0.001);
    }

    @Test
    public void testColorSchurProduct() {
        Color color1 = new Color(0.5, 0.6, 0.7);
        Color color2 = new Color(0.2, 0.3, 0.1);
        Color result = color1.schurProduct(color2);
        Color expected = new Color(0.1, 0.18, 0.07);
        assertEquals(expected.getR(), result.getR(), 0.001);
        assertEquals(expected.getG(), result.getG(), 0.001);
        assertEquals(expected.getB(), result.getB(), 0.001);
    }

}
