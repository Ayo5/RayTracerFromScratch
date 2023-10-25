package test.java;


import main.java.scene.Light;
import main.java.scene.Color;
import org.junit.Test;
import static org.junit.Assert.*;
import main.java.scene.DirectionalLight;
import main.java.scene.PointLight;
import main.java.coordinate.Point;
import main.java.coordinate.Vector;



public class LightTest {

    @Test
    public void testDirectionalLight() {
        Color color = new Color(1.0, 1.0, 1.0);
        Vector direction = new Vector(1.0, 0.0, 0.0);
        DirectionalLight light = new DirectionalLight(color, direction);

        assertEquals(color, light.getColor());
        assertEquals(direction, light.getDirection());
    }

    @Test
    public void testPointLight() {
        Color color = new Color(1.0, 0.0, 0.0);
        Point position = new Point(2.0, 3.0, 4.0);
        double intensity = 100.0;
        PointLight light = new PointLight(color, position);

        assertEquals(color, light.getColor());
        assertEquals(position, light.getPoint());

    }

    @Test
    public void testLoadPropertiesFromFile() {
        Light light = new Light(new Color(1.0, 1.0, 1.0));

        light.loadPropertiesFromFile("src/main/ressource/objet.txt");

        // Vérifiez que les propriétés ont été chargées correctement
        assertEquals(1.0, light.getColor().getR(), 0.001);
        assertEquals(1.0, light.getColor().getG(), 0.001);
        assertEquals(1.0, light.getColor().getB(), 0.001);
    }

}
