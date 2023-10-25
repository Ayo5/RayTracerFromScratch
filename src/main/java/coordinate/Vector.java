<<<<<<<< HEAD:src/main/java/sae301/Vector.java
package sae301;
========
package main.java.coordinate;

>>>>>>>> 4823f2e9ab7300190fceef1fbaf6b39831c73335:src/main/java/coordinate/Vector.java
public class Vector {
    private Triplet triplet;

    public Vector(double x, double y, double z) {
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

    public Vector addition(Vector other) {
        return new Vector(triplet.getX() + other.getX(), triplet.getY() + other.getY(), triplet.getZ() + other.getZ());
    }

    public Vector subtraction(Vector other) {
        return new Vector(triplet.getX() - other.getX(), triplet.getY() - other.getY(), triplet.getZ() - other.getZ());
    }

    public Vector multiplicationScalar(double scalar) {
        return new Vector(triplet.getX() * scalar, triplet.getY() * scalar, triplet.getZ() * scalar);
    }

    public double dotScalar(Vector other) {
        return triplet.getX() * other.getX() + triplet.getY() * other.getY() + triplet.getZ() * other.getZ();
    }

    public Vector dotVectorial(Vector other) {
        return new Vector(
                triplet.getY() * other.getZ() - triplet.getZ() * other.getY(),
                triplet.getZ() * other.getX() - triplet.getX() * other.getZ(),
                triplet.getX() * other.getY() - triplet.getY() * other.getX()
        );
    }

    public Vector normalyze() {
        double opposed_lenght = (1 / this.lenght());
        return multiplicationScalar(opposed_lenght);
    }

    private double lenght() {
        return Math.sqrt(this.triplet.getX() * this.triplet.getX() + this.triplet.getY() * this.triplet.getY() + this.triplet.getZ()* this.triplet.getZ());
    }

}
