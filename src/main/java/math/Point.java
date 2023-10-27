package main.java.math;


/**
 * The type Point.
 */
public class Point {
    private Triplet triplet;

    /**
     * Instantiates a new Point.
     *
     * @param x the x
     * @param y the y
     * @param z the z
     */
    public Point(double x, double y, double z) {
        this.triplet = new Triplet(x, y, z);
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public double getX() {
        return triplet.getX();
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public double getY() {
        return triplet.getY();
    }

    /**
     * Gets z.
     *
     * @return the z
     */
    public double getZ() {
        return triplet.getZ();
    }

    /**
     * Subtract vector.
     *
     * @param point the point
     * @return the vector
     */
    public Vector subtract(Point point) {
        return new Vector(triplet.getX() - point.getX(), triplet.getY() - point.getY(), triplet.getZ() - point.getZ());
    }

    /**
     * Multiply point.
     *
     * @param scalar the scalar
     * @return the point
     */
    public Point multiply(double scalar) {
        return new Point(triplet.getX() * scalar, triplet.getY() * scalar, triplet.getZ() * scalar);
    }

    /**
     * Distance float.
     *
     * @param a the a
     * @param b the b
     * @return the float
     */
    public static float distance(Point a, Point b) {
        return (float) Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2) + Math.pow(a.getZ() - b.getZ(), 2));
    }

}
