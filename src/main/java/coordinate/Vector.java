package main.java.coordinate;

/**
 * The Vector class represents a three-dimensional vector in space.
 * It is defined by its coordinates (x, y, and z) and provides various vector operations.
 */
public class Vector {
    private Triplet triplet;

    /**
     * Constructs a new Vector object with the specified vector components.
     *
     * @param x The X-component of the vector.
     * @param y The Y-component of the vector.
     * @param z The Z-component of the vector.
     */
    public Vector(double x, double y, double z) {
        this.triplet = new Triplet(x, y, z);
    }

    /**
     * Returns the X-component of the vector.
     *
     * @return The X-component of the vector.
     */
    public double getX() {
        return triplet.getX();
    }

    /**
     * Returns the Y-component of the vector.
     *
     * @return The Y-component of the vector.
     */
    public double getY() {
        return triplet.getY();
    }

    /**
     * Returns the Z-component of the vector.
     *
     * @return The Z-component of the vector.
     */
    public double getZ() {
        return triplet.getZ();
    }

    /**
     * Adds another vector to this vector and returns the result as a new vector.
     *
     * @param other The vector to add to this vector.
     * @return A new vector representing the addition of the two vectors.
     */
    public Vector addition(Vector other) {
        return new Vector(triplet.getX() + other.getX(), triplet.getY() + other.getY(), triplet.getZ() + other.getZ());
    }

    /**
     * Subtracts another vector from this vector and returns the result as a new vector.
     *
     * @param other The vector to subtract from this vector.
     * @return A new vector representing the subtraction of the two vectors.
     */
    public Vector subtraction(Vector other) {
        return new Vector(triplet.getX() - other.getX(), triplet.getY() - other.getY(), triplet.getZ() - other.getZ());
    }

    /**
     * Multiplies the vector by a scalar value and returns the result as a new vector.
     *
     * @param scalar The scalar value to multiply the vector by.
     * @return A new vector with scaled components.
     */
    public Vector multiplicationScalar(double scalar) {
        return new Vector(triplet.getX() * scalar, triplet.getY() * scalar, triplet.getZ() * scalar);
    }

    /**
     * Computes and returns the dot product of this vector and another vector.
     *
     * @param other The other vector for the dot product calculation.
     * @return The dot product of the two vectors.
     */
    public double dotScalar(Vector other) {
        return triplet.getX() * other.getX() + triplet.getY() * other.getY() + triplet.getZ() * other.getZ();
    }

    /**
     * Computes and returns the vectorial (cross) product of this vector and another vector.
     *
     * @param other The other vector for the vectorial product calculation.
     * @return A new vector representing the vectorial product of the two vectors.
     */
    public Vector dotVectorial(Vector other) {
        return new Vector(
                triplet.getY() * other.getZ() - triplet.getZ() * other.getY(),
                triplet.getZ() * other.getX() - triplet.getX() * other.getZ(),
                triplet.getX() * other.getY() - triplet.getY() * other.getX()
        );
    }

    /**
     * Normalizes the vector, making it a unit vector in the same direction, and returns the result as a new vector.
     *
     * @return A new vector representing the normalized (unit) vector.
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
     * Calculates and returns the length (magnitude) of the vector as a double value.
     *
     * @return The length (magnitude) of the vector.
     */
    public double length() {
        return Math.sqrt(this.triplet.getX() * this.triplet.getX() + this.triplet.getY() * this.triplet.getY() + this.triplet.getZ() * this.triplet.getZ());
    }
}
