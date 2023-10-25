<<<<<<<< HEAD:src/main/java/sae301/Camera.java
package sae301;

========
package main.java.scene;

import main.java.coordinate.Point;
import main.java.coordinate.Vector;
>>>>>>>> 4823f2e9ab7300190fceef1fbaf6b39831c73335:src/main/java/scene/Camera.java

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
