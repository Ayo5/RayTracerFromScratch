package main.java.object;

import main.java.coordinate.Vector;
import main.java.scene.Material;
import main.java.coordinate.Point;
import main.java.scene.Ray;
import main.java.scene.Scene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Triangle class represents a three-dimensional triangle object in a scene.
 * It extends the SceneObject class and defines methods for intersection testing and loading data from a file.
 */
public class Triangle extends SceneObject {

    private Point p1;
    private Point p2;
    private Point p3;

    private Material material;

    /**
     * Constructs a new Triangle object with null material and vertices.
     */
    public Triangle() {
        this.p1 = null;
        this.p2 = null;
        this.p3 = null;
        this.material = null;
    }

    /**
     * Checks if a ray intersects with the triangle and populates the intersection data.
     *
     * @param ray           The ray to test for intersection.
     * @param intersection  An intersection object to populate with data if an intersection is found.
     * @return true if the ray intersects with the triangle, false otherwise.
     */
    @Override
    public boolean intersect(Ray ray, Scene.Intersection intersection) {
        return false; // Actual implementation needed for intersection testing.
    }

    /**
     * Finds the distance to the intersection point between the triangle and a ray defined by a point and direction vector.
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
     * Sets the first vertex of the triangle.
     *
     * @param p1 The first vertex of the triangle.
     */
    public void setP1(Point p1) {
        this.p1 = p1;
    }

    /**
     * Sets the second vertex of the triangle.
     *
     * @param p2 The second vertex of the triangle.
     */
    public void setP2(Point p2) {
        this.p2 = p2;
    }

    /**
     * Sets the third vertex of the triangle.
     *
     * @param p3 The third vertex of the triangle.
     */
    public void setP3(Point p3) {
        this.p3 = p3;
    }

    /**
     * Gets the first vertex of the triangle.
     *
     * @return The first vertex of the triangle.
     */
    public Point getP1() {
        return p1;
    }

    /**
     * Gets the second vertex of the triangle.
     *
     * @return The second vertex of the triangle.
     */
    public Point getP2() {
        return p2;
    }

    /**
     * Gets the third vertex of the triangle.
     *
     * @return The third vertex of the triangle.
     */
    public Point getP3() {
        return p3;
    }

    /**
     * Loads triangle data from a file specified by the given file name.
     *
     * @param fileName The name of the file containing triangle data.
     */
    public void settingFromFile(String fileName) {
        try {
            File file = new File("src/main/resource/" + fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int nbPoints = 0;
            Point[] listPoints = null;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                if (words.length > 0) {
                    String keyword = words[0];
                    if (keyword.equals("maxverts")) {
                        nbPoints = Integer.parseInt(words[1]);
                        listPoints = new Point[nbPoints];
                    } else if (keyword.equals("vertex")) {
                        try {
                            double x = Double.parseDouble(words[1]);
                            double y = Double.parseDouble(words[2]);
                            double z = Double.parseDouble(words[3]);
                            Point vertex = new Point(x, y, z);
                            if (nbPoints > 0) {
                                listPoints[nbPoints - 1] = vertex;
                                nbPoints--;
                            } else {
                                System.out.println("Too many points specified compared to maxverts.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format in the vertex line.");
                        }
                    } else if (keyword.equals("tri")) {
                        try {
                            int index1 = Integer.parseInt(words[1]);
                            int index2 = Integer.parseInt(words[2]);
                            int index3 = Integer.parseInt(words[3]);

                            if (index1 < listPoints.length && index2 < listPoints.length && index3 < listPoints.length) {
                                Point p1 = listPoints[index1];
                                Point p2 = listPoints[index2];
                                Point p3 = listPoints[index3];
                                Triangle triangle = new Triangle();
                                triangle.setP1(p1);
                                triangle.setP2(p2);
                                triangle.setP3(p3);
                            } else {
                                System.out.println("Invalid triangle indices relative to the specified points.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format in the triangle line.");
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
