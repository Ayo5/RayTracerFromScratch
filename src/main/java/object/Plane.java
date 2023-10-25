package main.java.object;

import main.java.coordinate.Point;
import main.java.coordinate.Vector;
import main.java.scene.Ray;
import main.java.scene.Scene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Plane class represents a plane object in a three-dimensional scene.
 * It extends the SceneObject class and defines methods for intersection testing and loading data from a file.
 */
public class Plane extends SceneObject {
    private Point a;
    private Point b;

    /**
     * Gets the first point (a) defining the plane.
     *
     * @return The first point (a) defining the plane.
     */
    public Point getA() {
        return a;
    }

    /**
     * Gets the second point (b) defining the plane.
     *
     * @return The second point (b) defining the plane.
     */
    public Point getB() {
        return b;
    }

    /**
     * Constructs a new Plane object with null values for points a and b.
     */
    public Plane() {
        this.a = null;
        this.b = null;
    }

    /**
     * Checks if a ray intersects with the plane and populates the intersection data.
     *
     * @param ray           The ray to test for intersection.
     * @param intersection  An intersection object to populate with data if an intersection is found.
     * @return true if the ray intersects with the plane, false otherwise.
     */
    @Override
    public boolean intersect(Ray ray, Scene.Intersection intersection) {
        return false; // Actual implementation needed for intersection testing.
    }

    /**
     * Finds the distance to the intersection point between the plane and a ray defined by a point and direction vector.
     *
     * @param p  The point of origin for the ray.
     * @param d  The direction vector of the ray.
     * @return The distance to the intersection point, or 0 if there is no intersection.
     */
    @Override
    public double findIntersectionDistance(Point p, Vector d) {
        return 0; // Actual implementation needed to find intersection distance.
    }

    /**
     * Loads plane data from a file specified by the given file name.
     *
     * @param fileName The name of the file containing plane data.
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
                    if (keyword.equals("plane")) {
                        try {
                            double x = Double.parseDouble(words[1]);
                            double y = Double.parseDouble(words[2]);
                            double z = Double.parseDouble(words[3]);
                            double u = Double.parseDouble(words[4]);
                            double v = Double.parseDouble(words[5]);
                            double w = Double.parseDouble(words[6]);
                            a = new Point(x, y, z);
                            b = new Point(u, v, w);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format in the plane line.");
                        }
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
