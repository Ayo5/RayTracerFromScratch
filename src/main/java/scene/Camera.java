package main.java.scene;

import main.java.math.Point;
import main.java.math.Vector;

public class Camera {
    private Point lookFrom;
    private Point lookAt;
    private Vector up;
    private double fov;

    public Camera(Point lookFrom, Point lookAt, Vector up, double fov) {
        this.lookFrom = lookFrom;
        this.lookAt = lookAt;
        this.up = up;
        this.fov = fov;
    }

    public void setLookFrom(Point lookFrom) {
        this.lookFrom = lookFrom;
    }

    public void setLookAt(Point lookAt) {
        this.lookAt = lookAt;
    }

    public void setUp(Vector up) {
        this.up = up;
    }

    public void setFov(double fov) {
        this.fov = fov;
    }

    public double getFov() {
        return fov;
    }

    public Point getLookFrom() {
        return lookFrom;
    }

    public Point getLookAt() {
        return lookAt;
    }

    public Vector getUp() {
        return up;
    }




}