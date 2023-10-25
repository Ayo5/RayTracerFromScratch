package main.java.scene;

import main.java.coordinate.Point;
import main.java.coordinate.Vector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Camera class represents a virtual camera in a three-dimensional scene.
 * It defines the camera's position, look-at point, up vector, and field of view (fov).
 */
public class Camera {
    private Point position; // Camera position (the eye)
    private Point lookAt;   // Point being looked at
    private Vector up;      // Upward vector
    private double fov;     // Field of view

    /**
     * Constructs a new Camera with the specified parameters.
     *
     * @param position The camera's position (the eye).
     * @param lookAt   The point being looked at.
     * @param up       The up vector.
     * @param fov      The field of view.
     */
    public Camera(Point position, Point lookAt, Vector up, double fov) {
        this.position = position;
        this.lookAt = lookAt;
        this.up = up;
        this.fov = fov;
    }

    /**
     * Sets the camera's position (the eye).
     *
     * @param position The new camera position.
     */
    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     * Sets the point being looked at.
     *
     * @param lookAt The new point to look at.
     */
    public void setLookAt(Point lookAt) {
        this.lookAt = lookAt;
    }

    /**
     * Sets the up vector.
     *
     * @param up The new up vector.
     */
    public void setUp(Vector up) {
        this.up = up;
    }

    /**
     * Sets the field of view.
     *
     * @param fov The new field of view.
     */
    public void setFov(double fov) {
        this.fov = fov;
    }

    /**
     * Gets the camera's position (the eye).
     *
     * @return The camera's position.
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Gets the point being looked at.
     *
     * @return The point being looked at.
     */
    public Point getLookAt() {
        return lookAt;
    }

    /**
     * Gets the up vector.
     *
     * @return The up vector.
     */
    public Vector getUp() {
        return up;
    }

    /**
     * Loads camera settings from a file specified by the given file name.
     *
     * @param fileName The name of the file containing camera settings.
     */
    public void loadCameraSettingsFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resource/" + fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                if (words.length > 0) {
                    String keyword = words[0];
                    if (keyword.equals("camera")) {
                        try {
                            double x = Double.parseDouble(words[1]);
                            double y = Double.parseDouble(words[2]);
                            double z = Double.parseDouble(words[3]);
                            double u = Double.parseDouble(words[4]);
                            double v = Double.parseDouble(words[5]);
                            double w = Double.parseDouble(words[6]);
                            double a = Double.parseDouble(words[7]);
                            double b = Double.parseDouble(words[8]);
                            double c = Double.parseDouble(words[9]);
                            double f = Double.parseDouble(words[10]);
                            position = new Point(x, y, z);
                            lookAt = new Point(u, v, w);
                            up = new Vector(a, b, c).normalize();
                            fov = f;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format in the camera parameter line.");
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
