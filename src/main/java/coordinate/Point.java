package main.java.coordinate;

/**
 * The Point class represents a three-dimensional point in space.
 * It is defined by its coordinates (x, y, and z) in a Cartesian coordinate system.
 */
public class Point {
    private Triplet triplet;

    /**
     * Constructs a new Point object with the specified coordinates.
     *
     * @param x The X-coordinate of the point.
     * @param y The Y-coordinate of the point.
     * @param z The Z-coordinate of the point.
     */
    public Point(double x, double y, double z) {
        this.triplet = new Triplet(x, y, z);
    }

    /**
     * Returns the X-coordinate of the point.
     *
     * @return The X-coordinate of the point.
     */
    public double getX() {
        return triplet.getX();
    }

    /**
     * Returns the Y-coordinate of the point.
     *
     * @return The Y-coordinate of the point.
     */
    public double getY() {
        return triplet.getY();
    }

    /**
     * Returns the Z-coordinate of the point.
     *
     * @return The Z-coordinate of the point.
     */
    public double getZ() {
        return triplet.getZ();
    }

    /**
     * Computes and returns a Vector that represents the subtraction of this point
     * from another point.
     *
     * @param point The Point to subtract from this point.
     * @return A Vector representing the subtraction of the two points.
     */
    public Vector subtract(Point point) {
        return new Vector(triplet.getX() - point.getX(), triplet.getY() - point.getY(), triplet.getZ() - point.getZ());
    }

    /**
     * Computes and returns a new Point that is the result of multiplying this point's
     * coordinates by a scalar value.
     *
     * @param scalar The scalar value to multiply the point's coordinates by.
     * @return A new Point with scaled coordinates.
     */
    public Point multiply(double scalar) {
        return new Point(triplet.getX() * scalar, triplet.getY() * scalar, triplet.getZ() * scalar);
    }
}
