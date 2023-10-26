
package main.java.light;

import main.java.math.Triplet;


public class Colors {
    private Triplet triplet;

    public Colors(double r, double g, double b) {
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

    public void setRGB(Triplet triplet) {
        this.triplet = triplet;
    }

    public Colors add(Colors other) {
        return new Colors(triplet.getX() + other.getR(), triplet.getY() + other.getG(), triplet.getZ() + other.getB());
    }

    public Colors multiply(double scalar) {
        return new Colors(triplet.getX() * scalar, triplet.getY() * scalar, triplet.getZ() * scalar);
    }

    public Colors schurProduct(Colors other) {
        return new Colors(triplet.getX() * other.getR(), triplet.getY() * other.getG(), triplet.getZ() * other.getB());
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

    public void isBlack() {
        triplet.setX(0) ;
        triplet.setY(0) ;
        triplet.setZ(0) ;
    }

}
