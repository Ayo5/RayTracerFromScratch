package main.java.coordinate;

public class Point {
    private Triplet triplet;

    public Point(double x, double y, double z) {
        this.triplet = new Triplet(x, y, z);
    }

    public double getX() {
        return triplet.getX();
    }

    public double getY() {
        return triplet.getY();
    }

    public double getZ() {
        return triplet.getZ();
    }

    public Vector subtract(Point point) {
        return new Vector(triplet.getX() - point.getX(), triplet.getY() - point.getY(), triplet.getZ() - point.getZ());
    }

    public Point multiply(double scalar) {
        return new Point(triplet.getX() * scalar, triplet.getY() * scalar, triplet.getZ() * scalar);
    }
}
