package main.java.scene;

import main.java.coordinate.Point;
import main.java.coordinate.Vector;

/**
 * The Ray class represents a ray in a three-dimensional scene. It includes an origin point
 * and a direction vector that defines the path of the ray.
 */
public class Ray {
    private Point origin;      // The origin point of the ray.
    private Vector direction;  // The direction vector of the ray.

    /**
     * Constructs a new Ray with the specified origin and direction.
     *
     * @param origin    The origin point of the ray.
     * @param direction The direction vector of the ray.
     */
    public Ray(Point origin, Vector direction) {
        this.origin = origin;
        this.direction = direction;
    }

    /**
     * Gets the origin point of the ray.
     *
     * @return The origin point of the ray.
     */
    public Point getOrigin() {
        return origin;
    }

    /**
     * Gets the direction vector of the ray.
     *
     * @return The direction vector of the ray.
     */
    public Vector getDirection() {
        return direction;
    }

    /**
     * Computes and returns a point on the ray at a specified distance 't' from the origin.
     *
     * @param t The distance from the origin to the desired point on the ray.
     * @return The point on the ray at the specified distance 't'.
     */
    public Point pointAt(double t) {
        double x = origin.getX() + t * direction.getX();
        double y = origin.getY() + t * direction.getY();
        double z = origin.getZ() + t * direction.getZ();
        return new Point(x, y, z);
    }
}
