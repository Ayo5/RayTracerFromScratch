package main.java;

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


    public boolean isBlack() {
        return triplet.getX() == 0.0 && triplet.getY() == 0.0 && triplet.getZ() == 0.0;
    }

}
