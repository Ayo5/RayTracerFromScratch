package main.java;

public class Ray {
    private Vector origin; // Origine du rayon
    private Vector direction; // Direction du rayon

    public Ray(Vector origin, Vector direction) {
        this.origin = origin;
        this.direction = direction; // Assurez-vous que la direction est normalisée
    }

    public Vector getOrigin() {
        return origin;
    }

    public Vector getDirection() {
        return direction;
    }

    public Vector pointAt(double t) {
        // Calcule un point le long du rayon à une distance t de l'origine
        return origin.addition(direction.multiplicationScalar(t));
    }
}
