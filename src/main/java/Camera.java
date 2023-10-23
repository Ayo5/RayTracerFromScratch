package main.java;

public class Camera {
    private Triplet position; // Position de la caméra (l'œil)
    private Triplet lookAt;   // Point regardé
    private Triplet up;       // Vecteur vers le haut

    public Camera(Triplet position, Triplet lookAt, Triplet up) {
        this.position = position;
        this.lookAt = lookAt;
        this.up = up.normalisation(); // Assurez-vous que le vecteur vers le haut est normalisé
    }

    public Triplet getPosition() {
        return position;
    }

    public Triplet getLookAt() {
        return lookAt;
    }

    public Triplet getUp() {
        return up;
    }

}
