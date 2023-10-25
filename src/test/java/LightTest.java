package test.java;

import main.java.scene.Light;
import main.java.scene.Color;
import org.junit.Test;
import static org.junit.Assert.*;
import main.java.scene.DirectionalLight;
import main.java.scene.PointLight;
import main.java.coordinate.Point;
import main.java.coordinate.Vector;

/**
 * This class contains test cases for the Light hierarchy, including DirectionalLight and PointLight classes.
 */
public class LightTest {

    /**
     * Test creating a DirectionalLight and checking its color and direction properties.
     */
    @Test
    public void testDirectionalLight() {
        Color color = new Color(1.0, 1.0, 1.0);
        Vector direction = new Vector(1.0, 0.0, 0.0);
        DirectionalLight light = new DirectionalLight(color, direction);

        assertEquals(color, light.getColor());
        assertEquals(direction, light.getDirection());
    }

    /**
     * Test creating a PointLight and checking its color and position properties.
     */
    @Test
    public void testPointLight() {
        Color color = new Color(1.0, 0.0, 0.0);
        Point position = new Point(2.0, 3.0, 4.0);
        PointLight light = new PointLight(color, position);

        assertEquals(color, light.getColor());
        assertEquals(position, light.getPoint());
    }

    /**
     * Test loading light properties from a file and verifying that the properties are correctly loaded.
     */
    @Test
    public void testLoadPropertiesFromFile() {
        Light light = new Light(new Color(1.0, 1.0, 1.0));

        light.loadPropertiesFromFile("src/main/ressource/objet.txt");

        // Verify that the properties have been loaded correctly
        assertEquals(1.0, light.getColor().getR(), 0.001);
        assertEquals(1.0, light.getColor().getG(), 0.001);
        assertEquals(1.0, light.getColor().getB(), 0.001);
    }
}
