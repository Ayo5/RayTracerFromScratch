package main.java.scene;

import main.java.coordinate.Point;
import main.java.coordinate.Triplet;
import main.java.object.SceneObject;
import java.util.ArrayList;
import java.util.List;

/**
 * The Scene class represents a 3D scene composed of objects, lights, and a camera for rendering.
 */
public class Scene {
    private List<SceneObject> objects; // List of scene objects in the scene.
    private List<Light> lights;        // List of lights in the scene.
    private Camera camera;             // The camera defining the view.
    private int imgWidth;              // Width of the rendered image in pixels.
    private int imgHeight;             // Height of the rendered image in pixels.

    /**
     * Constructs a new scene with the specified image dimensions.
     *
     * @param imgWidth  The width of the rendered image in pixels.
     * @param imgHeight The height of the rendered image in pixels.
     */
    public Scene(int imgWidth, int imgHeight) {
        this.objects = new ArrayList<>();
        this.lights = new ArrayList<>();
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;
    }

    /**
     * Gets the list of scene objects in the scene.
     *
     * @return The list of scene objects.
     */
    public List<SceneObject> getObjects() {
        return objects;
    }

    /**
     * Gets the list of lights in the scene.
     *
     * @return The list of lights.
     */
    public List<Light> getLights() {
        return lights;
    }

    /**
     * Adds a scene object to the scene.
     *
     * @param object The scene object to add.
     */
    public void addObject(SceneObject object) {
        objects.add(object);
    }

    /**
     * Adds a light to the scene.
     *
     * @param light The light to add.
     */
    public void addLight(Light light) {
        lights.add(light);
    }

    /**
     * Gets the camera defining the view of the scene.
     *
     * @return The camera object.
     */
    public Camera getCamera() {
        return camera;
    }

    /**
     * Sets the camera for the scene.
     *
     * @param camera The camera to set.
     */
    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    /**
     * Gets the width of the rendered image in pixels.
     *
     * @return The image width.
     */
    public int getImageWidth() {
        return imgWidth;
    }

    /**
     * Gets the height of the rendered image in pixels.
     *
     * @return The image height.
     */
    public int getImageHeight() {
        return imgHeight;
    }

    /**
     * The Intersection class represents a point of intersection between a ray and an object in the scene.
     */
    public static class Intersection {
        private SceneObject object; // The object with which the ray intersects.
        private Triplet point;      // The intersection point in world coordinates.
        private Triplet normal;     // The normal to the intersection surface.
        private double distance;    // The distance from the ray's starting point to the intersection.

        /**
         * Constructs an Intersection with the specified properties.
         *
         * @param object    The object with which the ray intersects.
         * @param point     The intersection point in world coordinates.
         * @param normal    The normal to the intersection surface.
         * @param distance  The distance from the ray's starting point to the intersection.
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
         * @return The intersected object.
         */
        public SceneObject getObject() {
            return object;
        }

        /**
         * Gets the intersection point in world coordinates.
         *
         * @return The intersection point.
         */
        public Triplet getPoint(Point intersectionPoint) {
            return point;
        }

        /**
         * Gets the normal to the intersection surface.
         *
         * @return The intersection normal.
         */
        public Triplet getNormal() {
            return normal;
        }

        /**
         * Gets the distance from the ray's starting point to the intersection.
         *
         * @return The intersection distance.
         */
        public double getDistance() {
            return distance;
        }

        /**
         * Sets the intersection distance.
         *
         * @param distance The intersection distance to set.
         */
        public void setIntersectionDistance(double distance) {
            this.distance = distance;
        }
    }
}
