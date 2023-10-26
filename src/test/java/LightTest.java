package test.java;


import main.java.light.Colors;
import main.java.light.DirectionalLight;
import main.java.light.Light;
import main.java.light.PointLight;
import org.junit.Test;
import static org.junit.Assert.*;

import main.java.math.Point;
import main.java.math.Vector;



public class LightTest {

    @Test
    public void testDirectionalLight() {
        Colors color = new Colors(1.0, 1.0, 1.0);
        Vector direction = new Vector(1.0, 0.0, 0.0);
        DirectionalLight light = new DirectionalLight(direction,color);

        assertEquals(color, light.getColor());
        assertEquals(direction, light.getDirection());
    }

    @Test
    public void testPointLight() {
        Colors color = new Colors(1.0, 0.0, 0.0);
        Point position = new Point(2.0, 3.0, 4.0);
        double intensity = 100.0;
        PointLight light = new PointLight(position,color);

        assertEquals(color, light.getColor());
        assertEquals(position, light.getPoint());

    }

    @Test
    public void testLoadPropertiesFromFile() {
        Light light = new Light(new Colors(1.0, 1.0, 1.0));

        light.loadPropertiesFromFile("src/main/ressource/objet.txt");

        // Vérifiez que les propriétés ont été chargées correctement
        assertEquals(1.0, light.getColor().getR(), 0.001);
        assertEquals(1.0, light.getColor().getG(), 0.001);
        assertEquals(1.0, light.getColor().getB(), 0.001);
    }

}
