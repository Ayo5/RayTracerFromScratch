package main.java.math;

/**
 * The type Vector.
 */
public class Vector {
    private Triplet triplet;

    /**
     * Instantiates a new Vector.
     *
     * @param x the x
     * @param y the y
     * @param z the z
     */
    public Vector(double x, double y, double z) {
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
     * Addition vector.
     *
     * @param other the other
     * @return the vector
     */
    public Vector addition(Vector other) {
        return new Vector(triplet.getX() + other.getX(), triplet.getY() + other.getY(), triplet.getZ() + other.getZ());
    }

    /**
     * Subtraction vector.
     *
     * @param other the other
     * @return the vector
     */
    public Vector subtraction(Vector other) {
        return new Vector(triplet.getX() - other.getX(), triplet.getY() - other.getY(), triplet.getZ() - other.getZ());
    }

    /**
     * Multiplication scalar vector.
     *
     * @param scalar the scalar
     * @return the vector
     */
    public Vector multiplicationScalar(double scalar) {
        return new Vector(triplet.getX() * scalar, triplet.getY() * scalar, triplet.getZ() * scalar);
    }

    /**
     * Dot scalar double.
     *
     * @param other the other
     * @return the double
     */
    public double dotScalar(Vector other) {
        return triplet.getX() * other.getX() + triplet.getY() * other.getY() + triplet.getZ() * other.getZ();
    }

    /**
     * Dot vectorial vector.
     *
     * @param other the other
     * @return the vector
     */
    public Vector dotVectorial(Vector other) {
        return new Vector(
                triplet.getY() * other.getZ() - triplet.getZ() * other.getY(),
                triplet.getZ() * other.getX() - triplet.getX() * other.getZ(),
                triplet.getX() * other.getY() - triplet.getY() * other.getX()
        );
    }

    /**
     * Normalize vector.
     *
     * @return the vector
     */
    public Vector normalize() {
        double length = this.length();
        if (length != 0) {
            double invLength = 1 / length;
            return this.multiplicationScalar(invLength);
        } else {
            return this;
        }
    }

    /**
     * Length double.
     *
     * @return the double
     */
    public double length() {
        return Math.sqrt(this.triplet.getX() * this.triplet.getX() + this.triplet.getY() * this.triplet.getY() + this.triplet.getZ()* this.triplet.getZ());
    }

    /**
     * Distance float.
     *
     * @param a the a
     * @param b the b
     * @return the float
     */
    public static float distance(Vector a, Vector b) {
        return (float) Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2) + Math.pow(a.getZ() - b.getZ(), 2));
    }

}


