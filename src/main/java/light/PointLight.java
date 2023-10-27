
package main.java.light;

import main.java.math.Point;


/**
 * The type Point light.
 */
public class PointLight extends Light {
    private Point point;

    /**
     * Instantiates a new Point light.
     *
     * @param point the point
     * @param color the color
     */
    public PointLight(Point point , Colors color) {
        super(color);
        this.point = point;
    }

    /**
     * Sets point.
     *
     * @param point the point
     */
    public void setPoint(Point point) {
        this.point = point;
    }

    /**
     * Gets point.
     *
     * @return the point
     */
    public Point getPoint() {
        return point;
    }
}
