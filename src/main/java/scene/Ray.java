
package main.java.scene;

import main.java.math.Point;
import main.java.math.Vector;

public class Ray {
    private Point origin; // Origine du rayon
    private Vector direction; // Direction du rayon

    public Ray(Point origin, Vector direction) {
        this.origin = origin;
        this.direction = direction;
    }
    public Point getOrigin() {
        return origin;
    }

    public Vector getDirection() {
        return direction;
    }


    public Point pointAt(double t) {
        double x = origin.getX() + t * direction.getX();
        double y = origin.getY() + t * direction.getY();
        double z = origin.getZ() + t * direction.getZ();
        return new Point(x, y, z);
    }

}
