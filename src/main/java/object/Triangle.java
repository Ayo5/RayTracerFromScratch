package main.java.object;

import main.java.light.Colors;
import main.java.math.Point;
import main.java.math.Vector;

/**
 * The type Triangle.
 */
public class Triangle extends SceneObject {

    private Point p1;
    private Point p2;
    private Point p3;


    /**
     * Instantiates a new Triangle.
     *
     * @param p1    the p 1
     * @param p2    the p 2
     * @param p3    the p 3
     * @param color the color
     */
    public Triangle(Point p1, Point p2, Point p3, Colors color) {
        super(color);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;

    }

    /**
     * Sets p 1.
     *
     * @param p1 the p 1
     */
    public void setP1(Point p1) {
        this.p1 = p1;
    }

    /**
     * Sets p 2.
     *
     * @param p2 the p 2
     */
    public void setP2(Point p2) {
        this.p2 = p2;
    }

    /**
     * Sets p 3.
     *
     * @param p3 the p 3
     */
    public void setP3(Point p3) {
        this.p3 = p3;
    }

    /**
     * Gets p 1.
     *
     * @return the p 1
     */
    public Point getP1() {
        return p1;
    }

    /**
     * Gets p 2.
     *
     * @return the p 2
     */
    public Point getP2() {
        return p2;
    }

    /**
     * Gets p 3.
     *
     * @return the p 3
     */
    public Point getP3() {
        return p3;
    }


    @Override
    public double intersect(Point lookFrom, Vector d) {
        return 0;
    }

    @Override
    public Point intersectOnP(Point lookFrom, Vector d) {
        return null;
    }

    @Override
    public Vector createVectorN(Point lookFrom, Vector d) {
        return null;
    }
}
