<<<<<<<< HEAD:src/main/java/sae301/PointLight.java
package sae301;
========
package main.java.scene;

import main.java.coordinate.Point;
import main.java.scene.Color;
import main.java.scene.Light;
>>>>>>>> 4823f2e9ab7300190fceef1fbaf6b39831c73335:src/main/java/scene/PointLight.java

public class PointLight extends Light {
    private Point position;
    private double intensity;

    public PointLight(Color color, Point position, double intensity) {
        super(color);
        this.position = position;
        this.intensity = intensity;
    }

    public Point getPosition() {
        return position;
    }

    public double getIntensity() {
        return intensity;
    }
}
