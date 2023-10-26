package test;

import main.java.light.Colors;
import main.java.light.DirectionalLight;
import main.java.math.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionalLightTest {

    @Test
    public void testConstructorAndGetters() {
        Vector direction = new Vector(1, 0, 0);
        Colors color = new Colors(255, 255, 255);

        DirectionalLight directionalLight = new DirectionalLight(direction, color);

        assertEquals(direction, directionalLight.getDirection());
        assertEquals(color, directionalLight.getColor());
    }

    @Test
    public void testSetDirection() {
        Vector initialDirection = new Vector(1, 0, 0);
        Vector newDirection = new Vector(0, 1, 0);
        Colors color = new Colors(1, 0, 0);

        DirectionalLight directionalLight = new DirectionalLight(initialDirection, color);
        directionalLight.setDirection(newDirection);

        assertEquals(newDirection, directionalLight.getDirection());
    }
}
