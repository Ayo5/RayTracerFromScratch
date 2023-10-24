package main.java.scene;

import main.java.coordinate.Vector;

public class DirectionalLight extends Light {
    private Vector direction;
    private Color color;

    public DirectionalLight(Color color, Vector direction) {
        super(color);
        this.direction = direction;
        this.color = color;
    }

    public Vector getDirection() {
        return direction;
    }

    public Color getColor() { return color; }
}
