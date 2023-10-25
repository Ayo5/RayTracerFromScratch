package main.java.coordinate;

/**
 * The Triplet class represents a three-dimensional vector or point with three coordinates (x, y, and z).
 * It provides various mathematical operations and utility methods for working with 3D vectors.
 */
public class Triplet {
    private double x;
    private double y;
    private double z;

    /**
     * Constructs a new Triplet object with the specified initial coordinates.
     *
     * @param x The X-coordinate of the triplet.
     * @param y The Y-coordinate of the triplet.
     * @param z The Z-coordinate of the triplet.
     */
    public Triplet(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Returns the X-coordinate of the triplet.
     *
     * @return The X-coordinate of the triplet.
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the Y-coordinate of the triplet.
     *
     * @return The Y-coordinate of the triplet.
     */
    public double getY() {
        return y;
    }

    /**
     * Returns the Z-coordinate of the triplet.
     *
     * @return The Z-coordinate of the triplet.
     */
    public double getZ() {
        return z;
    }

    /**
     * Sets the X-coordinate of the triplet to the specified value.
     *
     * @param x The new value for the X-coordinate.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets the Y-coordinate of the triplet to the specified value.
     *
     * @param y The new value for the Y-coordinate.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Sets the Z-coordinate of the triplet to the specified value.
     *
     * @param z The new value for the Z-coordinate.
     */
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * Returns a string representation of the triplet in the form "(x, y, z)".
     *
     * @return A string representation of the triplet.
     */
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    /**
     * Checks if this triplet is equal to another object.
     *
     * @param o The object to compare to this triplet.
     * @return true if the objects are equal, false otherwise.
     */
    public boolean equals(Object o) {
        if (o instanceof Triplet) {
            Triplet t = (Triplet) o;
            return x == t.x && y == t.y && z == t.z;
        }
        return false;
    }

    /**
     * Adds another triplet to this triplet and returns the result as a new triplet.
     *
     * @param t2 The triplet to add to this triplet.
     * @return A new triplet representing the addition of the two triplets.
     */
    public Triplet addition(Triplet t2) {
        return new Triplet(this.x + t2.x, this.y + t2.y, this.z + t2.z);
    }

    /**
     * Subtracts another triplet from this triplet and returns the result as a new triplet.
     *
     * @param t2 The triplet to subtract from this triplet.
     * @return A new triplet representing the subtraction of the two triplets.
     */
    public Triplet subtraction(Triplet t2) {
        return new Triplet(this.x - t2.x, this.y - t2.y, this.z - t2.z);
    }

    /**
     * Multiplies the triplet by a scalar value and returns the result as a new triplet.
     *
     * @param scalar The scalar value to multiply the triplet by.
     * @return A new triplet with scaled coordinates.
     */
    public Triplet multiplicationScalar(double scalar) {
        return new Triplet(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    /**
     * Computes and returns the dot product of this triplet and another triplet.
     *
     * @param t2 The other triplet for the dot product calculation.
     * @return The dot product of the two triplets.
     */
    public double dotScalar(Triplet t2) {
        return this.x * t2.x + this.y * t2.y + this.z * t2.z;
    }

    /**
     * Computes and returns the vectorial (cross) product of this triplet and another triplet.
     *
     * @param t2 The other triplet for the vectorial product calculation.
     * @return A new triplet representing the vectorial product of the two triplets.
     */
    public Triplet dotVectorial(Triplet t2) {
        return new Triplet(this.y * t2.z - this.z * t2.y, this.z * t2.x - this.x * t2.z, this.x * t2.y - this.y * t2.x);
    }

    /**
     * Computes and returns the Schur (element-wise) product of this triplet and another triplet.
     *
     * @param t2 The other triplet for the Schur product calculation.
     * @return A new triplet representing the Schur product of the two triplets.
     */
    public Triplet dotSchur(Triplet t2) {
        return new Triplet(this.x * t2.x, this.y * t2.y, this.z * t2.z);
    }

    /**
     * Calculates and returns the length (magnitude) of the triplet as a double value.
     *
     * @return The length (magnitude) of the triplet.
     */
    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    /**
     * Normalizes the triplet, making it a unit vector in the same direction, and returns the result as a new triplet.
     *
     * @return A new triplet representing the normalized (unit) vector.
     */
    public Triplet normalization() {
        double inverseLength = 1 / this.length();
        return multiplicationScalar(inverseLength);
    }
}
