package main.java.scene;

import main.java.coordinate.Triplet;

/**
 * The Color class represents a color using RGB components.
 */
public class Color {
    private Triplet triplet;

    /**
     * Constructs a new Color with the specified RGB components.
     *
     * @param r The red component (in the range [0, 1]).
     * @param g The green component (in the range [0, 1]).
     * @param b The blue component (in the range [0, 1]).
     */
    public Color(double r, double g, double b) {
        this.triplet = new Triplet(r, g, b);
    }

    /**
     * Gets the red component of the color.
     *
     * @return The red component (in the range [0, 1]).
     */
    public double getR() {
        return triplet.getX();
    }

    /**
     * Gets the green component of the color.
     *
     * @return The green component (in the range [0, 1]).
     */
    public double getG() {
        return triplet.getY();
    }

    /**
     * Gets the blue component of the color.
     *
     * @return The blue component (in the range [0, 1]).
     */
    public double getB() {
        return triplet.getZ();
    }

    /**
     * Adds another color to this color, component-wise.
     *
     * @param other The color to add.
     * @return A new color resulting from the addition.
     */
    public Color add(Color other) {
        return new Color(triplet.getX() + other.getR(), triplet.getY() + other.getG(), triplet.getZ() + other.getB());
    }

    /**
     * Multiplies the color by a scalar value, component-wise.
     *
     * @param scalar The scalar value to multiply by.
     * @return A new color resulting from the multiplication.
     */
    public Color multiply(double scalar) {
        return new Color(triplet.getX() * scalar, triplet.getY() * scalar, triplet.getZ() * scalar);
    }

    /**
     * Computes the Schur product (component-wise multiplication) with another color.
     *
     * @param other The color to perform the Schur product with.
     * @return A new color resulting from the Schur product.
     */
    public Color schurProduct(Color other) {
        return new Color(triplet.getX() * other.getR(), triplet.getY() * other.getG(), triplet.getZ() * other.getB());
    }

    /**
     * Checks if the color is black (all components are 0).
     *
     * @return true if the color is black, false otherwise.
     */
    public boolean isBlack() {
        return triplet.getX() == 0.0 && triplet.getY() == 0.0 && triplet.getZ() == 0.0;
    }
}
