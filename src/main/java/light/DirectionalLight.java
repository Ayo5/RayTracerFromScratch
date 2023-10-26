package main.java.light;

import main.java.math.Vector;


public class DirectionalLight extends Light {
    private Vector direction;

    public DirectionalLight(Vector direction, Colors color) {
        super(color);
        this.direction = direction;
    }

    public void setDirection(Vector direction) {
        this.direction = direction;
    }
    public Vector getDirection() {
        return direction;
    }


    }



