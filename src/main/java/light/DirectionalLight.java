package main.java.light;

import main.java.math.Vector;


/**
 * The type Directional light.
 */
public class DirectionalLight extends Light {
    private Vector direction;

    /**
     * Instantiates a new Directional light.
     *
     * @param direction the direction
     * @param color     the color
     */
    public DirectionalLight(Vector direction, Colors color) {
        super(color);
        this.direction = direction;
    }

    /**
     * Sets direction.
     *
     * @param direction the direction
     */
    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    /**
     * Gets direction.
     *
     * @return the direction
     */
    public Vector getDirection() {
        return direction;
    }

}



