
package main.java.light;

import main.java.math.Triplet;


/**
 * The type Colors.
 */
public class Colors {
    private Triplet triplet;

    /**
     * Instantiates a new Colors.
     *
     * @param r the r
     * @param g the g
     * @param b the b
     */
    public Colors(double r, double g, double b) {
        this.triplet = new Triplet(r, g, b);
    }

    /**
     * Gets r.
     *
     * @return the r
     */
    public double getR() {
        return triplet.getX();
    }

    /**
     * Gets g.
     *
     * @return the g
     */
    public double getG() {
        return triplet.getY();
    }

    /**
     * Gets b.
     *
     * @return the b
     */
    public double getB() {
        return triplet.getZ();
    }

    /**
     * Sets rgb.
     *
     * @param triplet the triplet
     */
    public void setRGB(Triplet triplet) {
        this.triplet = triplet;
    }

    /**
     * Add colors.
     *
     * @param other the other
     * @return the colors
     */
    public Colors add(Colors other) {
        return new Colors(triplet.getX() + other.getR(), triplet.getY() + other.getG(), triplet.getZ() + other.getB());
    }

    /**
     * Multiply colors.
     *
     * @param scalar the scalar
     * @return the colors
     */
    public Colors multiply(double scalar) {
        return new Colors(triplet.getX() * scalar, triplet.getY() * scalar, triplet.getZ() * scalar);
    }

    /**
     * Schur product colors.
     *
     * @param other the other
     * @return the colors
     */
    public Colors schurProduct(Colors other) {
        return new Colors(triplet.getX() * other.getR(), triplet.getY() * other.getG(), triplet.getZ() * other.getB());
    }

    /**
     * To rgb int.
     *
     * @param value the value
     * @return the int
     */
    public int toRGB(double value) {
        int intValue = (int) (value * 255);
        return Math.min(255, Math.max(0, intValue));
    }

    /**
     * To rgb int.
     *
     * @return the int
     */
    public int toRGB() {
        int red = toRGB(getR());
        int green = toRGB(getG());
        int blue = toRGB(getB());
        return (red << 16) | (green << 8) | blue;
    }

    /**
     * Is black.
     */
    public void isBlack() {
        triplet.setX(0) ;
        triplet.setY(0) ;
        triplet.setZ(0) ;
    }

}
