package main.java.object;

import main.java.coordinate.Point;
import main.java.coordinate.Vector;
import main.java.scene.Material;
import main.java.scene.Ray;
import main.java.scene.Scene;

/**
 * The SceneObject class represents an abstract object in a three-dimensional scene.
 * It defines methods and properties common to all objects in the scene.
 */
public abstract class SceneObject {
    private Material material;

    /**
     * Constructs a new SceneObject with null material.
     */
    public SceneObject() {
        this.material = null;
    }

    /**
     * Checks if a ray intersects with the scene object and populates the intersection data.
     *
     * @param ray           The ray to test for intersection.
     * @param intersection  An intersection object to populate with data if an intersection is found.
     * @return true if the ray intersects with the object, false otherwise.
     */
    public abstract boolean intersect(Ray ray, Scene.Intersection intersection);

    /**
     * Gets the material assigned to the scene object.
     *
     * @return The material of the scene object.
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Sets the material for the scene object.
     *
     * @param material The material to be assigned to the scene object.
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * Finds the distance to the intersection point between the scene object and a ray defined by a point and direction vector.
     *
     * @param p  The point of origin for the ray.
     * @param d  The direction vector of the ray.
     * @return The distance to the intersection point, or a suitable value if there is no intersection.
     */
    public abstract double findIntersectionDistance(Point p, Vector d);
}
