package main.java.scene;

import main.java.math.Point;
import main.java.math.Vector;

/**
 * The type Camera.
 */
public class Camera {
    private Point lookFrom;
    private Point lookAt;
    private Vector up;
    private double fov;

    /**
     * Instantiates a new Camera.
     *
     * @param lookFrom the look from
     * @param lookAt   the look at
     * @param up       the up
     * @param fov      the fov
     */
    public Camera(Point lookFrom, Point lookAt, Vector up, double fov) {
        this.lookFrom = lookFrom;
        this.lookAt = lookAt;
        this.up = up;
        this.fov = fov;
    }

    /**
     * Sets look from.
     *
     * @param lookFrom the look from
     */
    public void setLookFrom(Point lookFrom) {
        this.lookFrom = lookFrom;
    }

    /**
     * Sets look at.
     *
     * @param lookAt the look at
     */
    public void setLookAt(Point lookAt) {
        this.lookAt = lookAt;
    }

    /**
     * Sets up.
     *
     * @param up the up
     */
    public void setUp(Vector up) {
        this.up = up;
    }

    /**
     * Sets fov.
     *
     * @param fov the fov
     */
    public void setFov(double fov) {
        this.fov = fov;
    }

    /**
     * Gets fov.
     *
     * @return the fov
     */
    public double getFov() {
        return fov;
    }

    /**
     * Gets look from.
     *
     * @return the look from
     */
    public Point getLookFrom() {
        return lookFrom;
    }

    /**
     * Gets look at.
     *
     * @return the look at
     */
    public Point getLookAt() {
        return lookAt;
    }

    /**
     * Gets up.
     *
     * @return the up
     */
    public Vector getUp() {
        return up;
    }




}