package main.java.object;

import main.java.light.Colors;
import main.java.math.Point;
import main.java.math.Vector;

public class Sphere extends SceneObject {

    private final Point center;
    private final double radius;

    public Sphere(Point center, double radius, Colors color) {
        super(color);
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double intersect(Point lookFrom, Vector d) {
        Vector oc = lookFrom.subtract(center);
        double a = d.dotScalar(d);
        double b = 2 * oc.dotScalar(d);
        double c = oc.dotScalar(oc) - radius * radius;
        double discriminant = b * b - 4 * a * c;

        if (discriminant >= 0) {
            double t1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double t2 = (-b - Math.sqrt(discriminant)) / (2 * a);

            if (t1 >= 0 && t2 >= 0) {
                return Math.min(t1, t2);
            } else if (t1 >= 0) {
                return t1;
            } else if (t2 >= 0) {
                return t2;
            }
        }
        return -1;
    }
}
