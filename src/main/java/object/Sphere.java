package main.java.object;

import main.java.coordinate.Point;
import main.java.coordinate.Vector;
import main.java.scene.*;

import java.io.*;

/**
 * The Sphere class represents a three-dimensional sphere object in a scene.
 * It extends the SceneObject class and defines methods for intersection testing and loading data from a file.
 */
public class Sphere extends SceneObject {

    private Point center;
    private double radius;

    private Material material;

    /**
     * Gets the center point of the sphere.
     *
     * @return The center point of the sphere.
     */
    public Point getCentre() {
        return center;
    }

    /**
     * Gets the radius of the sphere.
     *
     * @return The radius of the sphere.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Gets the material assigned to the sphere.
     *
     * @return The material of the sphere.
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Sets the center point of the sphere.
     *
     * @param center The center point of the sphere.
     */
    public void setCentre(Point center) {
        this.center = center;
    }

    /**
     * Sets the radius of the sphere.
     *
     * @param radius The radius of the sphere.
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Constructs a new Sphere object with null material, center, and zero radius.
     */
    public Sphere() {
        super();
        this.center = null;
        this.radius = 0;
    }

    /**
     * Loads sphere data from a file specified by the given file name.
     *
     * @param fileName The name of the file containing sphere data.
     */
    public void settingFromFile(String fileName) {
        try {
            File file = new File("src/main/resource/" + fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                if (words.length > 0) {
                    String keyword = words[0];
                    if (keyword.equals("diffuse")) {
                        try {
                            double r = Double.parseDouble(words[1]);
                            double g = Double.parseDouble(words[2]);
                            double b = Double.parseDouble(words[3]);
                            material = new Material(new Color(r, g, b));
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format in the diffuse line.");
                        }
                    }
                    if (keyword.equals("sphere")) {
                        try {
                            double x = Double.parseDouble(words[1]);
                            double y = Double.parseDouble(words[2]);
                            double z = Double.parseDouble(words[3]);
                            double r = Double.parseDouble(words[4]);
                            center = new Point(x, y, z);
                            radius = r;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format in the sphere line.");
                        }
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    /**
     * Checks if a ray intersects with the sphere and populates the intersection data.
     *
     * @param ray           The ray to test for intersection.
     * @param intersection  An intersection object to populate with data if an intersection is found.
     * @return true if the ray intersects with the sphere, false otherwise.
     */
    @Override
    public boolean intersect(Ray ray, Scene.Intersection intersection) {
        Vector oc = ray.getOrigin().subtract(center);
        double a = ray.getDirection().dotScalar(ray.getDirection());
        double b = 2.0 * oc.dotScalar(ray.getDirection());
        double c = oc.dotScalar(oc) - radius * radius;
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double t1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            double t2 = (-b + Math.sqrt(discriminant)) / (2 * a);

            if (t1 > 0 || t2 > 0) {
                double distance = Math.min(t1, t2);
                Point intersectionPoint = ray.pointAt(distance);
                intersection.getPoint(intersectionPoint);
                intersection.setIntersectionDistance(distance);
                return true;
            }
        }

        return false;
    }

    /**
     * Finds the distance to the intersection point between the sphere and a ray defined by a point and direction vector.
     *
     * @param p  The point of origin for the ray.
     * @param d  The direction vector of the ray.
     * @return The distance to the intersection point, or -1.0 if there is no intersection.
     */
    @Override
    public double findIntersectionDistance(Point p, Vector d) {
        Vector oc = p.subtract(center);
        double a = d.dotScalar(d);
        double b = 2.0 * oc.dotScalar(d);
        double c = oc.dotScalar(oc) - radius * radius;
        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            return -1.0;
        } else {
            double t1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            double t2 = (-b + Math.sqrt(discriminant)) / (2 * a);

            if (t1 > 0 || t2 > 0) {
                return Math.min(t1, t2);
            }
        }

        return -1.0;
    }
}
