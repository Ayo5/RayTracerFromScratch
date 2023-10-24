package main.java.scene;

import main.java.coordinate.Vector;

public class DirectionalLight extends Light {
    private Vector direction;

    public DirectionalLight(Color color, Vector direction) {
        super(color);
        this.direction = direction;
    }

    public Vector getDirection() {
        return direction;
    }
}
