
package main.java.scene;

import main.java.coordinate.Triplet;


public class Color {
    private Triplet triplet;

    public Color(double r, double g, double b) {
        this.triplet = new Triplet(r, g, b);
    }

    public double getR() {
        return triplet.getX();
    }

    public double getG() {
        return triplet.getY();
    }

    public double getB() {
        return triplet.getZ();
    }

    public Color add(Color other) {
        return new Color(triplet.getX() + other.getR(), triplet.getY() + other.getG(), triplet.getZ() + other.getB());
    }

    public Color multiply(double scalar) {
        return new Color(triplet.getX() * scalar, triplet.getY() * scalar, triplet.getZ() * scalar);
    }

    public Color schurProduct(Color other) {
        return new Color(triplet.getX() * other.getR(), triplet.getY() * other.getG(), triplet.getZ() * other.getB());
    }

    public int toRGB(double value) {
        int intValue = (int) (value * 255);
        return Math.min(255, Math.max(0, intValue));
    }

    public int toRGB() {
        int red = toRGB(getR());
        int green = toRGB(getG());
        int blue = toRGB(getB());
        return (red << 16) | (green << 8) | blue;
    }

    public boolean isBlack() {
        return triplet.getX() == 0.0 && triplet.getY() == 0.0 && triplet.getZ() == 0.0;
    }

}
