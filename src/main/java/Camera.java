package main.java;

public class Camera {
    private Point position; // Position de la caméra (l'œil)
    private Point lookAt;   // Point regardé
    private Vector up;       // Vecteur vers le haut

    public Camera(Point position, Point lookAt, Vector up) {
        this.position = position;
        this.lookAt = lookAt;
        this.up = up.normalyze(); // Assurez-vous que le vecteur vers le haut est normalisé
    }

    public Point getPosition() {
        return position;
    }

    public Point getLookAt() {
        return lookAt;
    }

    public Vector getUp() {
        return up;
    }

}
