package main.java.scene;

import main.java.coordinate.Point;
import main.java.coordinate.Vector;

public class Camera {
    private Point position; // Position de la caméra (l'œil)
    private Point lookAt;   // Point regardé
    private Vector up;       // Vecteur vers le haut
    private double fov;     // Champ de vision

    public Camera(Point position, Point lookAt, Vector up, double fov) {
        this.position = position;
        this.lookAt = lookAt;
        this.up = up.normalyze(); // Assurez-vous que le vecteur vers le haut est normalisé
        this.fov = fov;
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
