package test;

import main.java.light.Colors;
import main.java.math.Point;
import main.java.math.Vector;
import main.java.object.Sphere;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * The type Sphere test.
 */
public class SphereTest {

    /**
     * Test constructor and getters.
     */
    @Test
    public void testConstructorAndGetters() {
        Point center = new Point(1, 2, 3);
        double radius = 4;
        Colors color = new Colors(255, 0, 0);
        Sphere sphere = new Sphere(center, radius, color);

        assertEquals(center, sphere.getCenter());
        assertEquals(radius, sphere.getRadius());
        assertEquals(color, sphere.getColor());
    }

    /**
     * Test intersect.
     */
    @Test
    public void testIntersect() {
        Point center = new Point(0, 0, 0);
        double radius = 1;
        Colors color = new Colors(255, 0, 0);
        Sphere sphere = new Sphere(center, radius, color);

        // Ray intersects the sphere from outside
        Point lookFrom = new Point(0, 0, 2);
        Vector d = new Vector(0, 0, -1);
        double t = sphere.intersect(lookFrom, d);
        assertEquals(1.0, t, 0.0001);

        // Ray intersects the sphere from inside
        lookFrom = new Point(0, 0, 0);
        d = new Vector(0, 0, 1);
        t = sphere.intersect(lookFrom, d);
        assertEquals(1.0, t, 0.0001);

        // Ray misses the sphere
        lookFrom = new Point(0, 0, 2);
        d = new Vector(1, 0, 0);
        t = sphere.intersect(lookFrom, d);
        assertEquals(-1.0, t, 0.0001);
    }

    /**
     * Test intersect on p.
     */
    @Test
    public void testIntersectOnP() {
        Point center = new Point(0, 0, 0);
        double radius = 1;
        Colors color = new Colors(255, 0, 0);
        Sphere sphere = new Sphere(center, radius, color);

        // Ray intersects the sphere from outside
        Point lookFrom = new Point(0, 0, 2);
        Vector d = new Vector(0, 0, -1);
        Point intersectionPoint = sphere.intersectOnP(lookFrom, d);
        assertEquals(new Point(0, 0, 1), intersectionPoint);

        // Ray intersects the sphere from inside
        lookFrom = new Point(0, 0, 0);
        d = new Vector(0, 0, 1);
        intersectionPoint = sphere.intersectOnP(lookFrom, d);
        assertEquals(new Point(0, 0, 1), intersectionPoint);

        // Ray misses the sphere
        lookFrom = new Point(0, 0, 2);
        d = new Vector(1, 0, 0);
        intersectionPoint = sphere.intersectOnP(lookFrom, d);
        assertNull(intersectionPoint);
    }

    /**
     * Test create vector n.
     */
    @Test
    public void testCreateVectorN() {
        Point center = new Point(0, 0, 0);
        double radius = 1;
        Colors color = new Colors(255, 0, 0);
        Sphere sphere = new Sphere(center, radius, color);

        // Ray intersects the sphere from outside
        Point lookFrom = new Point(0, 0, 2);
        Vector d = new Vector(0, 0, -1);
        Vector normal = sphere.createVectorN(lookFrom, d);
        assertEquals(new Vector(0, 0, 1), normal);

        // Ray intersects the sphere from inside
        lookFrom = new Point(0, 0, 0);
        d = new Vector(0, 0, 1);
        normal = sphere.createVectorN(lookFrom, d);
        assertEquals(new Vector(0, 0, -1), normal);

        // Ray misses the sphere
        lookFrom = new Point(0, 0, 2);
        d = new Vector(1, 0, 0);
        normal = sphere.createVectorN(lookFrom, d);
        assertNull(normal);
    }
}
