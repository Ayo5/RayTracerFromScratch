package main.java;

import java.awt.*;

public class Material {
    private Color color;
    private double reflectivity;
    private double shininess;

    public Material(Color color, double reflectivity, double shininess) {
        this.color = color;
        this.reflectivity = reflectivity;
        this.shininess = shininess;
    }

    // Getters and setters for material properties
}
