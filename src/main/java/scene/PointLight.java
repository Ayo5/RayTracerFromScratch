package main.java.scene;

import main.java.coordinate.Point;
import main.java.scene.Color;
import main.java.scene.Light;

public class PointLight extends Light {
    private Point position;
    private double intensity;

    public PointLight(Color color, Point position, double intensity) {
        super(color);
        this.position = position;
        this.intensity = intensity;
    }

    public Point getPosition() {
        return position;
    }

    public double getIntensity() {
        return intensity;
    }
}
