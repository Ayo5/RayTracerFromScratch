package main.java.scene;

import main.java.coordinate.Point;
import main.java.coordinate.Triplet;
import main.java.object.SceneObject;

/**
 * The Intersection class represents an intersection between a ray and a scene object.
 * It contains information about the point of intersection, the normal to the surface,
 * and the distance from the ray's origin to the intersection point.
 */
public class Intersection {
    private SceneObject object; // The object with which the ray intersects
    private Triplet point; // Intersection point in world coordinates
    private Triplet normal; // Normal to the intersection surface
    private double distance; // Distance from the ray's origin to the intersection

    /**
     * Constructs a new Intersection with the specified parameters.
     *
     * @param object   The object with which the ray intersects.
     * @param point    The intersection point in world coordinates.
     * @param normal   The normal to the intersection surface.
     * @param distance The distance from the ray's origin to the intersection point.
     */
    public Intersection(SceneObject object, Triplet point, Triplet normal, double distance) {
        this.object = object;
        this.point = point;
        this.normal = normal;
        this.distance = distance;
    }

    /**
     * Gets the object with which the ray intersects.
     *
     * @return The scene object involved in the intersection.
     */
    public SceneObject getObject() {
        return object;
    }

    /**
     * Gets the intersection point in world coordinates.
     *
     * @return The point of intersection.
     */
    public Triplet getPoint(Point intersectionPoint) {
        return point;
    }

    /**
     * Gets the normal to the intersection surface.
     *
     * @return The normal vector to the surface at the intersection point.
     */
    public Triplet getNormal() {
        return normal;
    }

    /**
     * Gets the distance from the ray's origin to the intersection point.
     *
     * @return The distance from the ray's origin to the intersection.
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Sets the distance to the intersection point.
     *
     * @param distance The new distance to the intersection point.
     */
    public void setIntersectionDistance(double distance) {
        this.distance = distance;
    }
}
