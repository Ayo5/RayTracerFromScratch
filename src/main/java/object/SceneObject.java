package main.java.object;

import main.java.light.Colors;
import main.java.math.Point;
import main.java.math.Vector;


/**
 * The type Scene object.
 */
public abstract class SceneObject {
    private Colors color;

    /**
     * Instantiates a new Scene object.
     *
     * @param color the color
     */
    protected SceneObject(Colors color) {
        this.color = color;
    }

    /**
     * Intersect double.
     *
     * @param lookFrom the look from
     * @param d        the d
     * @return the double
     */
    public abstract double intersect(Point lookFrom, Vector d);

    /**
     * Gets color.
     *
     * @return the color
     */
    public Colors getColor() {
        return color;
    }

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(Colors color) {
        this.color = color;
    }


    /**
     * Intersect on p point.
     *
     * @param lookFrom the look from
     * @param d        the d
     * @return the point
     */
    public abstract Point intersectOnP(Point lookFrom, Vector d);

    /**
     * Create vector n vector.
     *
     * @param lookFrom the look from
     * @param d        the d
     * @return the vector
     */
    public abstract Vector createVectorN(Point lookFrom, Vector d);
}
