package main.java;

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
