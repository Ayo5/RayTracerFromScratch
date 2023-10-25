<<<<<<<< HEAD:src/main/java/sae301/Ray.java
package sae301;
========
package main.java.scene;

import main.java.coordinate.Point;
import main.java.coordinate.Vector;
>>>>>>>> 4823f2e9ab7300190fceef1fbaf6b39831c73335:src/main/java/scene/Ray.java

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

}
