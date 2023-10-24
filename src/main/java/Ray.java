package main.java;

public class Ray {
    private Point origin; // Origine du rayon
    private Vector direction; // Direction du rayon

    public Ray(Point origin, Vector direction) {
        this.origin = origin;
        this.direction = direction.normalyze(); // Assurez-vous que la direction est normalisée
    }

    public Point getOrigin() {
        return origin;
    }

    public Vector getDirection() {
        return direction;
    }

    public Point pointAt(double t) {
        // Calcule un point le long du rayon à une distance t de l'origine
        return origin.addition(direction.multiplicationScalar(t));
    }
}
